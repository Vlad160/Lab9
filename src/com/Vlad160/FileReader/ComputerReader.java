package com.Vlad160.FileReader;

import com.Vlad160.Company;
import com.Vlad160.Computer;
import com.Vlad160.Condition;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by Vlad on 26.11.2016.
 */
public class ComputerReader implements FileReader {
    private RandomAccessFile file;

    @Override
    public boolean ReadComputer(String path,Company company) {
        try {
            file = new RandomAccessFile(path, "r");
            while(true) {
                String name = file.readLine();
                String tempCondition = file.readLine();
                Condition condition = Condition.valueOf(tempCondition);
                String temp = file.readLine();
                long startPrice = Long.valueOf(temp);
                temp = file.readLine();
                long currentPrice = Long.valueOf(temp);
                String date = file.readLine();
                Computer computer = new Computer(name, condition, startPrice, currentPrice, date);
                company.add(computer);
                long pos = file.getFilePointer();
                file.readInt();
                file.seek(pos);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("IO Exception");
        } catch (IllegalArgumentException e) {
            System.out.println("Wrong condition");
        }
        return true;
    }
}
