package cn.com.fubon.thread;

public class MyThread extends Thread{
	public MyThread(String name){
		super(name);
	}
	
	@Override
	public void run() {
		for(int i=0;i<=5000;i++)
			System.out.println("i=" + i + " MyThread run!" + this.getName());
	}
	
	public static void main(String[] args) {
		Thread myThread1 = new MyThread("myThread1");
		myThread1.start();
		
		Thread myThread2 = new MyThread("myThread2");
		myThread2.start();
	}
}
