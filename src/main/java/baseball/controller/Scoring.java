package baseball.controller;

import java.util.HashMap;
import java.util.Map;

public final class Scoring {

    private final String answer;

    public Scoring(Integer answer) {
        this.answer = answer.toString();
    }

    public Map<String, Integer> score(String validUserInput) {
        Map<String, Integer> resultMap = new HashMap<>();
        for (int i = 0; i < answer.length(); i++) {
            if (isStrike(validUserInput, i)) {
                resultMap.put("스트라이크", resultMap.getOrDefault("스트라이크", 0) + 1);
            } else if (isBall(validUserInput, i)) {
                resultMap.put("볼", resultMap.getOrDefault("볼", 0) + 1);
            }
        }
        return resultMap;
    }

    private boolean isStrike(String validUserInput, int i) {
        return answer.charAt(i) == validUserInput.charAt(i);
    }

    private boolean isBall(String validUserInput, int i) {
        return answer.contains(String.valueOf(validUserInput.charAt(i)));
    }

    public String getAnswer() {
        return answer;
    }
}
