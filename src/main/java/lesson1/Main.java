package lesson1;

import lesson1.polymorph.Circle;
import lesson1.polymorph.Form;


public class Main {
    public static void main(String[] args) {

        Person person = Person.builder().firstName("Bob").age(25).country("USA").gender("Transgender").build();

        Circle circle = new Circle();
        System.out.println("Circle is a form?: " + (circle instanceof Form));
    }
}
