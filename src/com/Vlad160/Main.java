package com.Vlad160;

import com.Vlad160.FileReader.ComputerReader;
import com.Vlad160.FileWriter.ComputerWriter;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Company company = new Company("нагибаторы");
        ComputerReader computerReader = new ComputerReader();
        computerReader.readComputer("text.txt", company);
        ComputerWriter computerWriter = new ComputerWriter();
        computerWriter.writeToBytes("output.ser", company);
        Company company1;
        company1 = computerReader.readBytes("output.ser");
        System.out.println(company1.toString());
        computerWriter.writeToFile("output.txt", company1);
        User user = new User();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter password");
        String password = in.nextLine();
        if(user.checkPassword(password))
        try {
            SecretKey secretKey = KeyGenerator.getInstance("DES").generateKey();
            String encodedKey = Base64.getEncoder().encodeToString(secretKey.getEncoded());
            computerWriter.write("encx.txt", company, secretKey);
            computerReader.read("encx.txt", secretKey);
        } catch (Exception e) {
            System.out.println("Exception");
        }
    }
}
