package baseball;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NumberBaseballGame {
    private static final String INPUT_MSG = "숫자를 입력해주세요 :";
    private static List<Integer> answer = new ArrayList<>();


    NumberBaseballGame(List<Integer> answer) {
        NumberBaseballGame.answer = answer;
    }

    void PlayBall() {
        boolean isCorrect = false;
        while (!isCorrect) {
            List<Integer> guess = new ArrayList<>();

            System.out.println(INPUT_MSG);
            String input = camp.nextstep.edu.missionutils.Console.readLine();
            //입력값 컨버젼
            if (input.length() != 3) {
                throw new IllegalArgumentException();
            }
            for (int i = 0; i < 3; i++) {
                int number = Character.getNumericValue(input.charAt(i));
                if (!guess.contains(number)) {
                    guess.add(number);
                } else {
                    throw new IllegalArgumentException();
                }
            }
            //결과 판정
            HashMap<String, Integer> result = new HashMap<>();
            result.put("스트라이크", 0);
            result.put("볼", 0);
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == j && answer.get(i).equals(guess.get(j))) {
                        result.put("스트라이크", result.get("스트라이크") + 1);
                    }
                    if (i != j && answer.get(i).equals(guess.get(j))) {
                        result.put("볼", result.get("볼") + 1);
                    }
                }
            }
            //결과 출력
            String result_msg = "";
            if (result.get("볼") != 0) {
                result_msg += result.get("볼") + "볼";
            }
            if (result.get("스트라이크") != 0) {
                result_msg += " " + result.get("스트라이크") + "스트라이크";
                if (result.get("스트라이크") == 3) {
                    result_msg += "\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
                }
            }
            if (result_msg.isEmpty()) {
                result_msg = "낫싱";
            }

            if (result.get("스트라이크") == 3) {
                isCorrect = true;
            }
            System.out.println(result_msg.trim());
        }
    }
}
