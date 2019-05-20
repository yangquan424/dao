package com.cheer.empdao;

import com.cheer.dao.Emp;
import com.cheer.util.DcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpDaoImpl implements EmpDao {
    @Override
    public int doCreate(Emp vo) {
        Connection connection = null;
        PreparedStatement statement = null;
        int low = 0;
        String sql = "INSERT INTO emp(empno,ename,job,mgr,hiredate,sal,com,deptno) VALUES (?,?,?,?,?,?,?,?)" ;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, vo.getEmpno());
            statement.setString(2, vo.getEname());
            statement.setString(3, vo.getJob());
            statement.setInt(4,vo.getMgr());
            statement.setString(5,vo.getHiredate());
            statement.setDouble(6, vo.getSal());
            statement.setDouble(7, vo.getCom());
            statement.setInt(8,vo.getDeptno());
            low = statement.executeUpdate();
            if(low > 0) {
                System.out.println("成功");
            }else {
                System.out.println("失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DcUtils.gstInstance().close(connection,statement,null);
        }
        return low;
    }

    @Override
    public int doUpdate(Emp vo) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int low = 0;

        String sql = "UPDATE emp SET ename=?,job=?,mgr=?,hiredate=?,sal=?,com=?,deptno=? WHERE empno=?" ;
        try {
            connection = DcUtils.gstInstance().getConnection();
            statement.setInt(1, vo.getEmpno());
            statement.setString(2, vo.getEname());
            statement.setString(3, vo.getJob());
            statement.setInt(4,vo.getMgr());
            statement.setString(5,vo.getHiredate());
            statement.setDouble(6, vo.getSal());
            statement.setDouble(7, vo.getCom());
            statement.setInt(8,vo.getDeptno());
            low = statement.executeUpdate();
            if(low > 0) {
                System.out.println("成功");
            }else {
                System.out.println("失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DcUtils.gstInstance().close(connection,statement,null);
        }
        return low;
    }

    @Override
    public int doDelete(Integer id) {
        return 0;
    }

    @Override
    public List<Emp> findAll() {
        ArrayList list = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DcUtils.gstInstance().getConnection();
            String sql = "select * from emp";

            statement = connection.prepareStatement(sql);

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                if (list == null) {
                    list = new ArrayList<Emp>();
                }
                Emp emp = new Emp();
                emp.setEmpno(resultSet.getInt("empno"));
                emp.setEname(resultSet.getString("ename"));
                emp.setJob(resultSet.getString("job"));
                emp.setMgr(resultSet.getInt("mgr"));
                emp.setHiredate(resultSet.getString("hiredate"));
                emp.setSal(resultSet.getDouble("sal"));
                emp.setCom(resultSet.getDouble("com"));
                emp.setDeptno(resultSet.getInt("deptno"));

                list.add(emp);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DcUtils.gstInstance().close(connection,statement,resultSet);
        }
        return list;
    }

    @Override
    public Emp findById(Integer id) {
        Emp emp = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DcUtils.gstInstance().getConnection();
            String sql = "select * from emp where empno=" + id;

            statement = connection.prepareStatement(sql);

            resultSet = statement.executeQuery();

            while (resultSet.next()) {

                emp = new Emp();
                emp.setEmpno(resultSet.getInt("empno"));
                emp.setEname(resultSet.getString("ename"));
                emp.setJob(resultSet.getString("job"));
                emp.setMgr(resultSet.getInt("mgr"));
                emp.setHiredate(resultSet.getString("hiredate"));
                emp.setSal(resultSet.getDouble("sal"));
                emp.setCom(resultSet.getDouble("com"));
                emp.setDeptno(resultSet.getInt("deptno"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DcUtils.gstInstance().close(connection, statement, resultSet);
        }
        return emp;
    }
}
