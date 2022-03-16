package mainPackage;

public class QuadratischeGleichung {
	
	public static void main(String[] args) {
//		ruf die funktion auf
		bearbeiter();
		
	}
	

	public static void bearbeiter() {
//		versuchen die Nummer herauszuholen
		System.out.print("Bitte geben Sie a,b und c an:\n>> ");
		int erste = InputerClass.inputerInt();
		System.out.print(">> ");
		int zweite = InputerClass.inputerInt();
		System.out.print(">> ");
		int dritte = InputerClass.inputerInt();
		
		System.out.println(loeser(erste, zweite, dritte));
		
//		chance nochmal zu versuchen
		System.out.print("Wollen Sie weiter(0/1): ");
		int bestaetigungJN = InputerClass.inputerInt();
		
		if (bestaetigungJN == 0) {
			bearbeiter();
			
		}else {
			InputerClass.closeInputer(true);
			System.out.println("Vielen Danke f�r Ihren Nutz des Systems");
		}
		
	}
	
	public static String loeser( int a, int b, int c) {
//		funktion, die alles einkalkuliert
		double sqrtInTheMiddle = Math.sqrt(Math.pow(b, 2) - (4*a*c));
		double ergebnisEins = (-b + sqrtInTheMiddle) / 2*a;
		double ergebnisZwei = (-b - sqrtInTheMiddle) / 2*a;
		
		if (String.valueOf(ergebnisEins) == "NaN" || String.valueOf(ergebnisZwei) == "NaN") {
			return "Entschuldigung! Ihre Gleichung ist nicht loesbar";
			
		}else {
			return "Ergebnisse:\nx1: " + ergebnisEins + "\nx2: " + ergebnisZwei;			
		}
			
	} 

}
