package baseball.view;

import baseball.model.BaseballGame;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGameView {

    public BaseballGameView() {

    }

    public void startView() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public int readUserInputView() {
        System.out.print("숫자를 입력해주세요 : ");
        return Integer.parseInt(Console.readLine());
    }

    public boolean showResult(BaseballGame result) {

        if(result.getStrike() == 3) {
            System.out.println("3스트라이크");
            return true;
        }
        if(result.getBall() == 0 && result.getStrike() == 0) {
            System.out.println("낫싱");
            return false;
        }

        if(result.getBall() != 0) {
            System.out.print(result.getBall() + "볼 ");
        }
        if(result.getStrike() == 0) {
            System.out.println();
        }
        if(result.getStrike() != 0) {
            System.out.println(result.getStrike() + "스트라이크");
        }
        return false;

    }

    public boolean showRestart() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = null;

        try {
            userInput = Console.readLine(); // 입력 예외처리 1, 2이외의 입력에 예외 터뜨려 ??
            if(!userInput.equals("1") && !userInput.equals("2"))
                throw new IllegalArgumentException("For incorrect number: " + userInput);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        if(userInput.equals("1"))
            return true;

        return false;
    }



}
