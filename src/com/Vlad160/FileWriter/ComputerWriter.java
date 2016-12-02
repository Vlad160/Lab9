package com.Vlad160.FileWriter;

import com.Vlad160.Company;
import com.Vlad160.Computer;
import com.Vlad160.Condition;
import com.Vlad160.DesEncrypter;

import javax.crypto.SecretKey;
import java.io.*;

/**
 * Created by User on 02.12.2016.
 */
public class ComputerWriter implements FileWriter, Serializable {
    private RandomAccessFile file;

    @Override
    public boolean writeToBytes(String path, Company company) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(company);
            oos.flush();
            oos.close();
            return true;
        } catch (IOException e) {
            System.out.println("Can't serialize ");
            return false;
        }
    }

    @Override
    public boolean writeToFile(String path, Company company) {
        try {
            file = new RandomAccessFile(path, "rw");
            for (int i = 0; i < company.getSize(); ++i) {
                file.write(company.getComputer(i).getComputer().getBytes());
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

    @Override
    public boolean write(String path, Company company, SecretKey secretKey) {
        try {
            java.io.FileWriter fileWriter = new java.io.FileWriter(path);
            DesEncrypter desEncrypter = new DesEncrypter(secretKey);
            fileWriter.write(desEncrypter.encrypt(company.toString()));
            fileWriter.close();
            return true;
        } catch (Exception e) {
            System.out.println("Exception");
            return false;
        }

    }
}
