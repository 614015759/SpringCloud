package com.atxzy.springcloud.pojo;



import java.io.Serializable;


public class Dept implements Serializable {

    private Long deptno;
    private String dname;
    private String dbSource;

    public Dept() {
    }

    public Dept(Long deptno, String dname, String dbSource) {
        this.deptno = deptno;
        this.dname = dname;
        this.dbSource = dbSource;
    }

    public Long getDeptno() {
        return deptno;
    }

    public void setDeptno(Long deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDbSource() {
        return dbSource;
    }

    public void setDbSource(String dbSource) {
        this.dbSource = dbSource;
    }
}
