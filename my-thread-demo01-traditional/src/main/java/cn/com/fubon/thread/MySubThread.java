package cn.com.fubon.thread;

public class MySubThread {
	
	/*
	 * 只会执行Thread的run()
	 */
	public static void main(String[] args) {
		Thread myThread = new Thread(
				new Runnable(){
					@Override
					public void run() {
						int i = 0;
						while(i<1000){
							System.out.println("i=>" + i + " runnable " + Thread.currentThread().getName());
							i++;
						}
						
					}
				}
				){
			@Override
			public void run() {
				int i = 0;
				while(i<1000){
					System.out.println("i=>" + i + " thread " + Thread.currentThread().getName());
					i++;
				}
			}
		};
		
		myThread.start();
	}

}
