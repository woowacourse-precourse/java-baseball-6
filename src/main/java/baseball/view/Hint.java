package baseball.view;

import baseball.vo.Baseball;

/*
 *	힌트 및 소개 메세지  	
 */
public class Hint {
	private static Baseball b;
	
	public static void ball(Baseball b) {
		System.out.print(b.getBall() + "볼 ");
	}
	
	public static void strike(Baseball b) {
		System.out.print(b.getStrike() + "스트라이크");
	}
 
	public static void nothing() {
		System.out.print("낫싱");
	}
	
	public static void startMessage() {
		System.out.print("숫자 야구 게임을 시작합니다.");
	}
	
	
	public static void endMessage() {
		System.out.println("\n3개의 숫자를 모두 맞히셨습니다! 게임종료");
	}
	
	public static void gameOverMessage() {
		System.out.println("게임 종료");
	}
}
