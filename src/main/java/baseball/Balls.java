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

    /* balls 에 접근에 ball을 반환하는 메소드 */
    public int getBall(int index) {
        return balls.get(index);
    }

    /* 랜덤으로 balls 를 만드는 메소드 */
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

    /* 사용자 입력 값을 Balls 로 바꿔주는 메소드 */
    public static Balls makeInputToBalls(String input){
        ArrayList<Integer> list = new ArrayList<>();
        char[] chars = input.toCharArray();
        for(char ch : chars) {
            int tmp = ch - '0';
            validateBall(tmp);
            list.add(tmp);
        }
        validateBalls(list);
        return new Balls(list);
    }

    /* ball의 유효성을 체크하는 메소드 */
    private static void validateBall(int num){
        if(num < BALL_MIN || num > BALL_MAX) throw new IllegalArgumentException("1-9 사이 정수 값을 입력해주세요.");
    }

    /* balls의 유효성을 체크하는 메소드 */
    private static void validateBalls(ArrayList<Integer> balls) {
        HashSet<Integer> set = new HashSet<>(balls);
        if(set.size() != BALL_SIZE) throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
    }
}
