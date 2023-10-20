package baseball;

import java.util.Scanner;

/* input, output 화면(메세지) 출력 */
public class BaseballView {
	// 게임 시작 메세지
	public void printGameStart() {
		System.out.println("숫자 야구 게임을 시작합니다.");
	}

	// 유저 숫자 입력 요청 메세지
	public void printUserNumber() {
		System.out.print("숫자를 입력해주세요 : ");
	}

	// 판정 결과 출력 - 볼, 스트라이크, 낫싱
	public void printResultBall(int count) {
		System.out.printf("%d볼 ", count);
	}

	public void printResultStrike(int count) {
		System.out.printf("%d스트라이크", count);
	}

	public void printResultNothing() {
		System.out.print("낫싱");
	}

	// 게임 종료 메세지
	public void printFinishGame() {
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
	}

	// 게임 재시작 혹은 종료 선택 입력 요청 메세지
	public void printSelectRestartOrEnd() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
	}

	/* 값을 입력 받을 때 사용 */
	// 유저 숫자 입력
	public String inputUserNumber() {
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}

	// 게임 재시작 혹은 종료 선택 입력
	public int inputSelectRestartOrEnd() {
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
}
