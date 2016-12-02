package com.Vlad160;

import com.Vlad160.Computer;

import java.io.Serializable;


abstract class ACompany implements Serializable{
         String name;
    ACompany(){
        this.name = "";
    }
    ACompany(String name){
        this.name = name;
    }
    abstract public void add(Computer computer);
    abstract public String getName();
    abstract public void setName(String name);
}
