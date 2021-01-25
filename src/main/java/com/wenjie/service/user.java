package com.wenjie.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class user implements Serializable {

    private String name;
    private String sex;
    private String  col;

    private List<String> list;
    private Map<String,String> map;



    public StringBuilder tolist(){
        StringBuilder str=new StringBuilder();
        list.stream().forEach(S->{

            str.append(S+",");

        });
        int indexOf = str.lastIndexOf(",");
        str.deleteCharAt(indexOf);
        return str;
    }

    public StringBuilder tomap(){
        Set<String> strings = map.keySet();
        StringBuilder str=new StringBuilder();

        strings.stream().forEach(s ->{

           str.append(s+"="+map.get(s));
        });
        return str;
    }





    @Override
    public String toString() {
        return "user{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", col='" + col + '\'' +
                ", list=" + this.tolist() +
                ", map=" + this.tomap()+
                '}';
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCol() {
        return col;
    }

    public void setCol(String col) {
        this.col = col;
    }
}
