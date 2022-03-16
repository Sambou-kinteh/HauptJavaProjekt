package textEditor;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class MenuClass {

	public static void main() {
		System.out.println("Not to be called directly");

	}

	/*
	 * Public Variables that will be needed throughout the class
	 *
	 * */
	static JMenuBar mainMenuBar;
	static JMenu fileMenu;
	static JMenuItem openFile;
	static JMenu optionMenu, editTextSize, editTextFont, editTextStyle;
	static JMenuItem menuItemFontObj, menuItemSizeObj, menuItemStyleObj;
	static int DEFAULTCOLOROFMENUITEMS = -7237231;
	static int RCOLOREDMENUITEM = 145,GCOLOREDMENUITEM = 145,BCOLOREDMENUITEM = 145;
	
//	font option variables
	static JMenuItem optionOne = new JMenuItem(), optionTwo = new JMenuItem(), optionThree = new JMenuItem(), 
			optionFour = new JMenuItem(), optionFive = new JMenuItem(), optionSix = new JMenuItem(), 
			optionSeven = new JMenuItem();
	static JMenuItem[] menuItemFontObjs = {optionOne, optionTwo, optionThree, optionFour, optionFive, optionSix, optionSeven};

//	font size option variables
	static JMenuItem optionSize1 = new JMenuItem(), optionSize2 = new JMenuItem(), optionSize3 = new JMenuItem(),
			optionSize4 = new JMenuItem(), optionSize5 = new JMenuItem(), optionSize6 = new JMenuItem(), optionSize7 = new JMenuItem(),
					optionSize8 = new JMenuItem(), optionSize9 = new JMenuItem(), optionSize10 = new JMenuItem();
	static JMenuItem[] menuItemSizeObjs = {optionSize1, optionSize2, optionSize3, optionSize4, optionSize5, optionSize6, optionSize7,
			optionSize8, optionSize9, optionSize10};
	
//	font style option variables
	static JMenuItem optionStyle1 = new JMenuItem(), optionStyle2 = new JMenuItem(), optionStyle3 = new JMenuItem();
	static JMenuItem[] menuItemStyleObjs = {optionStyle1, optionStyle2, optionStyle3};
	
	
//	main manubar method
	public static void mainMenuBar(JFrame mainFrame) {
		mainMenuBar = new JMenuBar();
		mainFrame.setJMenuBar(mainMenuBar);
	}
	
	public static void fileMenu(JMenuBar mainMenuBar) {
		
		fileMenu = new JMenu("File");
		TextModifier.modifyFontMenu("Berlin Sans", Font.BOLD, 13, fileMenu);
//		JMenu
		fileMenu.setMnemonic(KeyEvent.VK_A);
		fileMenu.getAccessibleContext().setAccessibleDescription("File");
		
		mainMenuBar.add(fileMenu);
	}
	
	public static void optionMenu(JMenuBar mainMenuBar) {
		optionMenu = new JMenu("Option");
		TextModifier.modifyFontMenu("Berlin Sans", Font.BOLD, 13, optionMenu);
		optionMenu.setMnemonic(KeyEvent.VK_A);
		mainMenuBar.add(optionMenu);
	}
	
	public static void menuItemFile() {
		openFile = new JMenuItem("Open file");
		
		
		fileMenu.add(openFile);
	}
	
	public static void menuItemOption() {
		editTextSize = new JMenu("Font Size");
		editTextFont = new JMenu("Font Family");
		editTextStyle = new JMenu("Font Sytle");

//		iterator for the fonts array
		
		String[] fonts = {"Arial", "Calibri", "Cambria", "Garamond", "Rockwell", "Times New Roman", "Verdana"};

		for (int i = 0; i < fonts.length; i++) {
			String font = fonts[i];
			menuItemFontObj = menuItemFontObjs[i];
			menuItemFontObj.setText(font);
			
//			to every entry / in every iteration, there will be a funtion change font attachted to it on click.
			menuItemFontObj.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					TextModifier.modifyFontTextArea(font, TextEditor.mainArea.getFont().getStyle(),
							TextEditor.mainArea.getFont().getSize(), TextEditor.mainArea);
//					run the check algorith and change the color of the intended MenuItem object programmatically
					MenuClass.removeColor(true, 1);
					MenuClass.optionCheck(font, RCOLOREDMENUITEM, GCOLOREDMENUITEM, BCOLOREDMENUITEM, 1);
				}
			});
			
			editTextFont.add(menuItemFontObj);
		}

//		iterator for the font size array
		String[] fontSizes = {"11", "12", "14", "16", "18", "20", "24", "30", "45", "50"};
		for (int i = 0; i < fontSizes.length ; i++) {
			String fontSize = fontSizes[i];
			menuItemSizeObj = menuItemSizeObjs[i];
			menuItemSizeObj.setText(fontSize);
			
			menuItemSizeObj.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					TextModifier.modifyFontTextArea(TextEditor.mainArea.getFont().getFontName(), 
							TextEditor.mainArea.getFont().getStyle(), Integer.parseInt(fontSize), TextEditor.mainArea);
					MenuClass.removeColor(true, 2);
					MenuClass.optionCheck(fontSize, RCOLOREDMENUITEM, GCOLOREDMENUITEM, BCOLOREDMENUITEM, 2);
				}
			});
			
			editTextSize.add(menuItemSizeObj);
		}
		
//		iterator for the font style array
		String[] fontStyles = {"Bold", "Italic", "Plain"};
		int[] fontStyleObjs = {Font.BOLD, Font.ITALIC, Font.PLAIN};
		for (int i = 0; i < fontStyles.length; i++) {
			int fontStyle = fontStyleObjs[i];
			String fontStyleText = fontStyles[i];
			menuItemStyleObj = menuItemStyleObjs[i];
			menuItemStyleObj.setText(fontStyleText);
			
			menuItemStyleObj.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					TextModifier.modifyFontTextArea(TextEditor.mainArea.getFont().getFontName(), 
							fontStyle, TextEditor.mainArea.getFont().getSize(), TextEditor.mainArea);
					MenuClass.removeColor(true, 3);
					MenuClass.optionCheck(fontStyleText, RCOLOREDMENUITEM, GCOLOREDMENUITEM, BCOLOREDMENUITEM, 3);
				}
			});
			
			editTextStyle.add(menuItemStyleObj);
		}

		
		optionMenu.add(editTextSize);
		optionMenu.add(editTextFont);		
		optionMenu.add(editTextStyle);		
	}
	
//	find and change the color of the object menuObj -- see the implementation
	public static void optionCheck(String fontOrFontSize, int r, int g, int b, int menuObj) {
		JMenuItem[] itemToModify = null;

		switch (menuObj) {
		case 1:
			itemToModify = menuItemFontObjs;
			break;

		case 2:
			itemToModify = menuItemSizeObjs;
			break;
		case 3: 
			itemToModify = menuItemStyleObjs;
			break;
		}

		assert itemToModify != null;
		for (JMenuItem jMenuItem : itemToModify) {
			if (fontOrFontSize.equals(jMenuItem.getText())) {
				TextModifier.modifyColorMenuItem(r, g, b, jMenuItem);
				break;

			} else {
				System.out.println("\nNo way." + " Text: " + jMenuItem.getText() + " " + fontOrFontSize);
			}
		}
	}
	
//	find and change the color of the object menuObj to the default
	public static void removeColor(boolean accept, int menuObj) {
		
		JMenuItem[] itemToModify = null;

		switch (menuObj) {
		case 1:
			itemToModify = menuItemFontObjs;
			break;

		case 2:
			itemToModify = menuItemSizeObjs;
			break;
		case 3: 
			itemToModify = menuItemStyleObjs;
			break;
		}
		
		if (accept) {
			assert itemToModify != null;
			for (JMenuItem jMenuItem : itemToModify) {
				if (jMenuItem.getBackground().getRGB() == DEFAULTCOLOROFMENUITEMS) {
					TextModifier.modifyColorMenuItem(238, 238, 238, jMenuItem);
					break;
				}
			}			
		}			
	}
	
}
