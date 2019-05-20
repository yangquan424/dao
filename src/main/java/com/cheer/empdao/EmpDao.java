package com.cheer.empdao;

import com.cheer.dao.Emp;
import lemp.Dao;

import java.util.List;

public interface EmpDao extends Dao<Emp,Integer> {
    @Override
    int doCreate(Emp vo);

    @Override
    int doUpdate(Emp vo);

    @Override
    int doDelete(Integer id);

    @Override
    List<Emp> findAll();

    @Override
    Emp findById(Integer id);
}
