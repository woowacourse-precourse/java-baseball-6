package ball;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    private static final String ZERO = "0";
    private static final int INPUT_LENGTH = 3;
    private static final String NO_ZERO = "0은 입력할 수 없다.";
    private static final String INVALID_LENGTH = "길이가 적절하지 않다.";
    private static final String DUPLICATE_INPUT = "같은 숫자 입력은 허용하지 않는다.";
    private static final String NON_NUMERIC_INPUT = "숫자만 입력하시오";
    private final List<Ball> ballList;
    public Balls(String userInput) {
        validateUserInput(userInput);
        this.ballList = initBallListByStringInput(userInput);
    }
    private List<Ball> initBallListByStringInput(String userInput) {
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < userInput.length(); i++) {
            String inputSubstring = userInput.substring(i, i + 1);
            int digit = Integer.parseInt(inputSubstring);
            balls.add(new Ball(i, digit));
        }
        return balls;
    }

    private void validateUserInput(String userInput){
        if (userInput.contains(ZERO)) {
            throw new IllegalArgumentException(NO_ZERO);
        }
        if (userInput.length() != INPUT_LENGTH) {
            throw new IllegalArgumentException(INVALID_LENGTH);
        }
        if (userInput.chars().distinct().count() != INPUT_LENGTH){
            throw new IllegalArgumentException(DUPLICATE_INPUT);
        }
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(NON_NUMERIC_INPUT);
        }
    }

    public List<Ball> getBallList() {
        return new ArrayList<>(this.ballList);
    }

    public boolean containsBallValue(Ball userBall){
        return this.ballList.stream().anyMatch(ball -> ball.getDigit() == userBall.getDigit());
    }

    public Ball get(int idx){
        return this.ballList.get(idx);
    }
}