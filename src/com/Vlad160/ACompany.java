package com.Vlad160;

import com.Vlad160.Computer;

import java.io.Serializable;


abstract class ACompany implements Serializable{
        String name;
    ACompany(){
        this.name = "";
    }
    ACompany(String name){
        this.name = "";
    }
    abstract void add(Computer computer);

}
