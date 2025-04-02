package kz.aboba.abobaservice.controller;

import kz.aboba.abobaservice.entity.Aboba;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("aboba")
public class AbobaController {
    private static List<Aboba> abobaList = Arrays.asList(
            new Aboba(1, false, 25),
            new Aboba(2, true, 730)
    );

    @GetMapping("/{employeeId}")
    public Aboba getAboba(@PathVariable int employeeId) {
        return abobaList.stream()
                .filter(aboba -> aboba.getEmployeeId() == employeeId)
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, null));
    }
}
