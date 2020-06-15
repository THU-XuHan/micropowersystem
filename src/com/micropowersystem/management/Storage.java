package com.micropowersystem.management;

public class Storage extends Thread
{
	public Storage()
	{
		this.capacity = 0;
		this.currentEnergy = 0;
		this.inputPower = 0;
	}
	
	public void setCapacity(double capacity)
	{
		synchronized(this)
		{
			this.capacity = capacity;
		}
	}
	
	public double getCurrentEnergy()
	{
		synchronized(this)
		{
			return currentEnergy;
		}
	}
	
	public void setInputPower(double inputPower)
	{
		synchronized(this)
		{
			this.inputPower = inputPower;
		}
		if(!started)
		{
			started = true;
			this.start();
		}
	}
	
	// ģ����ʵ����ģ�͵Ĺ�����û��ʵ��ʵ��
	public void storage()
	{
		
	}
	
	public void run()
	{
		long timestampStart = System.currentTimeMillis();
		while(true)
		{
			// ��������ʱ�䣬�����µ�ǰ����ֵ
			long time = System.currentTimeMillis() - timestampStart;

			synchronized(this)
			{
				currentEnergy += inputPower * time/1000 * TIME_SCALE;
				if(currentEnergy > capacity)
				{
					currentEnergy = capacity;
				}
				if(currentEnergy < 0)
				{
					currentEnergy = 0;
				}
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
	
	private double capacity;
	private double currentEnergy;
	private double inputPower;
	
	// ��Ƿ����Ƿ�ʼ
	private boolean started = false;
	
	// �����е�ˢ��ʵ�ʼ��ʱ��(ms)
	private final long REFRESH_INTERVAL = 1000;
	// ����ʱ����ʵ��ʱ��ı�ֵ
	// ������ÿ����1000ms����Ӧϵͳ����5min
	private final long TIME_SCALE = 300;
}