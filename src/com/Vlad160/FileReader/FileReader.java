package com.Vlad160.FileReader;

import com.Vlad160.Company;
import javax.crypto.SecretKey;

interface  FileReader {
    boolean readComputer(String path, Company company);
    Company readBytes(String path);
    boolean read(String path, SecretKey secretKey);
}
