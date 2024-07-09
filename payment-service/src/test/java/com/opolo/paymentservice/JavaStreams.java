package com.opolo.paymentservice;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class JavaStreams {

    private static Employee[] employees = {
            new Employee(1, "Adam", 10000.00),
            new Employee(2, "Britney", 20000.00),
            new Employee(3, "Cathy", 30000.00),
            new Employee(4, "Dan", 40000.00),
            new Employee(5, "Ethan", 50000.00),
            new Employee(6, "Fawad", 60000.00),
            new Employee(7, "Gary", 70000.00),
            new Employee(8, "Harry", 80000.00)
    };

    private static List<Employee> empList = Arrays.asList(employees);

    @Test
    public void whenIncrementSalaryForEachEmployee_thenApplyNewSalary() {
        empList.stream().forEach(employee -> salaryIncrement(employee));
        // System.out.println(empList.toString());
    }

    public static void salaryIncrement(Employee e) {
        e.setSalary(e.getSalary() + 10000.00);
    }

    // @Test
    // public void whenMapIdToEmployees_thenGetEmployeeStream() {
    //     Integer[] empIds = { 1, 2, 3 };

    //     List<Employee> employees = Stream.of(empIds)
    //             .map(employeeRepository::findById)
    //             .collect(Collectors.toList());

    //     assertEquals(employees.size(), empIds.length);
    // }

    // @Test
    // public void whenFilterEmployees_thenGetFilteredStream() {
    //     Integer[] empIds = { 1, 2, 3, 4 };

    //     List<Employee> employees = Stream.of(empIds)
    //             .map(employeeRepository::findById)
    //             .filter(e -> e != null)
    //             .filter(e -> e.getSalary() > 200000)
    //             .collect(Collectors.toList());

    //     assertEquals(Arrays.asList(arrayOfEmps[2]), employees);
    // }

}
