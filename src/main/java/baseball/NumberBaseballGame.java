package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NumberBaseballGame {
    public static final String GAME_START_MSG = "숫자 야구 게임을 시작합니다.";
    public static final String GAME_OVER_MSG = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String INPUT_MSG = "숫자를 입력해주세요 :";


    void StartGame() {
        System.out.printf(GAME_START_MSG);
        boolean isGaming = true;
        while (isGaming) {

            PlayBall();

            System.out.printf(GAME_OVER_MSG);
            String userChoice = camp.nextstep.edu.missionutils.Console.readLine();

            if (userChoice.equals("2")) {
                isGaming = false;
            } else if (!userChoice.equals("1")) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
        }
    }

    void PlayBall() {
        boolean isCorrect = false;
        List<Integer> answer = new ArrayList<>();

        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }

        while (!isCorrect) {
            List<Integer> guess = new ArrayList<>();
            System.out.println(INPUT_MSG);
            String input = camp.nextstep.edu.missionutils.Console.readLine();
            //입력값 컨버젼
            if (input.length() != 3) {
                throw new IllegalArgumentException("입력값이 3이 아닙니다");
            }
            for (int i = 0; i < 3; i++) {
                int number = Character.getNumericValue(input.charAt(i));
                if (!guess.contains(number)) {
                    guess.add(number);
                } else {
                    throw new IllegalArgumentException("숫자가 아닙니다");
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
