package com.Vlad160;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Vlad on 26.11.2016.
 */
public class Company extends ACompany implements Serializable {
    private List<Computer> computers;

    Company(String name) {
        super(name);
        computers = new LinkedList<>();
    }

    public void add(Computer computer) {
        computers.add(computer);
    }
}
