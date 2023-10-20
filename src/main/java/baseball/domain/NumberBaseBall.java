package baseball.domain;

import java.util.List;

public class NumberBaseBall {
    private final String STRIKE = "스트라이크";
    private final String BALL = "볼";
    private final String NOTHING = "낫싱";
    private final String ANSWER = "3스트라이크";

    public boolean isAnswer(String guessResult) {
        return guessResult.equals(ANSWER);
    }

    public String verifyGuess(List<Integer> answer, List<Integer> guessAnswer) {
        int strike = 0;
        int ball = 0;

        for(int i=0; i<guessAnswer.size(); i++) {
            int number = guessAnswer.get(i);
            int index = answer.indexOf(number);

            if(index == -1) continue;

            if(index == i) strike++;
            else ball++;
        }

        return convertToGuessString(ball,strike);
    }

    private String convertToGuessString(int ball, int strike) {
        if(ball == 0 && strike == 0) return NOTHING;

        String result = "";
        if(ball > 0) result = ball + BALL + " ";
        if(strike > 0) result += strike + STRIKE;

        return result.trim();
    }
}
