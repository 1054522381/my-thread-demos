package cn.com.fubon.thread;


public class MyThreadSynchronized {

	public static void main(String[] args) {
		final Outputer outputer = new Outputer();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					outputer.output2("==========================");
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					outputer.output2("**************************");
				}
			}
		}).start();

	}

	static class Outputer {

		public void output(String name) {
			int len = name.length();
			//synchronized (this) {
				for (int i = 0; i < len; i++) {
					System.out.print(name.charAt(i));
				}
				System.out.println();
			//}
		}
		
		/*
		 * 方法上的synchronized相当于是对类对象this加锁，即使thread1跑output()，thread2跑output2()也不会有问题。
		 */
		public synchronized void output2(String name) {
			int len = name.length();
				for (int i = 0; i < len; i++) {
					System.out.print(name.charAt(i));
				}
				System.out.println();
		}

		/*
		 * static方法上的synchronized相当于是对类的字节码对象加锁，
		 * 效果同output()中的synchronized (this)==>synchronized (Outputer.class)
		 */
		public static synchronized void output3(String name) {
			int len = name.length();
				for (int i = 0; i < len; i++) {
					System.out.print(name.charAt(i));
				}
				System.out.println();
		}
	}

}

/*
现象：
==========================
*******=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*
=======
******=*=*=***********=*=*=*=*=*=*=*
================
**********************=*=*=*=*
======================
**************************
 */
