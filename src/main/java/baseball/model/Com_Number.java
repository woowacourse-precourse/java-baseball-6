package baseball.model;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Com_Number { // 난수 생성 기능

	private List<String> Com_Number_list;
	private String Com_Number;
	
	public  Com_Number() {
		setCom_Number();
	}
	
	public String getCom_Number_Str() {
		return Com_Number;	
	}

	// 난수 생성
	public void setCom_Number() {
		Com_Number_list = new ArrayList<>();
		while (Com_Number_list.size() < 3) {
			String randomNumber = Integer.toString(Randoms.pickNumberInRange(1, 9));
			if (!Com_Number_list.contains(randomNumber)) {
				Com_Number_list.add(randomNumber);
			}
		}Com_Number = String.join("", Com_Number_list);
	}

}
