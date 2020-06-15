package com.micropowersystem.management;

public class PowerSystem extends Thread
{
	public PowerSystem()
	{
		this.price = 0;
		this.providePower = true;
		this.start();
	}
	
	public void setPrice(double price)
	{
		synchronized(this)
		{
			this.price = price;
		}
	}
	
	public double getPrice()
	{
		return price;
	}
	
	public void setCondition(boolean providePower)
	{
		synchronized(this)
		{
			this.providePower = providePower;
		}
	}
	
	public boolean getCondition()
	{
		return providePower;
	}

	public void run()
	{
		long timestampStart = System.currentTimeMillis();
		while(true)
		{
			// ��������ʱ�䣬�����µ�ǰʱ�̵ĵ��
			timestamp += (System.currentTimeMillis() - timestampStart)*TIME_SCALE;
			
			// TODO ���ݵ�ǰ��ʱ������µ����Ϣ
			synchronized(this)
			{
				// price = ... ;
			}
			
			// ����һ��ʱ���ٽ���ˢ��
			timestampStart = System.currentTimeMillis();
			try
			{
				Thread.sleep(REFRESH_INTERVAL);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}

	// �����е�ϵͳʱ�䣬��1970��1��1�� 0:00 ��ʼ���㾭����ms��
	private long timestamp = 0;
	private double price;
	private boolean providePower;

	// �����е�ˢ��ʵ�ʼ��ʱ��(ms)
	private final long REFRESH_INTERVAL = 1000;
	// ����ʱ����ʵ��ʱ��ı�ֵ
	// ������ÿ����1000ms����Ӧϵͳ����5min
	private final long TIME_SCALE = 300;
	
	
}
