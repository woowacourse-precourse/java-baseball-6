package baseball;

import camp.nextstep.edu.missionutils.Console;

import static baseball.ExeptionMessage.NOT_NUMBER;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        BaseballGameManager baseballGameManager = BaseballGameManager.getInstance();

        while(true) {
            baseballGameManager.run();
            if(endGame()) break;
        }
    }

    private static Boolean endGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 다시 시작하려면 1, 종료하려면 2를 입력하세요.");

        try {
            if(Integer.valueOf(Console.readLine()) == 2) return true;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER);
        }
        return false;
    }
}
