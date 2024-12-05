public class Main {

    public static void main(String[] args) {

        Customer customer = new Customer(
            "Tim"
            ,1000
            ,"tim@email.com");
        System.out.println(customer.getName());
        System.out.println(customer.getCreditLimit());
        System.out.println(customer.getEmail());

        Customer secondCustomer = new Customer();
        System.out.println(secondCustomer.getName());
        System.out.println(secondCustomer.getCreditLimit());
        System.out.println(secondCustomer.getEmail());

        Customer thirdCustomer = new Customer("Kepa", "joe@email.com");
        System.out.println(thirdCustomer.getName());
        System.out.println(thirdCustomer.getCreditLimit());
        System.out.println(thirdCustomer.getEmail());


        Customer fourthCustomer = new Customer("Kepa");
        System.out.println(fourthCustomer.getName());
        System.out.println(fourthCustomer.getCreditLimit());
        System.out.println(fourthCustomer.getEmail());
    }
}
