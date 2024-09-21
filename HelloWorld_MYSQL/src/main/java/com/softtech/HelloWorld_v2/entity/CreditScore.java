package com.softtech.HelloWorld_v2.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "t_credit_score")
public class CreditScore {
    private long id;
    private Person person;
    private Float score;

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    @ManyToOne
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }
}
