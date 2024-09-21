//package com.softtech.HelloWorld_v2.service;
//
//import com.softtech.HelloWorld_v2.entity.Person;
//
//import java.util.List;
//import java.util.Optional;
//
//public interface IPersonService {
//    Person save(Person person);
//
//    void deleteById(long id);
//
//    List<Person> getAll();
//
//    Optional<Person> getById(long id);
//
//}
package com.softtech.HelloWorld_v2.service;

import com.softtech.HelloWorld_v2.entity.Person;
import com.softtech.HelloWorld_v2.dto.CreditSummary;


import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Map;

public interface IPersonService {
    Person save(Person person);

    void deleteById(long id);

    List<Person> getAll();

    Optional<Person> getById(long id);


    List<Person> filterPersons(String customerNo, String branchNo, String creditCode, String cartonNo, String creditType, BigDecimal minBalance, BigDecimal maxBalance, String authorizationCode, String statusCode);
    List<CreditSummary> getCreditSummariesByType();
    long getIntikalCountForToday();
    List<CreditSummary> getCreditSummariesForToday();
    List<Person> getIntikalRecordsForToday();
    List<Person> getIntikalListForToday();

    Map<String, Long> getCreditTypeDistributionForToday();


}
