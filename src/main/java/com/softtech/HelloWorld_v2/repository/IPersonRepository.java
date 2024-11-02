package com.softtech.HelloWorld_v2.repository;

import com.softtech.HelloWorld_v2.entity.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.softtech.HelloWorld_v2.dto.CreditSummary;
import java.time.LocalDate;

import java.math.BigDecimal;
import java.util.List;

public interface IPersonRepository extends CrudRepository<Person, Long> {

    @Query("SELECT p FROM Person p WHERE " +
            "(:customerNo IS NULL OR p.customerNo = :customerNo) AND " +
            "(:branchNo IS NULL OR p.branchNo = :branchNo) AND " +
            "(:creditCode IS NULL OR p.creditCode = :creditCode) AND " +
            "(:cartonNo IS NULL OR p.cartonNo = :cartonNo) AND " +
            "(:creditType IS NULL OR p.creditType = :creditType) AND " +
            "(:minBalance IS NULL OR p.balance >= :minBalance) AND " +
            "(:maxBalance IS NULL OR p.balance <= :maxBalance) AND " +
            "(:authorizationCode IS NULL OR p.authorizationCode = :authorizationCode) AND " +
            "(:statusCode IS NULL OR p.statusCode = :statusCode)")
    List<Person> filterPersons(@Param("customerNo") String customerNo,
                               @Param("branchNo") String branchNo,
                               @Param("creditCode") String creditCode,
                               @Param("cartonNo") String cartonNo,
                               @Param("creditType") String creditType,
                               @Param("minBalance") BigDecimal minBalance,
                               @Param("maxBalance") BigDecimal maxBalance,
                               @Param("authorizationCode") String authorizationCode,
                               @Param("statusCode") String statusCode);
    @Query("SELECT new com.softtech.HelloWorld_v2.dto.CreditSummary(p.creditType, COUNT(p), SUM(p.balance)) FROM Person p GROUP BY p.creditType")
    List<CreditSummary> findCreditSummaryByType();

    long countByIntikalDate(LocalDate intikalDate);


    List<Person> findByIntikalDate(LocalDate intikalDate);



    @Query("SELECT p.creditType, COUNT(p) FROM Person p WHERE p.intikalDate = :intikalDate GROUP BY p.creditType")
    List<Object[]> countByCreditTypeOnDate(LocalDate intikalDate);

    @Query("SELECT p FROM Person p WHERE p.intikalDate = :intikalDate AND (:creditType IS NULL OR p.creditType = :creditType)")
    List<Person> findByIntikalDateAndCreditType(@Param("intikalDate") LocalDate intikalDate, @Param("creditType") String creditType);


    @Query("SELECT new com.softtech.HelloWorld_v2.dto.CreditSummary(p.creditType, COUNT(p), SUM(p.balance)) " +
            "FROM Person p GROUP BY p.creditType")
    List<CreditSummary> getCreditSummariesByType();


}
