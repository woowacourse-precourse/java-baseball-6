package baseball.domain.player;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerPlayer {
	private int[] numberList;

	public ComputerPlayer() {
		setComputerNumberArray();
		//System.out.println("컴퓨터 정답 = " + numberList[0] +"" +  numberList[1] +""+  numberList[2]);
	}

	public int[] getNumberArray() {
		return numberList;
	}

	private void setComputerNumberArray() {
		List<Integer> list = new ArrayList<>();
		while (list.size() < 3) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			if (!list.contains(randomNumber)) {
				list.add(randomNumber);
			}
		}
		numberList = list.stream().mapToInt(i -> i).toArray();
	}
}
