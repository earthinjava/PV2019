package com.duan.module.opening.bean;

import java.io.Serializable;

public class Ae implements Serializable{
	private static final long serialVersionUID = 1L;
	private A1 a1;
	private A2 a2;
	private A3 a3;
	private A4 a4;
	private double value;

	public double getValue() {
		if (a4 != null) {
			value = this.a1.getValue() + this.a2.getValue() + this.a3.getValue() + a4.getValue();
		} else {
			value = this.a1.getValue() + this.a2.getValue() + this.a3.getValue();
		}
		return value;
	}

	public Ae(A1 a1, A2 a2, A3 a3) {
		// TODO Auto-generated constructor stub
		this.a1 = a1;
		this.a2 = a2;
		this.a3 = a3;
	}

	public Ae(A1 a1, A2 a2, A3 a3, A4 a4) {
		this(a1, a2, a3);
		this.a4 = a4;
	}
	public A2 getA2() {
		return a2;
	}
	public A3 getA3() {
		return a3;
	}
	public A1 getA1() {
		return a1;
	}
	public A4 getA4() {
		return a4;
	}

}
