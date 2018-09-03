package com.revature.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.revature.bank.Bank;

public class FileManager {
	
	private static final String filename = "bankAccounts.dat";
	private static final String filenameTwo = "bankEmployees.dat";
	
	public static Bank initializeBank(){
		Bank bank = null;
		File fileOne = new File("bankAccounts.dat");
		if(fileOne.exists()) {
			bank = readAccounts(filename);
			
		}
			
		return bank;
	}
	
	public static void saveAccounts(Bank bank) {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))){
			oos.writeObject(bank);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Bank readAccounts(String filename) {
		Bank bank = null;
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))){
			bank = (Bank) ois.readObject();
			//displayPendingAccounts(getPendingAccounts());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return bank;
	}
}
