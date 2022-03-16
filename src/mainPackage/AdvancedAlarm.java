package mainPackage;
import java.time.*;


public class AdvancedAlarm {
	
	public static void main(String[] args) {
		System.out.println("Willkommen zu meinem grossen Projekt");
		System.out.print("Bitte tragen Sie Uhrzeit ein: ");
		int alarmStunde = InputerClass.inputerInt();
		System.out.print("Bitte tragen Sie Minuten ein: ");
		int alarmMinute = InputerClass.inputerInt();
		
		AdvancedAlarm.setAlarm(alarmStunde, alarmMinute);
		
	}
	
	public static void setAlarm(int alarmStunde, int alarmMinute) {
		
		boolean steuerung = false;
		while (!steuerung) {
			int aktuelleStunde = LocalTime.now().getHour();
			int aktuelleMinute = LocalTime.now().getMinute();
//			int aktuelleSeconde = LocalTime.now().getSecond();
			
			if (aktuelleStunde == alarmStunde && aktuelleMinute == alarmMinute) {
				System.out.println("IT'S TIME");
				int incrementor = 0;
				String path = "C://Users/Sambou/Desktop/Java Projekte/MeinProjekt/audio/";
				while (incrementor < 10) {
					AudioAbspieler.abspieler(path + "alarmAudio.wav");
//					try {
//						Thread.sleep(1500);
//					}catch (Exception e) {
//						e.printStackTrace();
//					}
					incrementor++;
				}
				
				System.out.print("Wollen Sie snoozen(j = 0 / n = alles andere)? ");
				int bestaetigung = InputerClass.inputerInt();
				if (bestaetigung == 0) {
					steuerung = true;
					AdvancedAlarm.snooze();
				}else {
					steuerung = true;
					System.out.println("\nDanke für Ihren Nutz des Systems!!!");
					InputerClass.closeInputer(true);
					}
				
			}else {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Nicht eingetroffen\n"+LocalTime.now()+"\n");
			}
		}
	}
	
	
	public static void snooze() {
		
		System.out.print("Wie lange soll's dauern(in Minuten): ");
		int dauerZeit = InputerClass.inputerInt();
		
		int aktuelleStunde = LocalTime.now().getHour();
		int aktuelleMinute = LocalTime.now().getMinute();	
		
		int alarmMinute = dauerZeit + aktuelleMinute;
		int alarmStunde = aktuelleStunde;
		if (alarmMinute >= 60 && alarmMinute < 120) {
			alarmMinute = alarmMinute - 60;
			if (aktuelleStunde == 24 || aktuelleStunde == 00) {
				alarmStunde = 01;
			}else {alarmStunde++;}
			
		}else {
			if (alarmMinute >= 120) {
//				probleme koennen hier schnell auftauchen
				int wieViel60 = Math.round(alarmMinute/60);
				alarmMinute = alarmMinute - wieViel60*60;
				
				if (aktuelleStunde == 24 || aktuelleStunde == 00) {
					alarmStunde = wieViel60;
				}else {
					alarmStunde = aktuelleStunde + wieViel60;					
				}
				
			}else {
				alarmMinute = dauerZeit + LocalTime.now().getMinute();				
			}
		}
		
		AdvancedAlarm.setAlarm(alarmStunde, alarmMinute);
		
		
		
	}

}
