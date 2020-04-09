package com.easyway.covid.mapper;

import com.easyway.covid.domain.Records;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RecordsMapper {
    @Insert("INSERT INTO records(country, total_cases, new_cases, total_deaths, new_deaths, total_recovered, active_cases, critical, cases_pop, deaths_pop, first_case)"
            + "VALUES(#{country}, #{totalCases}, #{newCases}, #{totalDeaths}, #{newDeaths}, #{totalRecovered}, #{activeCases}, #{critical}, #{casesPop}, #{deathsPop}, #{firstCase})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public void insertRecords(Records records);

    @Select("SELECT * FROM records")
    @Results({ @Result(id = true, property = "id", column = "id"),
            @Result(property = "country", column = "country"),
            @Result(property = "totalCases", column = "total_cases"),
            @Result(property = "newCases", column = "new_cases"),
            @Result(property = "totalDeaths", column = "total_deaths"),
            @Result(property = "newDeaths", column = "new_deaths"),
            @Result(property = "totalRecovered", column = "total_recovered"),
            @Result(property = "activeCases", column = "active_cases"),
            @Result(property = "critical", column = "critical"),
            @Result(property = "casesPop", column = "cases_pop"),
            @Result(property = "deathsPop", column = "deaths_pop"),
            @Result(property = "firstCase", column = "first_case")})
    public List<Records> getAllRecords();

    @Select("SELECT * FROM records where country= #{country}")
    @Results({ @Result(id = true, property = "country", column = "country"),
            @Result(property = "country", column = "country"),
            @Result(property = "totalCases", column = "total_cases"),
            @Result(property = "newCases", column = "new_cases"),
            @Result(property = "totalDeaths", column = "total_deaths"),
            @Result(property = "newDeaths", column = "new_deaths"),
            @Result(property = "totalRecovered", column = "total_recovered"),
            @Result(property = "activeCases", column = "active_cases"),
            @Result(property = "critical", column = "critical"),
            @Result(property = "casesPop", column = "cases_pop"),
            @Result(property = "deathsPop", column = "deaths_pop"),
            @Result(property = "firstCase", column = "first_case")})
    public List<Records> getRecordsByCountry(String country);

    @Insert("UPDATE records SET total_cases=#{totalCases}, new_cases=#{newCases}, total_deaths=#{totalDeaths}, new_deaths=#{newDeaths}, total_recovered=#{totalRecovered}, active_cases= #{activeCases}, critical=#{critical}, cases_pop=#{casesPop}, deaths_pop= #{deathsPop}, first_case=#{firstCase} where country=#{country}")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public void updateRecords(Records records);

}
