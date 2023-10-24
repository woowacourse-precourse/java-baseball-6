package baseball.baseballGame;

import camp.nextstep.edu.missionutils.Console;

import java.util.Map;

/**
 * 콘솔에 출력하는 함수
 */
public class PrintConsole {

    public void printStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public int printInput() {
        System.out.println("숫자를 입력해주세요 : ");

        return Integer.parseInt(Console.readLine());
    }

    public void printOutput(Map<String, Integer> map) {
        int strike = map.get("strike");
        int ball = map.get("ball");

        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }

    public void printEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}

