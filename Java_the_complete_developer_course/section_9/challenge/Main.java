import java.util.ArrayList;
import java.util.Scanner; 

public class Main {


    public static void main(String[] args) {

        System.out.println(
                "Please select an options: \n" +
                        " 0 - Shutdown \n" +
                        " 1 - add item to a list \n" +
                        " 2 - remove any item \n" +
                        "Enter a number to select action: 0, 1, 2 \n");
 
        Scanner answer = new Scanner(System.in);
        String answer_string = answer.next();
        String output;
        ArrayList<String> my_list_shop = new ArrayList<String>();

        output = switch (answer_string) {
            case "0" -> {
                System.out.println("We are going to close thed progrdam.");
                my_list_shop.add("Volvo");
                yield "case 0";
            }
            default -> {
                System.out.println("this is not an option please try again");
                yield "default";
            }       
        };
        
        System.out.println(output);

        System.out.println("test");

    }    
}
