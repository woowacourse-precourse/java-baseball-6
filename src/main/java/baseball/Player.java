package baseball;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Player {

    // TODO : 예외처리
    public List<Integer> answer() {
        String answer = readLine();
        List<Integer> answerList = new ArrayList<>();

        for (int i = 0; i < answer.length(); i++) {
            char digitChar = answer.charAt(i);
            int intValue = Character.getNumericValue(digitChar);
            answerList.add(intValue);
        }

        return answerList;
    }

    // TODO : 예외처리
    public Integer askToStartNewGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String answer = readLine();

        return Integer.parseInt(answer);
    }

}
