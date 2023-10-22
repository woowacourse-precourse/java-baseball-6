package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

import java.util.List;

public class ComputerOutput {
	private List<Integer> computerList = new ArrayList<>();
	private	List<String> strComputerList = new ArrayList<>(); 
	public void MakeComNum() {
	
		while (computerList.size() < 3) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			if (!computerList.contains(randomNumber)) {
				computerList.add(randomNumber);
			}
		}
		for (Integer number : computerList) {
			String str = Integer.toString(number);
			strComputerList.add(str);
		}
	}
	
	public List<String> getComNum() {
		return strComputerList;
	}
	
}