package com.diego.threads;

public class Main {
	
	public static void main(String[] args) {
		Countdown countdown = new Countdown();
		
		CountdownThread t1 = new CountdownThread(countdown);
		t1.setName("Thread 1");
		
		CountdownThread t2 = new CountdownThread(countdown);
		t2.setName("Thread 2");
		
		t1.start();
		t2.start();
	}
}

class Countdown {
	
	private int i;
	
	public void doCountdown() {
		String name;
		
		switch(Thread.currentThread().getName()) {
			case "Thread 1":
				name = "Daryl";
				break;
			case "Thread 2":
				name = "Maggie";
				break;
			default:
				name = "Rick";
				break;
		}
		
		synchronized(this) {
			for(i=10; i>0; i--) {
				System.out.println(Thread.currentThread().getName()+": "+name+" is going to hit Negan "+i+" times");
			}
		}
	}
}

class CountdownThread extends Thread {
	private Countdown threadCountdown;
	
	public CountdownThread(Countdown countdown) {
		threadCountdown = countdown;
	}
	
	public void run() {
		threadCountdown.doCountdown();
	}
}