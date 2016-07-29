package com.cj.entity;

public class BaseEntity {
	private Location location;
	private Velocity velocity;
	private double mass;
	private Acceleration acceleration;
	public class Location
	{
		double x,y;
	}
	public class Velocity
	{
		double vx;
		double vy;
	}
	public class Acceleration
	{
		double ax,ay;
	}
}
