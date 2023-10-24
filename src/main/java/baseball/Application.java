package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.*;

public class Application {
	public static void main(String[] args) {
		System.out.println("숫자 야구 게임을 시작합니다.");

		boolean keep = true; // 종료를 원할때 멈출 장치
		boolean answer = true; // 정답 맞추면 루프 탈출
		while (keep) { // 새로운 게임을 원하면 계속 반복
			answer = true; // 맞췄을때 재실행시 리셋
			List<Integer> comNumber = randomNum(); // 랜덤 넘버 생성

			while (answer) { // 맞출때까지 실행
				int strike = 0; // 스트라이크 갯수
				int ball = 0; // 볼 갯수
				System.out.println("숫자를 입력해주세요 : ");
				List<Integer> userNumber = new ArrayList<Integer>();
				String input = Console.readLine();
				if(input.length() != 3) {				// 입력값이 3자리가 아닐 경우
					throw new IllegalArgumentException("3자리 숫자를 입력해주세요");
				}
				if(input.charAt(0) == input.charAt(1) || input.charAt(0) == input.charAt(2) || input.charAt(1) == input.charAt(2)) {
					throw new IllegalArgumentException("서로 다른 숫자로 이루어진 3자리수");
				}
				if(input.charAt(0) == 0 || input.charAt(1) == 0 || input.charAt(2) == 0) {
					throw new IllegalArgumentException("1~9로 이루어진 숫자");
				}
				
				for (String number : input.split("")) {
					userNumber.add(Integer.parseInt(number)); // 사용자가 입력한 번호 유저넘에 입력
				}

				strike = strike(comNumber, userNumber);
				ball = ball(comNumber, userNumber);
				if (strike == 0 & ball == 0) {
					System.out.println("낫싱");
				} else if (strike == 3) {
					System.out.println("3스트라이크");
					System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
					answer = false;
					continue;
				} else if (strike == 0 & ball != 0) {
					System.out.printf("%d볼\n", ball);
				} else if (strike != 0 & ball == 0) {
					System.out.printf("%d스트라이크\n", strike);
				} else if (strike != 0 & ball != 0) {
					System.out.printf("%d볼 %d스트라이크\n",ball, strike);
				}

			}

			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			int go = Integer.parseInt(Console.readLine());
			if(go != 1 && go != 2) {
				throw new IllegalArgumentException("1또는 2를 입력하세요.");
			}
			if (go == 2) { // 게임 종료 선택
				keep = false; // 루프 탈출
			}
			
		}
		
		
	}

	public static List<Integer> randomNum() {
		List<Integer> computer = new ArrayList<>();
		while (computer.size() < 3) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			if (!computer.contains(randomNumber)) {
				computer.add(randomNumber);
			}
		}

		return computer;
	}

	public static int strike(List<Integer> comNumber, List<Integer> userNumber) { // 스트라이크 갯수
		int sum = 0;

		for (int i = 0; i < 3; i++) {
			if (comNumber.get(i).equals(userNumber.get(i))) {
				sum++;
			}
		}
		return sum;
	}

	public static int ball(List<Integer> comNumber, List<Integer> userNumber) { // 볼의 갯수
		int sum = 0;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == j) {
					continue;
				}
				if (comNumber.get(i).equals(userNumber.get(j))) {
					sum++;
				}
			}
		}
		return sum;
	}

}
