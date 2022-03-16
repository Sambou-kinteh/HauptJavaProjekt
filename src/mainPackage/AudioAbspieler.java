package mainPackage;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioAbspieler {
	
	public static void main(String[] args) {
		//HAUPTFUNKTION -- NUR ZUM FAULENZEN :)
	}
	
	public static void abspieler(String soundFile) {
		File audioFile = new File(soundFile);
		AudioInputStream audioStream;
		try {
			audioStream = AudioSystem.getAudioInputStream(audioFile);
			AudioFormat format = audioStream.getFormat();
			DataLine.Info info = new DataLine.Info(Clip.class, format);
			
			Clip audioClip = (Clip) AudioSystem.getLine(info);
			
			audioClip.open(audioStream);
			audioClip.start();
			
			try  {
				Thread.sleep(1500);
			}catch (Exception e) {
				e.printStackTrace();
			}
			audioClip.close();
			audioStream.close();
			
		} catch (UnsupportedAudioFileException | IOException e) {
			System.out.println("Format der Datei ist nicht unterstuetzt!! oder konnte nicht gespielt werden.\n");
			e.printStackTrace();
		}catch (LineUnavailableException e) {
			System.out.println("Audiolinea fürs Abspielen ist nicht vorhanden");
			e.printStackTrace();
		}
	}

}
