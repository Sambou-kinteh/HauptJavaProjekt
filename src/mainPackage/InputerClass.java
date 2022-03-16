package mainPackage;
import java.util.Scanner;

public class InputerClass {
	
	public static void main (String[] args) {/*HAUPTEIL - MAIN FUNCTION*/InputerClass.inputerString();}
	
	public static Scanner scanner = new Scanner(System.in);
	
	@SuppressWarnings("all")
	public static int inputerInt() {
		int input = scanner.nextInt();
//		scanner.close();
		return input;
	}
	@SuppressWarnings("all")
	public static String inputerString() {
		String input = scanner.nextLine();
//		scanner.close();
//		System.out.println(input.getClass() == String.class);
//		System.out.println(input instanceof String);
		System.out.println(input.getClass());
		return input;
	}
	@SuppressWarnings("all")
	public static double inputerDouble() {
		double input = scanner.nextDouble();
//		scanner.close();
		return input;
	}
	
	public static void closeInputer(boolean condition) {
		if (condition == true) {
			scanner.close();
		}else {System.out.println("Close not confirmed");}
	}

}
