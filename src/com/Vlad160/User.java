package com.Vlad160;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by User on 03.12.2016.
 */
 public class User {
    private long password;
    private File user;
    public User(){
        user = new File("user.txt");
    }
    public boolean checkPassword(String str){
        try {
            if (user.exists() && user.isFile()) {
                Scanner in = new Scanner(user);
                String password = in.nextLine();
                if (str.hashCode() == Long.valueOf(password)) {
                    System.out.println("Correct password");
                    return true;
                }
                else {
                    System.out.println("Wrong password");
                    return false;
                }
            }
            if (!user.exists()) {
                password = str.hashCode();
                PrintWriter writer = new PrintWriter(user, "UTF-8");
                writer.write(String.valueOf(password));
                writer.close();
                return true;
            }
        }
        catch (IOException e){
            System.out.println("IOException");
        }
        return false;
    }


}
