package mypack;


class NewThread implements Runnable
{
	Thread t;
	NewThread()
	{
		t = new Thread(this, "temp");
	}
	
	public void run()
	{
		for(int i = 0; i<5; i++)
		{
			System.out.println(i);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

public class ThreadDemo {

	public static void main(String[] args)
	{
		NewThread t1 = new NewThread();
		t1.t.start();;
	}
}
