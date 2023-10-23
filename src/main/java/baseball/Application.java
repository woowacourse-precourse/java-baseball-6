package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import setting.RandomNum;

public class Application {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 랜덤 숫자 생성
		String strAnswer = "";
		RandomNum ramdomNum = new RandomNum();
		strAnswer = ramdomNum.setRandomNum();
		System.out.println(strAnswer);

		// 게임 시작
		int checkNum = 0;
		System.out.println("숫자 야구 게임을 시작합니다.");
		while (true) {
			int strikeCnt = 0;
			System.out.println("숫자를 입력해주세요 : ");
			checkNum = sc.nextInt();
			System.out.println(checkNum);
			String strCheckNum = "" + checkNum;

			for (int i = 0; i < 3; i++) {
				if (strAnswer.charAt(i) == strCheckNum.charAt(i)) {
					strikeCnt++;
				}
			}
			if (strikeCnt != 0) {
				System.out.println(strikeCnt + "스트라이크");
			}

			if (strikeCnt == 3) {
				System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
				int checkPlay = sc.nextInt();
				if (checkPlay == 1) {
					//
				} else if (checkPlay == 2) {
					break;
				} else {
					//
				}
			}
		}
		sc.close();

	}
}
