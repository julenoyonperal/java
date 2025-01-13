package src;
import java.util.ArrayList; // import the ArrayList class

public class PrintName {
	
//	String names = ["Alice", "Bob", "Charlie", "Diana"];

    
	public static void printName(String name) {
		System.out.println("Your name is: " + name);
	}

	
    public static void printAllOrOne(int option) {
    	
    	
    	
		ArrayList<String> names = new ArrayList<String>(); 
		names.add("Volvo");
		names.add("BMW");
		names.add("Ford");
		names.add("Mazda");	
		
        if (option == 1) {
            // Print the first name
            System.out.println("Option 1 - Your name is: " + names);
        } else if (option == 2) {
            // Print all names in a loop
            System.out.println("Option 2 - All names are:");
            for (String name : names) {
                System.out.println(name);
            }
        } else if (option == 3) {
        	 System.out.println("Option 3 - Your name is: " + names.get(0) );
        	 try{
        		 System.out.println("Option 3- out limits - Your name is: " + names.get(5) );
        	 } catch(Exception e) {
        		 System.out.println("fuera del systema capullo" ); 
        	 }
        } else {
            System.out.println("Invalid option! Please pass 1 or 2.");
        }
    }

    
    String result = SumPrint.SumAndPrint(2, 3);

    public static void printSum(String result) {
		System.out.println("(From PrintName class) " + result);
    }

}
