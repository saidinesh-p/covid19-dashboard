package com.easyway.covid.domain;

import java.util.Date;

public class Records {
    private Integer id;
    private String country;
    private Integer totalCases;
    private Integer newCases;
    private Integer totalRecovered;
    private Integer totalDeaths;
    private Integer newDeaths;
    private Integer activeCases;
    private Integer critical;
    private Integer casesPop;
    private Integer deathsPop;
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

    public Integer getTotalCases() {
        return totalCases;
    }

    public void setTotalCases(Integer totalCases) {
        this.totalCases = totalCases;
    }

    public Integer getNewCases() {
        return newCases;
    }

    public void setNewCases(Integer newCases) {
        this.newCases = newCases;
    }

    public Integer getTotalRecovered() {
        return totalRecovered;
    }

    public void setTotalRecovered(Integer totalRecovered) {
        this.totalRecovered = totalRecovered;
    }

    public Integer getTotalDeaths() { return totalDeaths; }

    public void setTotalDeaths(Integer totalDeaths) { this.totalDeaths = totalDeaths; }

    public Integer getNewDeaths() { return newDeaths; }

    public void setNewDeaths(Integer newDeaths) { this.newDeaths = newDeaths; }

    public Integer getActiveCases() {
        return activeCases;
    }

    public void setActiveCases(Integer activeCases) {
        this.activeCases = activeCases;
    }

    public Integer getCritical() {
        return critical;
    }

    public void setCritical(Integer critical) {
        this.critical = critical;
    }

    public Integer getCasesPop() {
        return casesPop;
    }

    public void setCasesPop(Integer casesPop) {
        this.casesPop = casesPop;
    }

    public Integer getDeathsPop() {
        return deathsPop;
    }

    public void setDeathsPop(Integer deathsPop) {
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
