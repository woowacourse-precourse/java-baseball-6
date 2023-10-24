package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    private List<Integer> answer;
    private List<Integer> balls;

    public void init() {
        this.answer = getAnswer();
    }

    public BaseballGameResult play(String input) {
        this.balls = convert(input);
        List<BaseballType> types = getBallTypes();
        BaseballGameResult baseballGameResult = makeGameResult(types);
        return baseballGameResult;
    }

    private BaseballGameResult makeGameResult(List<BaseballType> types) {
        return new BaseballGameResult(types);
    }

    private List<Integer> convert(String input) {
        List<Integer> balls = new ArrayList<>();

        for (char c : input.toCharArray()) {
            int ball = Character.getNumericValue(c);
            balls.add(ball);
        }

        return balls;
    }

    private List<BaseballType> getBallTypes() {
        List<BaseballType> types = new ArrayList<>();

        for (int i = 0; i < balls.size(); i++) {
            int ball = balls.get(i);
            BaseballType ballType = getBallType(ball, i);
            types.add(ballType);
        }

        return types;
    }

    private BaseballType getBallType(int ball, int index) {
        boolean isExist = answer.contains(ball);

        if (!isExist) {
            return BaseballType.OUT;
        }

        boolean isStrike = answer.get(index) == ball;
        if (isStrike) {
            return BaseballType.STRIKE;
        }

        return BaseballType.BALL;
    }

    private List<Integer> getAnswer() {
        List<Integer> answer = new ArrayList<>();

        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }

        return answer;
    }
}

