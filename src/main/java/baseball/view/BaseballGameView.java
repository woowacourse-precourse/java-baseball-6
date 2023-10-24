package baseball.view;

import baseball.model.Score;
import baseball.model.UserNumber;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGameView {

    public BaseballGameView() {}

    public void startView() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public UserNumber readUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");

        Integer input = Integer.parseInt(Console.readLine());
        UserNumber userNumber = new UserNumber(input);

        return userNumber;
    }

    public boolean showResult(Score result) {
        if (result.getStrike() == 3) {
            System.out.println("3스트라이크");
            return true;
        }

        if (result.getBall() == 0 && result.getStrike() == 0) {
            System.out.println("낫싱");
            return false;
        }

        if (result.getBall() != 0) {
            System.out.print(result.getBall() + "볼 ");
        }

        if (result.getStrike() == 0) {
            System.out.println();
        }

        if (result.getStrike() != 0) {
            System.out.println(result.getStrike() + "스트라이크");
        }

        return false;
    }

    public boolean showRestart() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput;

        userInput = Console.readLine();

        if (!userInput.equals("1") && !userInput.equals("2"))
            throw new IllegalArgumentException("For incorrect number: " + userInput);

        if (userInput.equals("1")) {
            return true;
        }

        return false;
    }

}
