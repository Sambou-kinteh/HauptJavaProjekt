package mainPackage;
import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.*;

public class RatenSpiel {

	static int zufaelligeNummer = ThreadLocalRandom.current().nextInt(0,100+1);
	static int nummerVonAnlauf = 1;
	
	public static void main(String[] args) {
		openGraphicInterface();
	}
	
	@SuppressWarnings("static-access")
	public static void openGraphicInterface() {
		JFrame mainFrame = new JFrame("Ratenspiel");
		mainFrame.setSize(500, 400);
		mainFrame.setBackground(Color.red);
		mainFrame.setLocation(100, 150);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setDefaultLookAndFeelDecorated(true);
		
//		neue Menueliste
		JMenuBar menuBar = new JMenuBar();

//		neue HauptMenue
		JMenu mainMenu = new JMenu("Optionen");
		mainMenu.setMnemonic(KeyEvent.VK_A);
		mainMenu.getAccessibleContext().setAccessibleDescription("Optionen anzusehen");
		
//		neue JMenuItem Versuchen
		JMenuItem menuItemVersuchen = new JMenuItem("Neue Zufallsnummer", KeyEvent.VK_T);
		
//		neue JMenuItem Exit
		JMenuItem menuItemExit = new JMenuItem("Exit", KeyEvent.VK_T);
		
		
		
		
		
		//Texte mit JLable hinzufuegen
		JLabel text = new JLabel("Bitte geben Sie eine beliebige Zahl von 0-100 an");
		text.setBounds(50, 60, 350, 30);
		
		//TextFlield hinzufuegen
		JTextField textField = new JTextField();
		textField.setBounds(50, 100, 200, 30);
		
		//zweitesTextFlield hinzufuegen
		JLabel textErgebnis = new JLabel();
		textErgebnis.setBounds(50, 135, 350, 30);
		textErgebnis.setBackground(Color.lightGray);
		
		//neuen Button hinzufuegen
		JButton startButton = new JButton("Raten");
		startButton.setBounds(50, 170, 200, 30);
		
		//actionListener hinzufuegen
		startButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//wird geschechen automatisch, sobald auf den Button geklickt wird
				raten(textField, textErgebnis);
				textField.setText("");
				
			}
			
		});
		
//		actionListener fuer den Artikel menuItemExit
		menuItemExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
//		actionListener fuer den Artikel menuItemVersuchen
		menuItemVersuchen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				zufaelligeNummer = ThreadLocalRandom.current().nextInt(0, 100+1);
				textErgebnis.setText("");
			}
		});
		
		mainFrame.add(text);
		mainFrame.add(textField);
		mainFrame.add(startButton);	
		mainFrame.add(textErgebnis);
		menuBar.add(mainMenu);
		mainFrame.setJMenuBar(menuBar);
		mainMenu.add(menuItemVersuchen);
		mainMenu.add(menuItemExit);
		//sehr wichtig, um die eigene Umformungen sehen zu k�nnen
		mainFrame.setLayout(null);
		//um die Inhalte sehen zu k�nnen
		mainFrame.setVisible(true);;
		
	}
	
	public static String istEsNahDran(int firstNumber, int secondNumber) {
		
		if (Math.abs(firstNumber - secondNumber) < 10) {
			return "Du bist sehr nah dran.";
			
		}else {
			return "Nicht nah aneinander.";
			
			
		}
		
	}
	
	public static void raten(JTextField textFieldObj, JLabel textFinalObj) {
		int geschaetzteNummer = 0;
		try {
			geschaetzteNummer = Integer.valueOf(textFieldObj.getText());
		}catch (Exception e) {
			e.printStackTrace();
			textFinalObj.setText("Bitte versuchen Sie nur Zahlen von 0-100 anzugeben");
		}
		
		if (geschaetzteNummer == zufaelligeNummer) {
			textFinalObj.setText("Du hast richtig gesch�tzt. Programm endet!!! ANLAEUFE: " + nummerVonAnlauf);
			
		}else {
			
			if (zufaelligeNummer > geschaetzteNummer) {
				textFinalObj.setFont(null);
				textFinalObj.setText(istEsNahDran(zufaelligeNummer, geschaetzteNummer) + " Angabe ist kleiner");
				nummerVonAnlauf++;
				
			}else {
				textFinalObj.setText(istEsNahDran(zufaelligeNummer, geschaetzteNummer) + " Angabe ist gro�er");
				nummerVonAnlauf++;
			}
		
		}

	}
	
//	public static void nochmalVersuchen(JButton ratenButton, JTextField textFieldObj, JLabel textFinalObj) {
//		
//		ratenButton.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				raten(textFieldObj, textFinalObj, ratenButton);
//			}
//		});
		
//	}
	
}
