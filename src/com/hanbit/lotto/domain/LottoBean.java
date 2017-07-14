package com.hanbit.lotto.domain;

import java.io.Serializable;

public class LottoBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	//stream에 의해 전송 가능한 객체가 됨 -> 네트워크에서 사용가능
	//객체 직렬화 : 인스턴스 변수 값을 직렬화
	
	private int money, number;

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getNumber() {
		setNumber();
		return number;
	}

	public void setNumber() {
		this.number = (int)(Math.random()*45+1);
	}

	@Override
	public String toString() {
		return "LottoBean [money=" + money + ", number=" + number + "]";
	}
}
