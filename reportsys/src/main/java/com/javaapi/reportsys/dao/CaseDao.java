package com.javaapi.reportsys.dao;

import com.github.pagehelper.PageInfo;
import com.javaapi.reportsys.entity.TestCase;



public interface CaseDao {
    public int Save (TestCase testCase);
    public int update (TestCase  testCase);
    public int delete (int caseid);
    public  TestCase selectone (int caseid);
    public PageInfo<TestCase> selcetall(int pageNum, int pageSize );
}
