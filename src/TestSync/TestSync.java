package TestSync;

public class TestSync implements Runnable {

	private static int i = 0;

	private static synchronized void calculate() {//
		i = i + 1;
	}

	public void run() {
		for (int i = 0; i < 10000; i++) {
			System.out.println(Thread.currentThread().getName());
			calculate();
		}
	}

	public static void main(String[] args) {
		TestSync ts = new TestSync();
		Thread t1 = new Thread(ts);
		Thread t2 = new Thread(ts);
		t1.setName("T1");
		t2.setName("T2");
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(ts.i);
	}
}
