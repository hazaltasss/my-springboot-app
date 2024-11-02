package com.softtech.HelloWorld_v2.service;

import com.softtech.HelloWorld_v2.entity.Person;
import com.softtech.HelloWorld_v2.exception.NotFoundException;
import com.softtech.HelloWorld_v2.repository.IPersonRepository;
import com.softtech.HelloWorld_v2.dto.CreditSummary;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.Map;

@Service
public class PersonService implements IPersonService {

    private final IPersonRepository personRepository;

    public PersonService(IPersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person save(Person person) {
        personRepository.save(person);
        return person;
    }

    @Override
    public void deleteById(long id) {
        Optional<Person> person = personRepository.findById(id);
        if (person.isPresent()) {
            personRepository.delete(person.get());
        } else {
            throw new NotFoundException();
        }
    }

    @Override
    public List<Person> getAll() {
        return (List<Person>) personRepository.findAll();
    }

    @Override
    public Optional<Person> getById(long id) {
        return personRepository.findById(id);
    }

    @Override
    public List<Person> filterPersons(String customerNo, String branchNo, String creditCode, String cartonNo, String creditType, BigDecimal minBalance, BigDecimal maxBalance, String authorizationCode, String statusCode) {
        return personRepository.filterPersons(customerNo, branchNo, creditCode, cartonNo, creditType, minBalance, maxBalance, authorizationCode, statusCode);
    }

    @Override
    public List<CreditSummary> getCreditSummariesByType() {
        return personRepository.countByCreditTypeOnDate(LocalDate.now())
                .stream()
                .map(result -> new CreditSummary((String) result[0], (Long) result[1], (BigDecimal) result[2]))
                .collect(Collectors.toList());
    }

    @Override
    public long getIntikalCountForToday() {
        return personRepository.countByIntikalDate(LocalDate.now());
    }

    @Override
    public List<CreditSummary> getCreditSummariesForToday() {
        return personRepository.countByCreditTypeOnDate(LocalDate.now())
                .stream()
                .map(result -> new CreditSummary((String) result[0], (Long) result[1], (BigDecimal) result[2]))
                .collect(Collectors.toList());
    }

    @Override
    public List<Person> getIntikalRecordsForToday() {
        return personRepository.findByIntikalDate(LocalDate.now());
    }

    @Override
    public List<Person> getIntikalListForToday() {
        return personRepository.findByIntikalDate(LocalDate.now());
    }


    @Override
    public Map<String, Long> getCreditTypeDistributionForToday() {
        List<Person> intikalList = getIntikalListForToday();
        return intikalList.stream()
                .collect(Collectors.groupingBy(Person::getCreditType, Collectors.counting()));
    }

    public interface IPersonService {
        List<CreditSummary> getCreditSummariesWithCountForToday();}
}

