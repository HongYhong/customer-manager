package com.hongfox.utility;

import java.util.Scanner;

/**
 * @Description
 * @author yanhong hong Email:a524664992@gmail.com
 * @version
 * @data 2020年5月2日下午12:06:02
 *
 *
 *
 */
public class CMUtility {
	private static Scanner scanner = new Scanner(System.in);

	/**
	 * 
	 * @Description 从键盘上读取一行作为字符串。blankReturn如果为true表示允许返回一个空白值。
	 * @author yanhong hong Email:a524664992@gmail.com
	 * @version
	 * @data 2020年5月2日下午1:32:43
	 *
	 *
	 * @param limit
	 * @param blankReturn
	 * @return
	 *
	 */
	public CMUtility() {

	}

	public static String readKeyBoard(int limit, boolean blankReturn) {
		String line = "";
		while (scanner.hasNextLine()) {
			line = scanner.nextLine();
			if (line.length() == 0) {
				if (blankReturn) {
					return line;
				} else {
					continue;
				}
			}
			if (line.length() < 1 || line.length() > limit) {
				System.out.println("wrong input:out of range.");
				System.out.println("重新输入：");
				continue;
			}
			break;
		}
		return line;
	}

	/**
	 * 
	 * @Description 填写性别时使用。
	 * @author yanhong hong Email:a524664992@gmail.com
	 * @version
	 * @data 2020年5月2日下午12:08:29
	 *
	 *
	 * @return
	 *
	 */
	public static char readChar() {
		String str = readKeyBoard(1, false);
		return str.charAt(0);
	}

	/**
	 * 
	 * @Description 在修改性别时使用
	 * @author yanhong hong Email:a524664992@gmail.com
	 * @version
	 * @data 2020年5月2日下午1:32:10
	 *
	 *
	 * @param defaultValue
	 * @return
	 *
	 */
	public static char readChar(char defaultValue) {
		String str = readKeyBoard(1, true);
		return (str.equals("")) ? defaultValue : str.charAt(0);
	}

	/**
	 * 
	 * @Description 添加用户年龄
	 * @author yanhong hong Email:a524664992@gmail.com
	 * @version
	 * @data 2020年5月2日下午1:36:45
	 *
	 *
	 * @return
	 *
	 */
	public static int readInt() {
		int num;
		String str;
		for (;;) {
			str = readKeyBoard(2, false);
			try {
				num = Integer.parseInt(str);
				break;
			} catch (NumberFormatException e) {
				System.out.println("wrong input,input a number please.");
			}
		}
		return num;
	}

	/**
	 * 
	 * @Description 用于替换年龄
	 * @author yanhong hong Email:a524664992@gmail.com
	 * @version
	 * @data 2020年5月2日下午1:57:52
	 *
	 *
	 * @param defaultValue
	 * @return
	 *
	 */
	public static int readInt(int defaultValue) {
		int num;
		String str;
		for (;;) {
			str = readKeyBoard(2, true);
			if (str.equals("")) {
				return defaultValue;
			}
			try {
				num = Integer.parseInt(str);
				return num;
			} catch (NumberFormatException e) {
				System.out.println("wrong input,please input a number.");
			}
		}
	}

	/**
	 * 
	 * @Description 用于姓名输入,当且仅当输入-1时可以退出输入。
	 * @author yanhong hong Email:a524664992@gmail.com
	 * @version
	 * @data 2020年5月2日下午2:05:07
	 *
	 *
	 * @param limit
	 * @return
	 *
	 */
	public static String readString(int limit) {
		String str ;
		str = readKeyBoard(limit, false);
		return str;
	}

	/**
	 * 
	 * @Description 姓名替换
	 * @author yanhong hong Email:a524664992@gmail.com
	 * @version
	 * @data 2020年5月2日下午2:06:40
	 *
	 *
	 * @param limit
	 * @return
	 *
	 */
	public static String readSrting(int limit, String defaultValue) {
		String str = readKeyBoard(limit, true);
		return str.equals("") ? defaultValue : str;
	}

	/**
	 * 
	 * @Description 确认退出。
	 * @author yanhong hong Email:a524664992@gmail.com
	 * @version
	 * @data 2020年5月2日下午3:21:39
	 *
	 *
	 * @return
	 *
	 */
	public static char readConfirmSelection() {
		String str;
		for (;;) {
			str = readKeyBoard(1, false).toUpperCase();
			char c = str.charAt(0);
			if (c == 'Y' || c == 'N') {
				return c;
			} else {
				System.out.println("wrong input,input a new char please.");
			}
		}
	}

	/**
	 * 
	 * @Description 菜单选择
	 * @author yanhong hong Email:a524664992@gmail.com
	 * @version
	 * @data 2020年5月2日下午3:31:04
	 *
	 *
	 * @return
	 *
	 */
	public static char readMenuSelection() {
		String str;
		for (;;) {
			str = readKeyBoard(1, false).toUpperCase();
			char c = str.charAt(0);
			if (c == '1' || c == '2' || c == '3' || c == '4' || c == '5') {
				return c;
			} else {
				System.out.println("wrong input,enter 1-5.");
			}
		}
	}
}
