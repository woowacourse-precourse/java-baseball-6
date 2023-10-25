package baseball;

import java.util.ArrayList;
import java.util.List;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class GameResultHandler {
    public void displayResult(ResultCount result) {
        if (result.isMatched()) {
            if (result.strike == 0) {
                System.out.println(result.ball + "볼");
            } else if (result.ball == 0) {
                System.out.println(result.strike + "스트라이크");
            } else {
                System.out.println(result.ball + "볼 " + result.strike + "스트라이크");
            }
        } else {
            System.out.println("낫싱");
        }
    }

    public boolean isEnd(String userInput, List<Integer> answerNumber) {
        List<Integer> userInputList = new ArrayList<>();
        for (char c : userInput.toCharArray()) {
            userInputList.add(Character.getNumericValue(c));
        }
        return userInputList.equals(answerNumber);
    }

    public boolean handleGameEnd() {
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    
        String decision = readLine();
        if ("1".equals(decision)) {
            return true; 
        } else if ("2".equals(decision)) {
            System.out.println("게임 종료");
            Runtime.getRuntime().exit(0);
        } else {
            System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
        }
        return false; 
    }
}