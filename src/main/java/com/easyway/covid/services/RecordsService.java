package com.easyway.covid.services;

import com.easyway.covid.domain.Records;
import com.easyway.covid.mapper.RecordsMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class RecordsService {

    private RecordsMapper recordsMapper;
    public void insertRecords(Records records) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            RecordsMapper recordsMapper = sqlSession.getMapper(RecordsMapper.class);
            recordsMapper.insertRecords(records);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public List<Records> getAllRecords() {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            RecordsMapper recordsMapper = sqlSession.getMapper(RecordsMapper.class);
            return recordsMapper.getAllRecords();
        } finally {
            sqlSession.close();
        }
    }

    public List<Records> getRecordsByCountry(String country) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            RecordsMapper recordsMapper = sqlSession.getMapper(RecordsMapper.class);
            return recordsMapper.getRecordsByCountry(country);
        } finally {
            sqlSession.close();
        }
    }

    public void updateRecords(Records records) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            RecordsMapper recordsMapper = sqlSession.getMapper(RecordsMapper.class);
            recordsMapper.updateRecords(records);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }
}
