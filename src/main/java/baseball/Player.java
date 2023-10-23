package baseball;

import static camp.nextstep.edu.missionutils.Console.*;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private List<Integer> numberList = new ArrayList<>();

	public void init() {
		System.out.print("숫자를 입력해주세요 : ");
		String[] input = readLine().split("");
		for (String s : input) {
			numberList.add(Integer.parseInt(s));
		}
	}

	public List<Integer> getNumberList() {
		return numberList;
	}
}
