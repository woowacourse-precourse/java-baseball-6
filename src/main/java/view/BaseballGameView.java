package view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class BaseballGameView {
    public List<Integer> getUserNumberList() {
        System.out.println("숫자를 입력해주세요 : ");
        String userNumberInput = Console.readLine();

        int parsedUserInput = parseUserNumberInput(userNumberInput);
        return getUserNumberList(parsedUserInput);
    }

    public void printJudgementMessage(List<Integer> gameResult) {
        int strikeCount = gameResult.get(0);
        int ballCount = gameResult.get(1);

        if (strikeCount == 0 && ballCount == 0) {
            System.out.println("낫싱");
        } else if (strikeCount == 0 && ballCount > 0) {
            System.out.println(ballCount + "볼");
        } else if (strikeCount > 0 && ballCount == 0) {
            System.out.println(strikeCount + "스트라이크");
        } else if (strikeCount > 0 && ballCount > 0) {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        }
    }

    public int isContinue() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String userInput = Console.readLine();

        return Integer.parseInt(userInput);
    }

    public void printGameStartingMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printGameClosingMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private int parseUserNumberInput(String userNumberInput) {
        int parsedUserNumber;

        try {
            parsedUserNumber = Integer.parseInt(userNumberInput);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다");
        }

        if (parsedUserNumber < 100 || parsedUserNumber > 999) {
            throw new IllegalArgumentException("3자리 숫자만 입력할 수 있습니다");
        }
        return parsedUserNumber;
    }

    private List<Integer> getUserNumberList(int userNumber) {
        List<Integer> userNumberList = new ArrayList<>();
        userNumberList.add(userNumber / 100);
        int remainder = userNumber % 100;
        userNumberList.add(remainder / 10);
        userNumberList.add(remainder % 10);

        return userNumberList;
    }
}
