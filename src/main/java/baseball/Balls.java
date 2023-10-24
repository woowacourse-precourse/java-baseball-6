package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;

public class Balls {

    public static final int BALL_MIN = 1;
    public static final int BALL_MAX = 9;
    public static final int BALL_SIZE = 3;
    private final ArrayList<Integer> balls;

    public Balls(ArrayList<Integer> balls){
        this.balls = balls;
    }

    public int getBall(int index) {
        return balls.get(index);
    }

    public static Balls makeRandomBalls() {
        ArrayList<Integer> list = new ArrayList<>();
        while(list.size() < BALL_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(BALL_MIN, BALL_MAX);
            if (!list.contains(randomNumber)) {
                list.add(randomNumber);
            }
        }
        return new Balls(list);
    }

    public static Balls makeInputToBalls(String input){
        ArrayList<Integer> list = new ArrayList<>();
        char[] chars = input.toCharArray();
        for(char ch : chars) {
            validateBall(ch);
        }
        validateBallS(list);
        return new Balls(list);
    }

    private static void validateBall(char ch){
        int num = ch - '0';
        if(num < BALL_MIN || num > BALL_MAX) throw new IllegalArgumentException("1-9 사이 정수 값을 입력해주세요.");
    }

    private static void validateBallS(ArrayList<Integer> balls) {
        HashSet<Integer> set = new HashSet<>(balls);
        if(set.size() != BALL_SIZE) throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
    }
}
