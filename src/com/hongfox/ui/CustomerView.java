package com.hongfox.ui;

import com.hongfox.bean.Account;
import com.hongfox.bean.Customer;
import com.hongfox.service.CustomerList;
import com.hongfox.utility.CMUtility;

public class CustomerView {
	private CustomerList customerlist = new CustomerList(10);

	private void addNewCustomer() {
		Customer cust = new Customer();
		System.out.println("------------------------添加用户----------------------------");
		System.out.print("输入姓名：");
		cust.setName(CMUtility.readString(4));
		System.out.print("输入年龄： ");
		cust.setAge(CMUtility.readInt());
		System.out.print("输入电话：");
		cust.setPhone(CMUtility.readString(11));
		System.out.print("输入性别：");
		cust.setGender(CMUtility.readChar());
		System.out.print("输入邮箱：");
		cust.setEmail(CMUtility.readString(30));
		System.out.print("输入账户初始余额：");
		double balance = CMUtility.readDouble();
		System.out.println("输入账号年利率：");
		double annualInterestRate = CMUtility.readDouble();
		cust.setAccount(new Account(balance, annualInterestRate));
		boolean flag = customerlist.addCustomer(cust);
		if (flag == true) {
			System.out.println("插入成功。");
		} else {
			System.out.println("插入失败。");
		}
	}

	public void modifyCustomer() {
		int index = -1;
		Customer cust = null;
		while (true) {
			System.out.println("------------------------------修改用户-----------------------------");
			System.out.println("请输入用户的序号（输入-1退出）：");
			index = CMUtility.readInt();
			if (index == -1) {
				break;
			}
			cust = customerlist.getCustomer(index);
			if (cust == null) {
				System.out.println("找不到指定的用户。");
			} else {
				break;
			}
		}

		System.out.print("姓名(" + cust.getName() + ")");
		String name = CMUtility.readSrting(4, cust.getName());
		System.out.print("年龄(" + cust.getAge() + ")");
		int age = CMUtility.readInt(cust.getAge());
		System.out.print("性别(" + cust.getGender() + ")");
		char gender = CMUtility.readChar(cust.getGender());
		System.out.print("电话(" + cust.getPhone() + ")");
		String phone = CMUtility.readSrting(11, cust.getPhone());
		System.out.println("邮箱(" + cust.getEmail() + ")");
		String email = CMUtility.readSrting(20, cust.getEmail());
		System.out.println("年利率(" + cust.getAccount().getAnnualInterestRate() + "):");
		double annual = CMUtility.readDouble(cust.getAccount().getAnnualInterestRate());
		Customer newCust = new Customer(name, gender, age, phone, email);
		newCust.getAccount().setAnnualInterestRate(annual);
		customerlist.replaceCustomer(index, newCust);
	}

	public void deleteCustomer() {
		int index = -1;
		Customer cust;
		while (true) {
			System.out.println("------------------------删除用户------------------------------");
			System.out.println("输入-1退出。");
			index = CMUtility.readInt();
			if (index == -1) {
				break;
			}
			cust = customerlist.getCustomer(index);
			if (cust == null) {
				System.out.println("找不到指定的用户。");
			} else {
				System.out.println("确认删除吗？（Y/N）：");
				char c = CMUtility.readConfirmSelection();
				boolean flag;
				if (c == 'Y') {
					flag = customerlist.deleteCustomer(index);
					if (flag == true) {
						System.out.println("删除成功。");
					} else {
						System.out.println("删除失败。");
					}
					break;

				}

			}
		}
	}

	public void showCustList() {
		System.out.println("------------------------用户列表------------------------------");
		System.out.println(
				"姓名        年龄               性别           电话               邮箱                                       余额                  年利率");
		for (int i = 0; i < customerlist.getTotal(); i++) {
			Customer[] custs = customerlist.getAllCustomers();
			System.out.println(custs[i].getName() + "     " + custs[i].getAge() + "          " + custs[i].getGender()
					+ "     " + custs[i].getPhone() + "     " + custs[i].getEmail() + "           "
					+ custs[i].getAccount().getBalance() + "       " + custs[i].getAccount().getAnnualInterestRate());
		}
	}

	public void depositAndWithdraw() {
		for (;;) {
			System.out.println("------------------------存取钱服务-----------------------------");
			System.out.println("输入要操作的用户编号：（输入-1退出返回主界面）：");
			int index = CMUtility.readInt();
			if (index == -1) {
				break;
			} else {
				Customer cust = customerlist.getCustomer(index);
				if (cust == null) {
					System.out.println("找不到指定的用户。");
				} else {
					for (;;) {
						System.out.println("存钱请输入：1，取钱请输入2：(输入-1退出)");
						int operation = CMUtility.readInt();
						if (operation == -1) {
							break;
						}
						if (operation != 1 && operation != 2) {
							System.out.println("输入错误，重新输入。");
							
						}else if (operation == 1) {
							System.out.println("存钱金额为：（输入-1退出）");
							double amount = CMUtility.readDouble();
							if (amount == -1) {
								break;
							}
							cust.getAccount().deposit(amount);
						}else {
							System.out.println("取钱金额为：(输入-1退出)");
							double amount = CMUtility.readDouble();
							if (amount == -1) {
								break;
							}
							cust.getAccount().withDraw(amount);
						}
					}
				}
			}
		}
	}

	public void enterMainMenu() {
		boolean isFlag = true;
		while (isFlag) {
			System.out.println("------------------------客户信息管理----------------------------");
			System.out.println(
					"                          1 添加客户                                                         ");
			System.out.println(
					"                          2 修改客户                                                         ");
			System.out.println(
					"                          3 删除客户                                                         ");
			System.out.println(
					"                          4 客户列表                                                         ");
			System.out.println(
					"                          5 存取钱                                                             ");
			System.out.println(
					"                          6 退出                                                                ");
			System.out.println();
			System.out.println("请选择(1-5):");
			isFlag = false;
		}
	}

	public static void main(String[] args) {
		CustomerView customerview = new CustomerView();
		boolean isFlag = true;
		while (isFlag) {
			customerview.enterMainMenu();
			switch (CMUtility.readMenuSelection()) {
			case '1':
				customerview.addNewCustomer();
				break;
			case '2':
				customerview.modifyCustomer();
				break;
			case '3':
				customerview.deleteCustomer();
				break;
			case '4':
				customerview.showCustList();
				break;
			case '5':
				customerview.depositAndWithdraw();
				break;
			case '6':
				char confirm = CMUtility.readConfirmSelection();
				if (confirm == 'Y') {
					isFlag = false;
				}
				break;
			}
		}
	}
}
