package com.javaapi.reportsys.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javaapi.reportsys.dao.CaseDao;
import com.javaapi.reportsys.entity.TestCase;
import com.javaapi.reportsys.mapper.TestCaseMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "TestCaseService")
public class TestCaseService implements CaseDao {
    @Autowired
    private TestCaseMapper testCaseMapper;
    @Override
    public int Save(TestCase testCase) {
        return testCaseMapper.insertTestcase(testCase);
    }

    @Override
    public int update(TestCase testCase) {
       return testCaseMapper.updateTestcase(testCase);
    }

    @Override
    public int delete(int caseid) {
        return testCaseMapper.deletebyId(caseid);
    }

    @Override
    public TestCase selectone(int caseid) {
        return testCaseMapper.selectOne(caseid);
    }

    @Override
    public PageInfo<TestCase> selcetall(int pageNum, int pageSize ) {
        PageHelper.startPage(pageNum,pageSize);
        List<TestCase> list=testCaseMapper.selectall();
        PageInfo<TestCase> pageinfo=new PageInfo<TestCase>(list);
        return pageinfo;
    }
}
