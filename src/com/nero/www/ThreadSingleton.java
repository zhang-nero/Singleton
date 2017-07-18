package com.nero.www;

public class ThreadSingleton extends Thread{
	
	private Singleton singleton;
	
	public ThreadSingleton(String name){
		super(name);
	}
	
	public void run(){
		try {
			singleton = Singleton.getInstance(super.getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
