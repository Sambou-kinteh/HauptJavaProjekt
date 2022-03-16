package textEditor;

import javax.swing.*;

class TaskThread implements Runnable {

	boolean shouldStop;
	
	public TaskThread(boolean shouldStop) {
		this.shouldStop = shouldStop;
	}
	
	
	@Override
	public void run() {
	
		System.out.println("Thread Started");
//		referencing the object mainFrame and mainArea in the class TextEditor
		JFrame mainFrame = TextEditor.mainFrame;
		JTextArea mainArea = TextEditor.mainArea;
		
		int preSizeHeight = mainFrame.getSize().height;
		int preSizeWidth = mainFrame.getSize().width;
		
		while(!shouldStop) {
			if (preSizeHeight != mainFrame.getSize().height || preSizeWidth != mainFrame.getSize().width) {
				mainArea.setSize(mainFrame.getSize().width, mainFrame.getSize().height);
//				System.out.println("Size modified successfully");
			}else {System.out.println("");}
		}
		
		System.out.println("^Thread has ended");
		
	}
	
	public void stop() {
		shouldStop = true;
	}

	
}

