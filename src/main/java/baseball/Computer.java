package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private final List<Character> answerDigits = new ArrayList<>();

    private static final int INITIAL_COUNT = 0;
    private static final int ANSWER_START = 0;
    private static final int ANSWER_LENGTH = 3;
    private static final int MIN_DIGIT = 1;
    private static final int MAX_DIGIT = 9;

    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";
    private static final String BLANK = " ";

    public void generateAnswer(){
        while(answerDigits.size() < ANSWER_LENGTH){
            generateRandomDigit();
        }
    }

    public String generateResult(String playerInput){
        int totalCount;
        int strikeCount;
        int ballCount;
        List<Character> guessDigits = new ArrayList<>();

        for (char digit : playerInput.toCharArray()) {
            guessDigits.add(digit);
        }

        totalCount = computeStrikeAndBall(guessDigits);
        strikeCount = computeStrike(guessDigits);
        ballCount = totalCount - strikeCount;

        if (totalCount == INITIAL_COUNT){
            return NOTHING;
        }
        if (strikeCount == INITIAL_COUNT){
            return ballCount + BALL;
        }
        if (ballCount == INITIAL_COUNT){
            return strikeCount + STRIKE;
        }
        return ballCount + BALL + BLANK + strikeCount + STRIKE;
    }

    private void generateRandomDigit(){
        int randomIntNumber = Randoms.pickNumberInRange(MIN_DIGIT, MAX_DIGIT);
        char randomNumber = Integer.toString(randomIntNumber).charAt(0);
        if (!answerDigits.contains(randomNumber)) {
            answerDigits.add(randomNumber);
        }
    }

    public int computeStrikeAndBall(List<Character> guessDigits){
        int totalCount = INITIAL_COUNT;
        for (int i = ANSWER_START; i < ANSWER_LENGTH; i++){
            if (answerDigits.contains(guessDigits.get(i))){
                totalCount++;
            }
        }
        return totalCount;
    }

    public int computeStrike(List<Character> guessDigits){
        int strikeCount = INITIAL_COUNT;
        for (int i = ANSWER_START; i < ANSWER_LENGTH; i++){
            if (guessDigits.get(i).equals(answerDigits.get(i))){
                strikeCount ++;
            }
        }
        return strikeCount;
    }
}
