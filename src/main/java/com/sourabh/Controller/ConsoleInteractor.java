package com.sourabh.Controller;

import java.util.Scanner;

import com.sourabh.Service.RetriveOprations;
import com.sourabh.Service.SaveOpration;

public class ConsoleInteractor {


	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println(">>>>>>>>SMMS<<<<<<<<<<<");
		System.out.println("Enter 1 to submit a Tracsaction");
		System.out.println("Enter 2 to see one pair tracsaction");
		System.out.println("Enter 3 to see in payee's full debt");
		int choose = sc.nextInt();
		switch (choose) {
		case 1:
			SaveOpration.saveTransaction();
			break;
		case 2:
			System.out.println("Enter the name of the payee");
			String payee = sc.next();
			System.out.println("Enter the name of receiver");
			String receiver =sc.next();
			RetriveOprations.moneyOwnedPair(payee,receiver) ;
			break;
		case 3:
			System.out.println("Enter the name to see individual balance amount");
			String payeefulldebt = sc.next();
			RetriveOprations.individualBalance(payeefulldebt);
			break;
		default:
			System.out.println("Invalid entry");

		}
		

}
}
