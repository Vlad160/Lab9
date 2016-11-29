package com.Vlad160.FileReader;

import com.Vlad160.Company;
import com.Vlad160.Computer;

import java.io.RandomAccessFile;

/**
 * Created by Vlad on 26.11.2016.
 */
interface  FileReader {
    boolean ReadComputer(String path, Company company);
}
