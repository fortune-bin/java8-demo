package functional_interfaces;

class Person {

    String surname;
    String name;
    String address;

    Person() {
    }

    Person(String surname, String name) {
        this.surname = surname;
        this.name = name;
    }

    Person(String surname, String name, String address) {
        this.surname = surname;
        this.name = name;
        this.address = address;
    }


    @Override
    public String toString() {
        return "Person{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}