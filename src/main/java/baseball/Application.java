package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {

	// 새로운 랜덤 숫자 생성하는 메서드
	public static List<Integer> getComNum() {
		List<Integer> computer = new ArrayList<>();
		while (computer.size() < 3) { // 3번 서로다른 랜덤 수 추가
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			if (!computer.contains(randomNumber)) {
				computer.add(randomNumber);
			}
		}
		return computer;
	}

	public static void main(String[] args) {
		// TODO: 프로그램 구현

		System.out.println("숫자 야구 게임을 시작합니다.");
		/*
		 * 1~9중 서로다른 수 3개 맞추기 상대방의 역할을 컴퓨터가 함 - 컴터는 1~9가지 임의의 서로다른 수 3개 선택 플레이어는 컴터가
		 * 생각중인 숫자 3개 입력하고, 컴터는 숫자에 대한 결과 출력 이 과정을 반복해서 컴터가 선택한 3개 숫자 모두 맞히면 겜 종료 겜 종료 후
		 * 다시시작하거나 완전히 종료할 수 있음 잘못된 값 입력한 경우, IllegalArgumentException 발생 후 애플리케이션 종료
		 * System.exit()호출하지 않음
		 */

		// computer가 생성한 3개의 랜덤 수
		List<Integer> computer = getComNum();
		//List<Integer> computer = Randoms.pickUniqueNumbersInRange(1, 9, 3);
		//System.out.println("테스트를 위한 정답 표시 : " + computer);
		String do_or_not = ""; // 재시작/종료 여부

		while (true) {

			// 다시하기의 경우, 새로운 수 받기
			if (do_or_not.equals("1")) {
				//computer = Randoms.pickUniqueNumbersInRange(1, 9, 3);
				computer = getComNum();
				do_or_not = "";
			}

			// 사용자 입력받기
			String userInput = Console.readLine();
			//System.out.println(userInput);

			// 올바르지 않은 입력 예외처리
			try {
				int a = Integer.parseInt(userInput); // 숫자로 변환해보기
				if (userInput.length() != 3) { // 3자리가 아닌 경우
					throw new IllegalArgumentException("잘못된 사용자 입력입니다.");
				}
			} catch (IllegalArgumentException e) {
				System.out.println("잘못된 사용자 입력입니다.");
				throw new IllegalArgumentException("잘못된 사용자 입력입니다.");
			}

			int strike = 0, ball = 0;

			// 스트라이크, 볼 판단
			for (int i = 0; i < 3; i++) {
				int com_num = computer.get(i); // 컴퓨터 숫자
				for (int j = 0; j < 3; j++) {
					int user_num = userInput.charAt(j) - '0'; // 사용자 숫자
					if (com_num == user_num) {
						if (i == j)
							strike++; // 스트라이크
						else
							ball++; // 볼
					}
				}
			}

			String result; // 결과 저장
			boolean win = false; // 이겼는지 여부
			if (strike == 0 && ball == 0) { // 낫싱
				result = "낫싱";
			} else if (strike == 3) { // 정답
				result = "3스트라이크\n" + "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
				win = true;
			} else {
				result = ball + "볼 " + strike + "스트라이크";
			}
			System.out.println(result);

			if (win) { // 이긴 경우 처리
				do_or_not = Console.readLine(); // 재시작여부 입력
				System.out.println(do_or_not);

				if (do_or_not.equals("1")) { // 재시작
					continue;
				} else if (do_or_not.equals("2")) { // 종료
					break;
				} else { // 1도 2도 아니면 잘못된 입력
					throw new IllegalArgumentException("잘못된 사용자 입력입니다.");
				}

			}
		}
		System.out.println("게임 종료");
	}
}