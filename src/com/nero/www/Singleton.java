package com.nero.www;

import java.util.concurrent.TimeUnit;

public class Singleton {

	private static Singleton instance;

	private Singleton() {
	}

	public static Singleton getInstance(String name) throws InterruptedException {
		if (null == instance) {
			System.out.println(name + " begin to get instance."); 
			synchronized (Singleton.class) {
				System.out.println(name + " get the lock.");
				if (null == instance) {
					System.out.println(name + " get new instance."); 
					TimeUnit.SECONDS.sleep(10);
					instance = new Singleton();
				}else{
					System.out.println(name + " the instance has been inited."); 
				}
			}
		}
		return instance;
	}
}
