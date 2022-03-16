package textEditor;

import java.awt.Font;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class WelcomeFrame {
	
	public static void main(String[] args) {
		welcomeScreen();
		//String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		//		for (int i = 0; i < fonts.length; i++) {
		//			System.out.println(fonts[i]);
	}
	
	@SuppressWarnings("static-access")
	public static void welcomeScreen() {
		
		JFrame welcomeFrame = new JFrame("Sam-Editor 4.0");
		welcomeFrame.setDefaultLookAndFeelDecorated(true);

		JLabel welcomeText = new JLabel();
		welcomeText.setText("Willkommen zu Sam-Editor 4.0");
//		TextModifier.modifyFontLabel("Cambria", Font.PLAIN, 17, welcomeText);
		TextModifier.modifyFontLabel("Times New Roman", Font.ITALIC, 18, welcomeText);
		
//		add a JWindow method
		JWindow welcomeWindow = new JWindow(welcomeFrame);
		
		welcomeWindow.setSize(600, 400);
		welcomeWindow.setLocation(475, 175);
		
//		create a jpanel
		JPanel welcomePanel = new JPanel();
		welcomePanel.setSize(245, 30);
		welcomePanel.setLocation(186, 164);		
		TextModifier.modifyColorPanel(181, 135, 24, welcomePanel);
		
		
		JPanel mainPanel = new JPanel();
		mainPanel.setSize(100, 175);
		TextModifier.modifyColorPanel(215, 170, 50, mainPanel);
		
		
//		welcomeFrame.add(welcomeText);
		welcomePanel.add(welcomeText);
		welcomeWindow.add(welcomePanel);
		mainPanel.add(new JLabel(new ImageIcon("C://Users/Sambou/Desktop/Java Projekte/MeinProjekt/images/textEdiFoto.jpg")));
		welcomeWindow.add(mainPanel);
		welcomeWindow.setVisible(true);
		welcomeFrame.setEnabled(false);
		welcomeFrame.setLayout(null);
		
		try {
			Thread.sleep(3000);
			
		}catch (Exception e) {
//			e.printStackTrace();
		}
		
		//to close the window
		welcomeFrame.dispatchEvent(new WindowEvent(welcomeFrame, WindowEvent.WINDOW_CLOSING));
		
//		create an instance of the object TextEditor (creating an Object TextEditor)
		JTextArea mainArea = new JTextArea();
//		JFrame newWelcomeFrame = new JFrame();
//		
		TextEditor callTextEditor = new TextEditor(welcomeFrame, mainArea);
		callTextEditor.textEditor();
		
		welcomeWindow.setVisible(false);
		welcomeWindow.dispatchEvent(new WindowEvent(welcomeWindow, WindowEvent.WINDOW_CLOSING));
		
	}

}
