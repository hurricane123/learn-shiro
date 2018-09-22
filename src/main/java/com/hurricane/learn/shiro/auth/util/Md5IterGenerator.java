package com.hurricane.learn.shiro.auth.util;

import org.apache.shiro.crypto.hash.Md5Hash;

public class Md5IterGenerator {

	public static String getEncodeString(String rawString) {
		Md5Hash md5Hash = new Md5Hash(rawString, "sss", 2);
		return md5Hash.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(getEncodeString("123"));
	}
}
