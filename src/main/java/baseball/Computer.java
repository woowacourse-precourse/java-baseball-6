package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Computer {
    private List<Integer> answer;
    private Map<String, Integer> sol;

    Computer() {
        answer = new ArrayList<>();
        sol = new HashMap<>();
    }

    public void generateAnswer() {
        answer.clear();
        while (answer.size() < 3) {
            int random = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(random)) {
                answer.add(random);
            }
        }
    }

    public Map<String, Integer> resolve(List<Integer> userInput) {
        int ball = 0;
        int strike = 0;
        int answerIndex = 0;

        if (answer.containsAll(userInput)) {
            if (answer.get(0) == userInput.get(0)) {
                if (answer.get(1) == userInput.get(1)) {
                    if (answer.get(2) == userInput.get(2)) {
                        strike = 3;
                    }
                }
            }
        } else {
            for (int c : answer) {
                int userInputIndex = 0;
                for (int u : userInput) {
                    if (c == u) {
                        if (userInputIndex == answerIndex) {
                            strike++;
                        } else {
                            ball++;
                        }
                    }
                    userInputIndex++;
                }
                answerIndex++;
            }
        }

        sol.put("볼", ball);
        sol.put("스트라이크", strike);

        return sol;
    }


}
