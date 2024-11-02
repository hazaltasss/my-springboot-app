package com.softtech.HelloWorld_v2.controller;

import com.softtech.HelloWorld_v2.entity.Person;
import com.softtech.HelloWorld_v2.service.IPersonService;
import com.softtech.HelloWorld_v2.dto.CreditSummary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/person")
public class PersonController {

    private final IPersonService personService;

    public PersonController(IPersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/")
    public ResponseEntity<Person> save(@RequestBody Person person) {
        Person savedPerson = personService.save(person);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPerson);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        personService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/")
    public ResponseEntity<List<Person>> getAll() {
        List<Person> personList = personService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(personList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getById(@PathVariable long id) {
        Optional<Person> person = personService.getById(id);
        if (person.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(person.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Person>> filterPersons(
            @RequestParam(required = false) String customerNo,
            @RequestParam(required = false) String branchNo,
            @RequestParam(required = false) String creditCode,
            @RequestParam(required = false) String cartonNo,
            @RequestParam(required = false) String creditType,
            @RequestParam(required = false) BigDecimal minBalance,
            @RequestParam(required = false) BigDecimal maxBalance,
            @RequestParam(required = false) String authorizationCode,
            @RequestParam(required = false) String statusCode) {

        List<Person> persons = personService.filterPersons(customerNo, branchNo, creditCode, cartonNo, creditType, minBalance, maxBalance, authorizationCode, statusCode);
        return ResponseEntity.status(HttpStatus.OK).body(persons);
    }
    @GetMapping("/credit-summaries")
    public ResponseEntity<List<CreditSummary>> getCreditSummariesByType() {
        List<CreditSummary> creditSummaries = personService.getCreditSummariesByType();
        if (creditSummaries.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(creditSummaries);
    }
    @GetMapping("/intikal-sayisi")
    public long getIntikalCountForToday() {
        return personService.getIntikalCountForToday();
    }
    @GetMapping("/intikal-listesi")
    public ResponseEntity<List<Person>> getIntikalListForToday() {
        List<Person> intikalList = personService.getIntikalListForToday();
        if (intikalList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(intikalList);
    }
    @GetMapping("/intikal-listesi/credit-type-distribution")
    public ResponseEntity<Map<String, Long>> getIntikalCreditTypeDistributionForToday() {
        List<Person> intikalList = personService.getIntikalListForToday();
        if (intikalList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        Map<String, Long> creditTypeDistribution = intikalList.stream()
                .collect(Collectors.groupingBy(Person::getCreditType, Collectors.counting()));

        return ResponseEntity.status(HttpStatus.OK).body(creditTypeDistribution);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable long id, @RequestBody Person person) {
        Optional<Person> existingPerson = personService.getById(id);
        if (existingPerson.isPresent()) {
            person.setId(id);
            Person updatedPerson = personService.save(person);
            return ResponseEntity.status(HttpStatus.OK).body(updatedPerson);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }




}
