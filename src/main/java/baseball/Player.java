package baseball;

import static camp.nextstep.edu.missionutils.Console.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Player {
	private List<Integer> numberList = new ArrayList<>();

	public void init() {
		numberList.clear();
		
		System.out.print("숫자를 입력해주세요 : ");

		try {
			String[] input = readLine().split("");

			if (input.length != 3) {
				throw new IllegalArgumentException("3개의 숫자를 입력해야 합니다.");
			}

			try {
				for (String s : input) {
					numberList.add(Integer.parseInt(s));
				}
			} catch (IllegalArgumentException e) {
				throw new IllegalArgumentException("숫자만 입력 가능합니다.");
			}
		} catch (NoSuchElementException e) {
			throw new IllegalArgumentException("값을 입력해야 합니다.");
		}
	}

	public List<Integer> getNumberList() {
		return numberList;
	}
}
