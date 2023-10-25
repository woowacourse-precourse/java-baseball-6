package baseball.model;


import java.util.ArrayList;
import java.util.List;

public class Ball {
    private final int number;
    private final int digits;

    public Ball(int number, int digits) throws Exception {
        this.number = number;
        this.digits = digits;
        if(!ball_validator(number, digits)){
            throw new Exception("정상적이지 않은 ball 생성");
        }
    }

    public static List<Ball> of(String userInput) throws Exception {
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int num = Integer.parseInt(userInput.substring(i, i+1));
            balls.add(new Ball(num, i));
        }
        return balls;
    }

    private boolean ball_validator(int number, int digits) {
        return checkNumber(number)&&checkDigits(digits);
    }

    private boolean checkDigits(int digits) {
        return digits>-1 && digits<3;
    }

    private boolean checkNumber(int number) {
        return number>0 && number<10;
    }

    public int getNumber() {
        return number;
    }
    public int getDigits() {
        return digits;
    }

}

