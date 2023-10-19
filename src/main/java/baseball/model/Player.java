package baseball.model;

import camp.nextstep.edu.missionutils.Console;

public class Player {

    public String throwBall() {
        String ball = Console.readLine();
        isInvalid(ball);

        return ball;
    }

    private void isInvalid(String ball) {
        if (ball.length() != 3 || !isNumberic(ball))
            throw new IllegalArgumentException("Invalid Input");
    }

    private boolean isNumberic(String ball) {
        for (char ch : ball.toCharArray()) {
            if (!Character.isDigit(ch) || ch == '0')
                throw new IllegalArgumentException("Invalid Input");
        }
        return true;
    }


}