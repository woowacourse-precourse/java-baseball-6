package baseball.model;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static baseball.utils.Constants.*;

public class Player {
    private String answer;
    private int[] answerSequence;

    public Player() {
        this.reset();
    }

    public void reset() {
        this.answerSequence = new int[BALL_MAX];
    }

    public void setAnswer(String answer) {
        this.checkAnswerValid(answer);

        this.answer = answer;
        this.setAnswerSequence();
    }


    private void setAnswerSequence() {
        // [3,9,1]
        this.answerSequence = this.answer.chars()
                .map(Character::getNumericValue)
                .toArray();
    }

    private void checkAnswerValid(String answer) {
        // 글자수, 문자 포함 여부 체크
        Pattern pattern = Pattern.compile(NUMBER_REGEX);
        Matcher matcher = pattern.matcher(answer);
        boolean matches = matcher.matches();
        if(!matches) {
            throw new IllegalArgumentException();
        }

        // 같은 수 입력 여부 체크
        boolean[] exist = new boolean[RANGE_END];
        Arrays.fill(exist, false);
        int[] answerSequence = answer.chars()
                        .map(Character::getNumericValue)
                        .toArray();

        for(int i=0; i<BALL_MAX; i++) {
            int v = answerSequence[i];
            if(exist[v]) {
                throw new IllegalArgumentException();
            }

            exist[v] = true;
        }
    }

    public int[] getAnswerSequence() {
        return answerSequence;
    }
}
