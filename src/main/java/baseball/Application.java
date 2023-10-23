package baseball;

import camp.nextstep.edu.missionutils.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/*
숫자 야구 게임을 시작합니다.
숫자를 입력해주세요 : 123
1볼 1스트라이크
숫자를 입력해주세요 : 145
1볼
숫자를 입력해주세요 : 671
2볼
숫자를 입력해주세요 : 216
1스트라이크
숫자를 입력해주세요 : 713
3스트라이크
3개의 숫자를 모두 맞히셨습니다! 게임 종료
게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
1
숫자를 입력해주세요 : 123
1볼
...
 */
public class Application {

	public static void main(String[] args) {
		System.out.println("숫자 야구 게임을 시작합니다.");

		// Computer Randomized Number Generate
		List<Integer> computerNumbers = Randoms.pickUniqueNumbersInRange(1, 9, 3);
		System.out.println(computerNumbers);


	}
}
