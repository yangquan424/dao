package com.cheer;

import com.cheer.dao.Emp;
import com.cheer.empdao.EmpDaoImpl;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        EmpDaoImpl e=new EmpDaoImpl();
        System.out.println(e.findById(7369));
    }
}
