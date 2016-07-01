package cn.com.fubon.thread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MyTimer {
	public static void main(String[] args) {

		/*
		TimerTask是一个抽象类，实现了Runnable接口。
		*/
		new Timer().schedule(new TimerTask() {

			@Override
			public void run() {
				System.out.println("time up!");
			}
		}, 3000, 2000); //定时器在3秒以后启动，启动之后每隔2秒跑一次

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
