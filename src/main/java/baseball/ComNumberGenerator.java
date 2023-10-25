package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

import java.util.List;

public class ComNumberGenerator {
	private final List<Integer> comGenerateNumList = new ArrayList<>();
	private	final List<String> stringComGenerateNumList = new ArrayList<>();
	public void comGenerateNum() {
	
		while (comGenerateNumList.size() < 3) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			if (!comGenerateNumList.contains(randomNumber)) {
				comGenerateNumList.add(randomNumber);
			}
		}
		for (Integer number : comGenerateNumList) {
			String str = Integer.toString(number);
			stringComGenerateNumList.add(str);
		}
	}
	
	public List<String> getComGenerateNumList() {
		return stringComGenerateNumList;
	}
	
}