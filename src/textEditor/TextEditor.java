package textEditor;
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

/*
 * TODO
 * 
 * ADD Remove all texts
 * ADD menus
 * METHOD changing text font and size
 * ADD saving files and opening files
 * ADD random generation of images during up booting
 * 
 * 
 * 
 * */


public class TextEditor {
	
	public static void main(String[] args) {
		System.out.println("Not to be referenced directly");
	}

	static JFrame mainFrame;
	static JTextArea mainArea = new JTextArea();

	@SuppressWarnings("static-access")
	public TextEditor (JFrame mainFrame, JTextArea mainArea) {
		this.mainFrame = mainFrame;
		this.mainArea = mainArea;
		
	}
	
	@SuppressWarnings("static-access")
	public static void textEditor() {
		
		TextModifier.modifyFontTextArea("Lucida Bright", Font.PLAIN, 14, mainArea);
		
//		JFrame mainFrame = new JFrame("Text Editor");
		mainFrame.setEnabled(true);
//		mainFrame.setName("Text Editor");
		mainFrame.setSize(1000, 600);
		mainFrame.setLocation(50, 50);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setBackground(Color.lightGray);
		mainFrame.setDefaultLookAndFeelDecorated(true);

//		big textField
		int fieldWidth = mainFrame.getSize().width-5;
		int fieldHeight = mainFrame.getSize().height-5;
		mainArea.setBounds(5, 5, fieldWidth, fieldHeight);
		
//		menubar
		MenuClass.mainMenuBar(mainFrame);
		
//		create a Menu called file
		MenuClass.fileMenu(MenuClass.mainMenuBar);	
//		second menubar
		MenuClass.optionMenu(MenuClass.mainMenuBar);
//		menuItem for Options
		MenuClass.menuItemOption();
//		MenuItem for files
		MenuClass.menuItemFile();
		
		
		
		mainFrame.add(mainArea);
		mainArea.setWrapStyleWord(true);
		mainArea.setLineWrap(true);
		mainFrame.setLayout(null);
		mainFrame.setVisible(true);
		
		TaskThread task = new TaskThread(false);
		Thread resizeThread = new Thread(task);
		resizeThread.setName("<<Name>> resizeThread Java Sam TextEditor <<ID>> " + resizeThread.getId());
		resizeThread.start();
	}
	
}
