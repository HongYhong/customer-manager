package com.hongfox.service;

import com.hongfox.bean.Customer;

public class CustomerList {
	Customer[] customers;
	private int total = 0;

	public CustomerList(int totalCustomer) {
		customers = new Customer[totalCustomer];
	}

	public boolean addCustomer(Customer cust) {
		if (total >= customers.length) {
			return false;
		} else {
			customers[total++] = cust;
			return true;
		}
	}

	public boolean replaceCustomer(int index, Customer cust) {
		if (index < 0 || index >= total) {
			return false;
		} else {
			customers[index] = cust;
			return true;
		}
	}

	public boolean deleteCustomer(int index) {
		if (index < 0 || index >= total) {
			return false;
		} else {
			for (int i = index; i < total ; i++) {
				customers[i] = customers[i + 1];
			}
			total--;
			return true;
		}
	}

	public Customer[] getAllCustomers() {
		Customer[] custs = new Customer[total];
		for (int i = 0; i < total; i++) {
			custs[i] = customers[i];
		}
		return custs;
	}
	
	public int getTotal() {
		return this.total;
	}
	
	public Customer getCustomer(int index) {
		return customers[index];
	}
}
