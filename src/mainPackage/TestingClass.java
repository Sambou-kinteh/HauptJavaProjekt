package mainPackage;

public class TestingClass {

//	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
//		int ersteNummer = InputerClass.inputerInt();
//		int zweiteNummer = InputerClass.inputerInt();
//		System.out.println(MeineErsteFunktion(ersteNummer, zweiteNummer));
		String g[] = {"3", "m"};
		String f = "4";
		System.out.println(g.getClass());
		System.out.println(f.getClass());
		
	}
	
	
	public static int MeineErsteFunktion (int x, int y){
		
		int ergebnis = x-y;
		
		if (ergebnis < 3) {
			return Math.abs(ergebnis) + 1;
			
		}else {
			return Math.abs(ergebnis);	
			
		}
		
	}

}
