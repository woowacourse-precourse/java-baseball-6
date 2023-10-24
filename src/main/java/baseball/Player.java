package baseball;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Player {

    public List<Integer> answer() {
        String answer = readLine();
        if (answer.length() != 3) {
            throw new IllegalArgumentException("답안 입력값이 세자리가 아닙니다.");
        }

        List<Integer> answerList = new ArrayList<>();

        for (int i = 0; i < answer.length(); i++) {
            char digitChar = answer.charAt(i);
            int intValue = Character.getNumericValue(digitChar);

            if (1 <= intValue && intValue <= 9) {
                answerList.add(intValue);
                continue;
            }

            throw new IllegalArgumentException("답안 입력값이 잘못되었습니다.");
        }

        return answerList;
    }

    public Integer askToStartNewGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String answer = readLine();
        int answerValue;

        try {
            answerValue = Integer.parseInt(answer);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("게임 재시작 여부를 위한 입력값 타입이 잘못되었습니다.");
        }

        if (answerValue == 1 || answerValue == 2) {
            return answerValue;
        }

        throw new IllegalArgumentException("게임 재시작 여부를 위한 입력값 값이 잘못되었습니다.");
    }

}
