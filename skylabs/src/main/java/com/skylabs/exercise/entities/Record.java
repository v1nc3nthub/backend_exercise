package com.skylabs.exercise.entities;

import javax.persistence.*;

@Entity
@Table(name = "records")
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "age")
    private Integer age;

    @ManyToOne
    @JoinColumn(name = "workclass_id", nullable = false)
    private Workclass workclass;

    @ManyToOne
    @JoinColumn(name = "education_level_id", nullable = false)
    private EducationLevel educationLevel;

    @Column(name = "education_num")
    private Integer educationNum;

    @ManyToOne
    @JoinColumn(name = "marital_status_id", nullable = false)
    private MaritalStatus maritalStatus;

    @ManyToOne
    @JoinColumn(name = "occupation_id", nullable = false)
    private Occupation occupation;

    @ManyToOne
    @JoinColumn(name = "relationship_id", nullable = false)
    private Relationship relationship;

    @ManyToOne
    @JoinColumn(name = "race_id", nullable = false)
    private Race race;

    @ManyToOne
    @JoinColumn(name = "sex_id", nullable = false)
    private Sex sex;

    @Column(name = "capital_gain")
    private Integer capitalGain;

    @Column(name = "capital_loss")
    private Integer capitalLoss;

    @Column(name = "hours_week")
    private Integer hoursWeek;

    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    @Column(name = "over_50k")
    private Boolean over50K;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Workclass getWorkclass() {
        return workclass;
    }

    public void setWorkclass(Workclass workclass) {
        this.workclass = workclass;
    }

    public EducationLevel getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(EducationLevel educationLevel) {
        this.educationLevel = educationLevel;
    }

    public Integer getEducationNum() {
        return educationNum;
    }

    public void setEducationNum(Integer educationNum) {
        this.educationNum = educationNum;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Occupation getOccupation() {
        return occupation;
    }

    public void setOccupation(Occupation occupation) {
        this.occupation = occupation;
    }

    public Relationship getRelationship() {
        return relationship;
    }

    public void setRelationship(Relationship relationship) {
        this.relationship = relationship;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Integer getCapitalGain() {
        return capitalGain;
    }

    public void setCapitalGain(Integer capitalGain) {
        this.capitalGain = capitalGain;
    }

    public Integer getCapitalLoss() {
        return capitalLoss;
    }

    public void setCapitalLoss(Integer capitalLoss) {
        this.capitalLoss = capitalLoss;
    }

    public Integer getHoursWeek() {
        return hoursWeek;
    }

    public void setHoursWeek(Integer hoursWeek) {
        this.hoursWeek = hoursWeek;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Boolean getOver50K() {
        return over50K;
    }

    public void setOver50K(Boolean over50K) {
        this.over50K = over50K;
    }

}
