class Person {
    private String name;
    private int age;
    private String address;

    public Person() {
        this.name = "Harsh";
        this.age = 19;
        this.address = "SRMIST Hostels";
    }

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public void displayPersonInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
    }

    public static void main(String[] args) {

        Person person1 = new Person();

        Person person2 = new Person("Laksh", 19, " Chennai");

        System.out.println("Person 1 Info:");
        person1.displayPersonInfo();

        System.out.println("\nPerson 2 Info:");
        person2.displayPersonInfo();
    }
}