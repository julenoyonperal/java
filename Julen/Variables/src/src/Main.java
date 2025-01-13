package src;


public class Main {

	public static void main(String[] args) {
        System.out.println("Hello, World!");
        
        
        PrintName.printName("hola");
    
        System.out.println("|----------------------------|");
 
        PrintName.printAllOrOne(0);

        System.out.println("|----------------------------|");
        
        PrintName.printAllOrOne(1);

        System.out.println("|----------------------------|");        
        
        PrintName.printAllOrOne(2);
	
        System.out.println("|----------------------------|");     
        
        PrintName.printAllOrOne(3);
    	
        System.out.println("|----------------------------|");      
        
        PrintName.printSum(null);
//        
//        String result = SumPrint.SumAndPrint(2, 3);
//	
//        System.out.println(result);
	}

}