package com.nero.www;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args){
		ExecutorService executor = Executors.newCachedThreadPool();
		List<ThreadSingleton> threadSingletons = new ArrayList<>(10);
		for(Integer i = 0; i < 10; i++){
			threadSingletons.add(new ThreadSingleton(i.toString()));
		}
		
		for(ThreadSingleton threadSingleton: threadSingletons){
			executor.submit(threadSingleton);
		}
		
		try {
			TimeUnit.SECONDS.sleep(15);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Shutdown threadpool now."); 
		executor.shutdownNow();
	}

}
