package com.skylabs.exercise.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Query {

    @Id
    private Integer id;
    private String queryQuestion;
    private String queryAnswer;

    public Query(){}

    public Query(Integer id, String queryQuestion, String queryAnswer)
    {
        this.id = id;
        this.queryQuestion = queryQuestion;
        this.queryAnswer = queryAnswer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQueryQuestion() {
        return queryQuestion;
    }

    public void setQueryQuestion(String queryQuestion) {
        this.queryQuestion = queryQuestion;
    }

    public String getQueryAnswer() {
        return queryAnswer;
    }

    public void setQueryAnswer(String queryAnswer) {
        this.queryAnswer = queryAnswer;
    }
}
