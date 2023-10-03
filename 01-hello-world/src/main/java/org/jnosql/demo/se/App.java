
package org.jnosql.demo.se;


import java.sql.SQLException;
import java.util.List;

public class App {

    public static void main(String[] args) throws SQLException {
        PersonDAO dao = new PersonDAO();
        //dao.create();
        dao.insert(new Person("Ada", 10));
        dao.insert(new Person("Poliana", 20));
        dao.insert(new Person("Jhon", 30));
        List<Person> people = dao.findAll();
        people.forEach(System.out::println);

    }

    private App() {
    }



}
