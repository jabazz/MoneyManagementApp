package com.sourabh.Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Transaction")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column
	private String payerName;
	@Column
	private double amount;
	@Column
	private String splitBetween;
	@Column
	private int numberOfPerson;
	
	@Transient
	private List<String> personDividedbetween;
	
	
	public List<String> getPersonDividedbetween() {
		return personDividedbetween;
	}

	public void setPersonDividedbetween(List<String> personDividedbetween) {
		this.personDividedbetween = personDividedbetween;
	}

	public int getNumberOfPerson() {
		return numberOfPerson;
	}

	public void setNumberOfPerson(int numberOfPerson) {
		this.numberOfPerson = numberOfPerson;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getSplitBetween() {
		return splitBetween;
	}

	public void setSplitBetween(String splitBetween) {
		this.splitBetween = splitBetween;
	}

	public String getPayerName() {
		return payerName;
	}

	public void setPayerName(String payerName) {
		this.payerName = payerName;
	}

}
