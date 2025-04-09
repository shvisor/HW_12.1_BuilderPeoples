public class PersonBuilder {

    protected String name;
    protected String surname;
    protected int age;
    protected String address;


    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0){
            throw new IllegalArgumentException ("Возраст не может быть меньше нуля. Ваше значение " + age);
        }
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if ((name == null || name.isBlank()) || (surname == null || surname.isBlank())) {
            throw new IllegalStateException("Не указаны имя или фамилия");
        }

        Person person = new Person(name, surname, age);
        if (!address.isBlank()) {
            person.setAddress(address);
        }
        return person;
    }
}
