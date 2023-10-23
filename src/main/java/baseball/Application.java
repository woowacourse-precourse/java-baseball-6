package baseball;

import java.util.*;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
	public static void main(String[] args) throws IllegalArgumentException {
		try {
			System.out.println("숫자 야구 게임을 시작합니다.");
			
			List<Integer> computer = new ArrayList<>();
			// 컴퓨터의 랜덤 3개 숫자를 저장할 List
			
			while (computer.size() < 3) { // 저장한 숫자 개수가 3개 미만일 때
				int randNum = Randoms.pickNumberInRange(1, 9);
				// 1 ~ 9 까지의 숫자 중 하나를 랜덤으로 선택
				
				if(!computer.contains(randNum)) {
					computer.add(randNum);
				} // 컴퓨터 숫자 리스트에 랜덤 숫자가 없다면 리스트에 추가
			} // while end
			// 컴퓨터가 랜덤 숫자 3개를 저장함
			
			String userInput = Console.readLine();
			// 사용자가 숫자 3개를 입력함
			
			List<Integer> userNum = new ArrayList<>();
			// 사용자가 입력한 숫자를 저장할 리스트
			
			int ball = hitBall(computer, userNum); // 볼의 개수
			int strike = hitStrike(computer, userNum); // 스트라이크의 개수
			
			if (ball == 0 && strike == 0)
				hitNothing();
			else if (ball == 0 && strike == 3) {
				System.out.println("" + strike + "스트라이크");
				System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
				return;
			} else if ()
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}

	public static int hitBall(List com, List user) { // 볼 계산
		int ball = 0;
		
		return ball;
	}

	public static int hitStrike(List com, List user) { // 스트라이크 계산
		int strike = 0;
		
		for (int i = 0; i < 3; i++) {
			if (com.get(i) == user.get(i))
				strike++;
		}
		
		return strike;
	}

	public static void hitNothing() {
		System.out.println("낫싱");
	}
}
