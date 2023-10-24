package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class game {

    int[] ans = new int[10];
    int input, strike, ball;

    void init() { //변수(컴퓨터 선택 숫자, 볼, 스트라이크 갯수) 초기화
        for (int i = 0; i < ans.length; i++) {
            ans[i] = 0;
        }
        strike = 0;
        ball = 0;
    }

    void ran() { //컴퓨터 서로 다른 3개의 숫자 랜덤 선택
        for (int i = 1; i <= 3; i++) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (ans[randomNumber] == 0) {
                ans[randomNumber] = i;
            } else {
                i--;
            }
        }
    }

    void userInput() { //플레이어 수 입력
        System.out.print("숫자를 입력해주세요 : ");
        String inputString = Console.readLine();
        input = Integer.parseInt(inputString);

        if (input < 1 || input > 999) {
            exceptionHandler();
        }
    }

    void compareNumbers() { //플레이어 입력 수와 컴퓨터 선택 수 비교
        strike = 0;
        ball = 0;

        for (int i = 3; i > 0; i--) {
            if (ans[input % 10] == i) {
                strike++;
            } else if (ans[input % 10] != 0) {
                ball++;
            }
            input /= 10;
        }
    }

    void printResult() { //결과 출력
        if (ball != 0) {
            System.out.print(ball + "볼 ");
        }
        if (strike != 0) {
            System.out.print(strike + "스트라이크");
        }
        if (ball == 0 && strike == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
    }

    int finishCheck() { //게임 종료 조건 확인
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return 1;
        }
        return 0;
    }

    int playerChoice() { //플레이어 재시작/종료 선택
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String inputString = Console.readLine();
        input = Integer.parseInt(inputString);

        if(input != 1 && input!= 2) {
            exceptionHandler();
        }

        return input;
    }

    void exceptionHandler(){ //예외 처리
        throw new IllegalArgumentException();
    }
}
