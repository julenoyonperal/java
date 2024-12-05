package dev.lpa;

public class Parent {

    static {
        System.out.println("Parent static initializer: class being constructed");
    }

    private final String name;
    private final String dob;

    protected final int siblings;

    {
//        name = "John Doe";
//        dob = "01/01/1900";
        System.out.println("In Parent Initializer");
    }

//    public Parent() {
//        System.out.println("In Parent's No Args Constructor");
//    }

    public Parent(String name, String dob, int siblings) {
        this.name = name;
        this.dob = dob;
        this.siblings = siblings;
        System.out.println("In Parent Constructor");
    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +", dob='" + dob+ '\'';
    }
}
