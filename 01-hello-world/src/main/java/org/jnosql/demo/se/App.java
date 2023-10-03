
package org.jnosql.demo.se;


import java.sql.SQLException;
import java.util.List;

public class App {

    public static void main(String[] args) throws SQLException {
        PersonDAO dao = new PersonDAO();
        //dao.create();
        dao.insert(Person.of( "Ada", 10));
        dao.insert(Person.of("Poliana", 20));
        dao.insert(Person.of("Jhon", 30));
        List<Person> people = dao.findAll();
        people.forEach(System.out::println);
    }

    private App() {
    }



}
