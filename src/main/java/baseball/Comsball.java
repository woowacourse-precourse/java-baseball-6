package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Comsball {
	
	int[] coms_ball = new int[3];

	public int[] make_ball() {

		List<Integer> num = new ArrayList<>();

		while (num.size() < 3) {
			int ran = Randoms.pickNumberInRange(1, 9);
			if (!num.contains(ran)) {
				num.add(ran);
			}

		}

		for (int i = 0; i < 3; i++) {
			coms_ball[i] = num.get(i);
		}

		return coms_ball;
	}
}