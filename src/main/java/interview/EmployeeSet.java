package main.java.interview;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeSet {
    public static void main(String[] args) {
        List<Employee> list= List.of(
                new Employee("ishan", "tripathi"),
                new Employee("ayush", "r"),
                new Employee("ishan", "tripati"),
        new Employee("ishan", "tripati"),
        new Employee("ish", "tripati"),
        new Employee("ayush", "r"));

        list.stream().collect(Collectors.toSet()).forEach(System.out::println);

    }
}
