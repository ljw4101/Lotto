package com.hanbit.lotto.serviceImpl;

import com.hanbit.lotto.domain.LottoBean;
import com.hanbit.lotto.service.LottoService;

public class LottoServiceImpl implements LottoService {
	int[][] lottos;
	int[] lotto; //돈과 상관없이 생성되는 한 줄(숫자6) 로또
	private int count;
	
	/*영화 자리 예매일 경우 자리가 고정이므로 다음과 같이 초기화 해야한다.
	public LottoServiceImpl(int[][] lottos, int[] lotto, int count){
		this.lottos = new int[10][15];
		this.lotto = lotto;
		this.count = 0;
	}*/
	
	@Override
	public void setLottos(LottoBean bean) {
		//로또 만들기
		setCount(bean);
		lottos = new int[count][6];
		
		for(int i=0; i<lottos.length; i++){
			for(int j=0; j<lottos[i].length; j++){
				int num = bean.getNumber();
				if(!isDuplication(i, num)){
					lottos[i][j]=num;
				}
				else{
					j--;
				}
			}
			sort(lottos[i]);
		}
		
		/*
		int i=0;
		for(count=0; count<lottos.length; count++){
			while(true){
				int num = bean.getNumber();
				if(isDuplication(count, num)){
					continue; //반복문
				}
				lottos[count][i]=num;
				
				i++;
				if(i==lottos[count].length){
					sort(lottos[count]);
					i=0;
					break;
				}	
			}
		}*/
	}

	@Override
	public int[][] getLottos() {
		//만든 로또 가져오기
		return lottos;
	}

	@Override
	public boolean isDuplication(int count, int num) {
		//중복된 번호인지 체크(중복이면 true 리턴)
		boolean flag = false;
		
		for(int i=0; i<lottos[count].length; i++){
			if(lottos[count][i]==num){
				flag = true;
				break;
			}
		}
		return flag;
	}

	@Override
	public void sort(int[] arr) {
		// 오름차순으로 정렬
		int temp = 0;
		for(int i=0; i<arr.length-1; i++){
			for(int j=i+1; j<arr.length; j++){
				if(arr[i]>arr[j]){
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}

	@Override
	public int getCount() {
		return count;
	}

	@Override
	public void setCount(LottoBean bean) {
		//몇 줄을 출력할 것인지 로또 수 계산 (최대값 5줄)
		count = ((bean.getMoney()/1000)>5)?5:bean.getMoney()/1000;

	}
}
