package com.javaapi.reportsys.dao;

import com.github.pagehelper.PageInfo;
import com.javaapi.reportsys.entity.SShBean;
import com.javaapi.reportsys.entity.TestCase;

public interface SshBeanDao {
    public int Save (SShBean sshbean);
    public int update (SShBean  sshbean);
    public int delete (int id);
    public  SShBean selectone (int id);
    public PageInfo<SShBean> selcetall(int pageNum, int pageSize );
}
