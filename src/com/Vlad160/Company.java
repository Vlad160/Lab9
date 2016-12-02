package com.Vlad160;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Company extends ACompany implements Serializable {
    private List<Computer> computers;

    public Company(String name) {
        super(name);
        computers = new LinkedList<>();
    }

    public void add(Computer computer) {
        computers.add(computer);
    }

    @Override
    public String toString() {
        String str = name;
        str = str.concat("\n");
        for (int i = 0; i < computers.size(); ++i) {
            str = str.concat(computers.get(i).toString());
            str = str.concat("\n");
        }
        return str;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getSize() {
        return computers.size();
    }

    public Computer getComputer(int index) {
        return computers.get(index);
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
