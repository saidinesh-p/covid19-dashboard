package com.easyway.covid.domain;

import java.util.Date;

public class Records {
    private Integer id;
    private String country;
    private Double totalCases;
    private Double newCases;
    private Double totalRecovered;
    private Double totalDeaths;
    private Double newDeaths;
    private Double activeCases;
    private Double critical;
    private Double casesPop;
    private Double deathsPop;
    private String firstCase;


    public Records(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Double getTotalCases() {
        return totalCases;
    }

    public void setTotalCases(Double totalCases) {
        this.totalCases = totalCases;
    }

    public Double getNewCases() {
        return newCases;
    }

    public void setNewCases(Double newCases) {
        this.newCases = newCases;
    }

    public Double getTotalRecovered() {
        return totalRecovered;
    }

    public void setTotalRecovered(Double totalRecovered) {
        this.totalRecovered = totalRecovered;
    }

    public Double getTotalDeaths() { return totalDeaths; }

    public void setTotalDeaths(Double totalDeaths) { this.totalDeaths = totalDeaths; }

    public Double getNewDeaths() { return newDeaths; }

    public void setNewDeaths(Double newDeaths) { this.newDeaths = newDeaths; }

    public Double getActiveCases() {
        return activeCases;
    }

    public void setActiveCases(Double activeCases) {
        this.activeCases = activeCases;
    }

    public Double getCritical() {
        return critical;
    }

    public void setCritical(Double critical) {
        this.critical = critical;
    }

    public Double getCasesPop() {
        return casesPop;
    }

    public void setCasesPop(Double casesPop) {
        this.casesPop = casesPop;
    }

    public Double getDeathsPop() {
        return deathsPop;
    }

    public void setDeathsPop(Double deathsPop) {
        this.deathsPop = deathsPop;
    }

    public String getFirstCase() {
        return firstCase;
    }

    public void setFirstCase(String firstCase) {
        this.firstCase = firstCase;
    }

    @Override
    public String toString() {
        return "Records{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", totalCases=" + totalCases +
                ", newCases=" + newCases +
                ", totalRecovered=" + totalRecovered +
                ", totalDeaths=" + totalDeaths +
                ", newDeaths=" + newDeaths +
                ", activeCases=" + activeCases +
                ", critical=" + critical +
                ", casesPop=" + casesPop +
                ", deathsPop=" + deathsPop +
                ", firstCase='" + firstCase + '\'' +
                '}';
    }
}
