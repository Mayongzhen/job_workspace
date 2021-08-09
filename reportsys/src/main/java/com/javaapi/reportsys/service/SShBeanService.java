package com.javaapi.reportsys.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javaapi.reportsys.dao.SshBeanDao;
import com.javaapi.reportsys.entity.SShBean;
import com.javaapi.reportsys.mapper.SShBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "SShBeanService")
public class SShBeanService implements SshBeanDao {


    @Autowired
    private SShBeanMapper sshbeanmapper;


    @Override
    public int Save(SShBean sshbean) {
        return sshbeanmapper.insertSShBean(sshbean);
    }

    @Override
    public int update(SShBean sshbean) {
        return sshbeanmapper.updateSshbean(sshbean);
    }

    @Override
    public int delete(int id) {
        return sshbeanmapper.deletebyId(id);
    }

    @Override
    public SShBean selectone(int id) {
        return sshbeanmapper.selectOne(id);
    }

    @Override
    public PageInfo<SShBean> selcetall(int pageNum, int pageSize) {

        PageHelper.startPage(pageNum,pageSize);
        List<SShBean> list=sshbeanmapper.selectall();
        PageInfo<SShBean> pageinfo=new PageInfo<SShBean>(list);
        return pageinfo;
    }
}
