package ball;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    private final List<Ball> ballList;
    public Balls(String userInput) {
        validateUserInput(userInput);
        this.ballList = initBallListByStringInput(userInput);
    }
    private List<Ball> initBallListByStringInput(String userInput) {
        // TODO: 2023/10/23 변수명 "balls" 맘에 안든다. 바꾸자
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < userInput.length(); i++) {
            String inputSubstring = userInput.substring(i, i + 1);
            int digit = Integer.parseInt(inputSubstring);
            balls.add(new Ball(i, digit));
        }
        return balls;
    }

    private void validateUserInput(String userInput){
        // TODO: 2023/10/23 이 validation 로직이 맘에 안든다.
        // 1. 매서드를 나누거나
        // 2. 차라리 마지막에 예외를 한번만 던지자 (예외 메시지를 트레이드 오프 해서라도?)
        // 3. 아니면 차라리 BallsValidator 클래스를 만들어서 객체의 역할을 아주 작게 가져가는 것도 고려하자.
        // 3번 기각, 차라리 체크(판별로직)를 다른 곳에서 수행하기로 결정.
        if (userInput.contains("0")) {
            throw new IllegalArgumentException("0은 입력할 수 없다.");
        }
        if (userInput.length() != 3) {
            throw new IllegalArgumentException("길이가 적절하지 않다.");
        }
        if (userInput.chars().distinct().count() != 3){
            throw new IllegalArgumentException("같은 숫자 입력은 허용하지 않는다.");
        }
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("숫자만 입력하시오");
        }
    }

    public List<Ball> getBallList() {
        return new ArrayList<>(this.ballList);
    }
}