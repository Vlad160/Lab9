package com.Vlad160;

import com.Vlad160.FileReader.ComputerReader;

/**
 * Created by User on 29.11.2016.
 */
public class Main {
    public static void main(String[] args) {
        Company company = new Company("нагибаторы");
        ComputerReader computerReader = new ComputerReader();
        computerReader.ReadComputer("text.txt",company);
    }
}
