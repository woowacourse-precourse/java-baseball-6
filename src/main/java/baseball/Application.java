package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Application {
    public static void main(String[] args) {
        startBaseballGame();
    }
    
    public static void startBaseballGame() {
        Queue<Integer> balls = new LinkedList<>();
        while (balls.size() < 3) {
            int ball = Randoms.pickNumberInRange(1, 9);
            if (balls.contains(ball)) {
                continue;
            }
            balls.add(ball);
        }

        balls.forEach(System.out::println);

        System.out.println("숫자 야구 게임을 시작합니다.");
    }
}
