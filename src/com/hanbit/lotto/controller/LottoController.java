package com.hanbit.lotto.controller;

import javax.swing.JOptionPane;
import com.hanbit.lotto.domain.LottoBean;
import com.hanbit.lotto.service.LottoService;
import com.hanbit.lotto.serviceImpl.LottoServiceImpl;

public class LottoController {
	public static void main(String[] args){
		
		LottoBean bean = null;
		LottoService service = new LottoServiceImpl();
		
		while(true){
			switch(JOptionPane.showInputDialog("0.종료 1.CreateLotto")){
				case"0":
					JOptionPane.showMessageDialog(null, "Stop");
					return;
				case"1": 
					bean = new LottoBean();
					bean.setMoney(Integer.parseInt(JOptionPane.showInputDialog("얼마치를 구입하십니까?")));
					service.setLottos(bean);
					
					int[][] lottos = service.getLottos();
					for(int i=0; i<lottos.length; i++){
						for(int j=0; j<lottos[i].length; j++){
							System.out.print(lottos[i][j]+"\t");
						}
						System.out.println("");
					}
					break;
			}
		}
	}
}
