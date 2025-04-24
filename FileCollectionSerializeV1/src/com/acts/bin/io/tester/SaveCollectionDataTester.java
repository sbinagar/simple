package com.acts.bin.io.tester;


import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import com.acts.bin.io.util.BinFileIOUtils;
import com.acts.bin.io.util.DataUtils;

public class SaveCollectionDataTester {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter file name:");
			String fileName = sc.nextLine();
			File file = new File(fileName);
			if(!file.exists()) {
				file.createNewFile();
			}
			//Save Book
			BinFileIOUtils.saveBooks(DataUtils.getBooksMap(), fileName);
			System.out.println("Data written successfully");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
