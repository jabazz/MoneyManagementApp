package com.sourabh.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sourabh.DAO.RecordExpense;
import com.sourabh.Entity.MasterRecord;
import com.sourabh.Entity.Transaction;

public class SaveOpration {

	public static void saveTransaction(){
		String payerName;
		double amountPayed; 
		int noOfPerson;
		List<String> divedBetween = new ArrayList<String>();
		String nameOfPersonDividedBetween = "";
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the Name Who paid");
		payerName = sc.nextLine();
		
		System.out.println("Enter the amount paid");
		amountPayed = sc.nextDouble();
		
		System.out.println("Number of person to divede betweeen");
		noOfPerson = sc.nextInt();
		
		System.out.println("Enter "+noOfPerson +" names to Divide between");
		for (int i = 1 ; i <= noOfPerson ; ++i ){
			String person = sc.next();
			nameOfPersonDividedBetween = nameOfPersonDividedBetween + i +":" +person+"/";
			divedBetween.add(person);
		}
		Transaction t = new Transaction();
		t.setPersonDividedbetween(divedBetween);
		t.setPayerName(payerName);
		t.setAmount(amountPayed);
		t.setNumberOfPerson(noOfPerson);
		t.setSplitBetween(nameOfPersonDividedBetween);
		RecordExpense.insertTransaction(t);
		//save transaction in masterRecord
		saveMasterRecord(t);
		sc.close();  
	}
		
	private static void saveMasterRecord(Transaction transaction){
	
		List<String> payees = transaction.getPersonDividedbetween();
		for(String payee : payees){
			MasterRecord record = new MasterRecord();
			record.setAmount(transaction.getAmount()/payees.size());
			record.setMoneyOwnedTo(transaction.getPayerName());
			record.setMoneyOwnedBy(payee);
			RecordExpense.insertMasterRecord(record);
		}
	}

}
