package baseball.domain;

import baseball.domain.vo.JudgeResult;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballJudge {
    private final String answer;
    private final Set<Character> answerNumbers;

    public BaseballJudge(String answer) {
        this.answer = answer;
        this.answerNumbers = new HashSet<>();

        for (char c : answer.toCharArray()) {
            answerNumbers.add(c);
        }
    }

    public JudgeResult judge(String input) {
        List<JudgeType> judgeResult = getJudgeTypes(input);

        return countStrikeAndBalls(judgeResult);
    }

    private List<JudgeType> getJudgeTypes(String input) {
        List<JudgeType> result = new ArrayList<>();

        for(int i = 0; i < input.length(); ++i) {
            result.add(judgeForOne(input, i));
        }

        return result;
    }

    private JudgeType judgeForOne(String input, int index) {
        if (input.charAt(index) == answer.charAt(index)) {
            return JudgeType.STRIKE;
        }

        if (answerNumbers.contains(input.charAt(index))) {
            return JudgeType.BALL;
        }

        return JudgeType.NOTHING;
    }

    private JudgeResult countStrikeAndBalls(List<JudgeType> judgeResult) {
        int strike = 0;
        int ball = 0;

        for (JudgeType judge : judgeResult) {
            if (judge == JudgeType.STRIKE) {
                ++strike;
            }

            if (judge == JudgeType.BALL) {
                ++ball;
            }
        }

        return new JudgeResult(strike, ball);
    }


    private enum JudgeType {
        STRIKE, BALL, NOTHING,
    }
}
