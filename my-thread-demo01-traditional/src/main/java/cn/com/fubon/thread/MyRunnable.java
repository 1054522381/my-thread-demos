package cn.com.fubon.thread;

import java.util.Date;

public class MyRunnable implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<=1000;i++){
			try {
				if(i%100 == 0){
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(new Date().getTime() + "=>i="
					+ i + " =>MyThread run!" + Thread.currentThread().getName());
		}
		
	}
	
	public static void main(String[] args) {
		Runnable runnable1 = new MyRunnable();
		Thread myThread1 = new Thread(runnable1,"myThread1");
		myThread1.start();
		
		Thread myThread2 = new Thread(runnable1,"myThread2");
		myThread2.start();
	}

}
