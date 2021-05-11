enum Gender {
    male,
    female
}
public class Customer {
    String fullname;
    int age;
    Gender gender;

    public Customer(String fullname, int age, Gender gender) {
        this.fullname = fullname;
        this.age = age;
        this.gender = gender;
    }
}
