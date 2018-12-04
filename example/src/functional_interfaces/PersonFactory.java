package functional_interfaces;

interface PersonFactory<P extends Person> {
   // P create(String surname, String name);
    P create(String surname, String name, String address);
}

