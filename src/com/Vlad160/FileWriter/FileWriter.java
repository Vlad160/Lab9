package com.Vlad160.FileWriter;

import com.Vlad160.Company;

import javax.crypto.SecretKey;

/**
 * Created by User on 02.12.2016.
 */
interface FileWriter {
    boolean writeToBytes(String path, Company company);
    boolean writeToFile(String path, Company company);
    boolean write(String path, Company company, SecretKey secretKey);
}
