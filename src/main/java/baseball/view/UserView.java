package baseball.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class UserView {
    final String InputMessage = "숫자를 입력해주세요 : ";
    List<Integer> userInputList;

    public UserView() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public List<Integer> inputBaseballNumber() {
        System.out.print(InputMessage);
        userInputList = new ArrayList<>();
        verifys(Console.readLine());
        return userInputList;
    }

    private void verifys(String userInput) {
        verifyValidLength(userInput);
        verifyValidNumber(userInput);
    }

    private void verifyValidLength(String userInput) {
        if (userInput.length() != 3) {
            throw new IllegalArgumentException("길이가 맞지 않습니다." + userInput);
        }
    }

    private void verifyValidNumber(String userInput) {

        for (char ch : userInput.toCharArray()) {
            if (!Character.isDigit(ch)) {
                throw new IllegalArgumentException("잘못된 값을 입력하셨습니다: " + userInput);
            }
            userInputList.add(Character.getNumericValue(ch));
        }
    }

    public void printStrikeAndBall(int[] strikeAndBall) {
        if (strikeAndBall[1] > 0) {
            System.out.print(strikeAndBall[1] + "볼 ");
        }
        if (strikeAndBall[0] > 0) {
            System.out.print(strikeAndBall[0] + "스트라이크 ");
        }

        if (strikeAndBall[0] == 3) {
            System.out.println();
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
        
        if (strikeAndBall[0] == 0 && strikeAndBall[1] == 0) {
            System.out.println("낫싱");
        }
    }

    public String restartGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }

}
