package com.sourabh.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MasterRecord {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String moneyOwnedBy;
	@Column
	private String moneyOwnedTo;
	@Column
	private double amount;

	public String getMoneyOwnedBy() {
		return moneyOwnedBy;
	}

	public void setMoneyOwnedBy(String moneyOwnedBy) {
		this.moneyOwnedBy = moneyOwnedBy;
	}

	public String getMoneyOwnedTo() {
		return moneyOwnedTo;
	}

	public void setMoneyOwnedTo(String moneyOwnedTo) {
		this.moneyOwnedTo = moneyOwnedTo;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
