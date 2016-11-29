package com.Vlad160;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Vlad on 26.11.2016.
 */


public class Computer {
    private String name;
    private Condition condition;
    private long startPrice;
    private long currentPrice;
    private Date arriveDate;

    public Computer() {
        this.name = "";
        this.condition = Condition.Default;
        this.startPrice = 0;
        this.currentPrice = 0;
        this.arriveDate = new Date(228l);
    }

    public Computer(String name, Condition condition, long startPrice, long currentPrice, String data) {
        this.name = name;
        this.condition = condition;
        this.startPrice = startPrice;
        this.currentPrice = currentPrice;
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            arriveDate = format.parse(data);
        } catch (ParseException e) {
            System.out.println("Cannot parse");
        }
    }

    @Override
    public String toString() {
        String str = name;
        str = str.concat(" " + condition);
        str = str.concat(" " + startPrice + " " + currentPrice + " ");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        str = str.concat(simpleDateFormat.format(arriveDate));
        return str;
    }
}
