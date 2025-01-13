package src;

public class SumPrint {
	
	
	public static String SumAndPrint(int num1, int num2) {
		
		int total = num1 + num2;
		
		String total_str = "The total is" + total;
		
		System.out.println("Printing from inside function: " + total_str);
		
		return total_str;		
		
	}

}
