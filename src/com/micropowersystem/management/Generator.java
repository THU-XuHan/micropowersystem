package com.micropowersystem.management;

public interface Generator
{
	// 传入发电机参数
	public void sendInfo(double voltage);

	// 设置天气对象
	public void setWeatherCondition(Weather weather);
	// 设置天气预测对象
	public void setWeatherForecast(WeatherForecast weatherForecast);
	
	// 获取发电机参数
	int NOMIAL = 0;
	int REALTIME = 1;
	public double getVoltage(int type);
	public double getCurrent(int type);
	public double getPower(int type);
	
	public double getVoltageForecast(long time);
	public double getCurrentForecast(long time);
	public double getPowerForecast(long time);
	
	// 读取发电机电能表数值
	public double getWattHour();
	
	// 设置微电网管理器
//	public void setManager(Manager _manager);
	
	// 物理接口，用于模拟实际系统的控制
	public void output();
}
