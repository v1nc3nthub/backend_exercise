package com.skylabs.exercise.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class FilterRecord implements Serializable{
    @Id
    private String aggregationType;
    @Id
    private Integer aggregationValue;
    @Id
    private Float capital_gain_sum;
    @Id
    private Float capital_gain_avg;
    @Id
    private Float capital_loss_sum;
    @Id
    private Float capital_loss_avg;
    @Id
    private Boolean is_over50k;
    @Id
    private Integer count_50k;

    public String getAggregationType() {
        return aggregationType;
    }

    public void setAggregationType(String aggregationType) {
        this.aggregationType = aggregationType;
    }

    public Integer getAggregationValue() {
        return aggregationValue;
    }

    public void setAggregationValue(Integer aggregationValue) {
        this.aggregationValue = aggregationValue;
    }

    public Float getCapital_gain_sum() {
        return capital_gain_sum;
    }

    public void setCapital_gain_sum(Float capital_gain_sum) {
        this.capital_gain_sum = capital_gain_sum;
    }

    public Float getCapital_gain_avg() {
        return capital_gain_avg;
    }

    public void setCapital_gain_avg(Float capital_gain_avg) {
        this.capital_gain_avg = capital_gain_avg;
    }

    public Float getCapital_loss_sum() {
        return capital_loss_sum;
    }

    public void setCapital_loss_sum(Float capital_loss_sum) {
        this.capital_loss_sum = capital_loss_sum;
    }

    public Float getCapital_loss_avg() {
        return capital_loss_avg;
    }

    public void setCapital_loss_avg(Float capital_loss_avg) {
        this.capital_loss_avg = capital_loss_avg;
    }

    public Boolean getIs_over50k() {
        return is_over50k;
    }

    public void setIs_over50k(Boolean is_over50k) {
        this.is_over50k = is_over50k;
    }

    public Integer getCount_50k() {
        return count_50k;
    }

    public void setCount_50k(Integer count_50k) {
        this.count_50k = count_50k;
    }
}
