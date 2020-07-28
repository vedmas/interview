package lesson1;


import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    private String firstName, lastName, middleName, country, address, phone, gender;
    private int age;
}
