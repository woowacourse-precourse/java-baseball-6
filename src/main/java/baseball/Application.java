package baseball;

import static baseball.Constant.END_NUMBER;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        do {
            BaseballGame.play();
        } while (!checkEnd());
    }

    public static boolean checkEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String input = Console.readLine();
        InputValidation.checkRestartNumber(input);

        if (input.equals(END_NUMBER)) {
            return true;
        }

        return false;
    }
}
