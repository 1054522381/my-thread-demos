package cn.com.fubon.thread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/*
 * 每次都启一个定时器，时间间隔在2秒和4秒交替。
 */
public class MyAlternateTimer {
	static int count = 0;

	public static void main(String[] args) {

		class MyTimerTask extends TimerTask {
			@Override
			public void run() {
				count = (count + 1) % 2;
				System.out.println("time up!");
				new Timer().schedule(new MyTimerTask(), 2000 + 2000 * count);
			}
		}

		new Timer().schedule(new MyTimerTask(), 3000); // 定时器在3秒以后启动

		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(new Date().getSeconds());
		}

	}

}
