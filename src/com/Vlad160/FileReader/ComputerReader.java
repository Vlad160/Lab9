package com.Vlad160.FileReader;

import com.Vlad160.Company;
import com.Vlad160.Computer;
import com.Vlad160.Condition;
import com.Vlad160.DesEncrypter;
import javax.crypto.SecretKey;
import java.io.*;
import java.util.Scanner;

public class ComputerReader implements FileReader, Serializable {
    private RandomAccessFile file;

    @Override
    public boolean readComputer(String path, Company company) {
        try {
            file = new RandomAccessFile(path, "r");
            while (true) {
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

    @Override
    public Company readBytes(String path) {
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream oin = new ObjectInputStream(fis);
            Company company = (Company)oin.readObject();
            return company;
        } catch (IOException e) {
            System.out.println("Can'r read serialized");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        }
        return null;
    }

    @Override
    public boolean read(String path, SecretKey secretKey) {
        String string = "";
        File file = new File(path);
        try {
            Scanner in = new Scanner((new File(path)));
            while (in.hasNext()) {
                string += in.nextLine();
            }
            DesEncrypter desEncrypter = new DesEncrypter(secretKey);
            String str = desEncrypter.decrypt(string);
            if(file.delete()) {
                PrintWriter writer = new PrintWriter(path, "UTF-8");
                writer.write(str);
                writer.close();
            }
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}
