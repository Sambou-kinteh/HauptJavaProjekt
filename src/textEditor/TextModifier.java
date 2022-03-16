package textEditor;

import java.awt.*;
import javax.swing.*;

public class TextModifier  {
	
	public static void main(String[] args) {
		System.out.println("Not to be called directly");
	}
	
	
	public static void modifyFontTextArea(String fontFamily, int fontStyle, int fontSize, JTextArea textArea) {
		
		Font fontObj = new Font(fontFamily, fontStyle, fontSize);
		textArea.setFont(fontObj);
//		textArea.updateUI();
		
	}
	
	public static void modifyFontLabel(String fontFamily, int fontStyle, int fontSize, JLabel label) {
		
		Font fontObj = new Font(fontFamily, fontStyle, fontSize);
		label.setFont(fontObj);
	}
	
	public static void modifyColorPanel(int r, int g, int b, JPanel panel) {
		
		Color colorObj = new Color(r, g, b);
		panel.setBackground(colorObj);
	}
	
	public static void modifyColorMenuItem(int r, int g, int b, JMenuItem menuItem) {
		
		Color colorObj = new Color(r, g, b);
		menuItem.setBackground(colorObj);
	}
	
	public static void modifyFontMenu(String fontFamily, int fontStyle, int fontSize, JMenu menu) {
		
		Font fontObj = new Font(fontFamily, fontStyle, fontSize);
		menu.setFont(fontObj);
	}
	
	public static void modifyFontMenuItem(String fontFamily, int fontStyle, int fontSize, JMenuItem menuItem) {
		
		Font fontObj = new Font(fontFamily, fontStyle, fontSize);
		menuItem.setFont(fontObj);
	}

}
