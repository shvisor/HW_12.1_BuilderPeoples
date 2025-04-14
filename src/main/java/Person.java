import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected OptionalInt age = OptionalInt.empty();
    protected String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age < 0 ? OptionalInt.empty() : OptionalInt.of(age);
    }

    public boolean hasAge() {
        return age.isPresent();
    }

    public boolean hasAddress() {
        return !address.isBlank();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        if (!hasAge()) {
            return OptionalInt.empty();
        }
        return age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public void happyBirthday() {
        if (hasAge()) {
            age = OptionalInt.of(age.getAsInt() + 1);
        }
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(surname)
                .setAddress(address);

    }

    @Override
    public String toString() {
        return "Person {" +
                "name='" + getName() + '\'' +
                ", surname='" + getSurname() + '\'' +
                ", age=" + getAge() +
                ", address='" + getAddress() + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }
}
