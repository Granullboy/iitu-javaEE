package kz.aboba.employeeservice.controller;

import kz.aboba.employeeservice.entity.Employee;
import kz.aboba.employeeservice.fetchClient.AbobaClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("employees")
public class EmployeeController {
    private final AbobaClient abobaClient;
    private static List<Employee> employeeList = Arrays.asList(
            new Employee(1, "John Doe", 22),
            new Employee(2, "Aboba", 20)
    );

    public EmployeeController(AbobaClient abobaClient) {
        this.abobaClient = abobaClient;
    }

    @GetMapping("")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        try {
            return ResponseEntity.ok(employeeList);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
        Employee employee = employeeList.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/{id}/aboba")
    public String getEmployeeByAboba(@PathVariable int id) {
        System.out.println(id);
        return abobaClient.getAboba(id);
    }

}
