package baseball.domain;

import java.util.*;

public class Referee {

    private final List<Integer> computerNumber;
    private final String STRIKE = "스트라이크";
    private final String BALL = "볼";
    private final String NOTHING = "낫싱";
    private Map<String, Integer> resultMap;

    public Referee(List<Integer> computer) {
        this.computerNumber = computer;
    }

    public String getResult(List<Integer> userNumber) {
        initMap();
        countScore(userNumber);
        return convertResult();
    }

    private void initMap() {
        this.resultMap = new HashMap<>(){{
            put(STRIKE, 0);
            put(BALL, 0);
        }};
    }

    private void countScore(List<Integer> userNumber) {
        for (int i=0; i<userNumber.size(); ++i) {
            int user = userNumber.get(i);
            int computer = computerNumber.get(i);

            if (isBall(user, computer)) {
                resultMap.put(BALL, resultMap.get(BALL) + 1);
            }
            if (isStrike(user, computer)) {
                resultMap.put(STRIKE, resultMap.get(STRIKE) + 1);
            }
        }
    }

    private boolean isBall(int user, int computer) {
        return computerNumber.contains(user) && !Objects.equals(user, computer);
    }

    private boolean isStrike(int user, int computer) {
        return Objects.equals(user, computer);
    }

    private String convertResult() {
        List<String> result = new ArrayList<>();

        if(resultMap.get(BALL) > 0) {
            result.add(resultMap.get(BALL) + BALL);
        }
        if(resultMap.get(STRIKE) > 0) {
            result.add(resultMap.get(STRIKE) + STRIKE);

        }
        if(result.isEmpty()) {
            result.add(NOTHING);
        }

        return String.join(" ", result);
    }
}
