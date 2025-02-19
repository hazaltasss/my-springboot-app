package com.softtech.HelloWorld.v2.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "t_person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "customer_no")
    private String customerNo;

    @Column(name = "branch_no")
    private String branchNo;

    @Column(name = "credit_code")
    private String creditCode;

    @Column(name = "carton_no")
    private String cartonNo;

    @Column(name = "credit_type")
    private String creditType;

    @Column(name = "balance")
    private BigDecimal balance;

    @Column(name = "authorization_code" )
    private String authorizationCode;

    @Column(name = "status_code")
    private String statusCode;

    @Column(name = "intikal_date")
    private LocalDate intikalDate;

    public Person() {
    }

    public Person(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;

    }

    public Person(long id, String firstName, String lastName, String customerNo, String branchNo, String creditCode, String cartonNo, String creditType, BigDecimal balance, String authorizationCode, String statusCode, LocalDate intikalDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.customerNo = customerNo;
        this.branchNo = branchNo;
        this.creditCode = creditCode;
        this.cartonNo = cartonNo;
        this.creditType = creditType;
        this.balance = balance;
        this.authorizationCode = authorizationCode;
        this.statusCode = statusCode;
        this.intikalDate = intikalDate;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public String getBranchNo() {
        return branchNo;
    }

    public void setBranchNo(String branchNo) {
        this.branchNo = branchNo;
    }

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    public String getCartonNo() {
        return cartonNo;
    }

    public void setCartonNo(String cartonNo) {
        this.cartonNo = cartonNo;
    }

    public String getCreditType() {
        return creditType;
    }

    public void setCreditType(String creditType) {
        this.creditType = creditType;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getAuthorizationCode() {
        return authorizationCode;
    }

    public void setAuthorizationCode(String authorizationCode) {
        this.authorizationCode = authorizationCode;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public LocalDate getIntikalDate() {
        return intikalDate;
    }

    public void setIntikalDate(LocalDate intikalDate) {
        this.intikalDate = intikalDate;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", customerNo='" + customerNo + '\'' +
                ", branchNo='" + branchNo + '\'' +
                ", creditCode='" + creditCode + '\'' +
                ", cartonNo='" + cartonNo + '\'' +
                ", creditType='" + creditType + '\'' +
                ", balance=" + balance +
                ", authorizationCode='" + authorizationCode + '\'' +
                ", statusCode='" + statusCode + '\'' +
                ", intikalDate=" + intikalDate +
                '}';
    }
}
