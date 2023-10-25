package baseball.service;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;


class BaseballServiceTest {

    @Test
    void countStrike() {
        List<Integer> computer = new ArrayList<>();
        List<Integer> user = new ArrayList<>();
        BaseballService service = new BaseballService();

        for (int i = 1; i < 4; i++) {
            computer.add(i);
        }

        user.add(1);
        user.add(4);
        user.add(5);

        int strike = service.countStrike(computer, user);
        System.out.println("strike = " + strike);
    }

    @Test
    void countBall() {
        List<Integer> computer = new ArrayList<>();
        List<Integer> user = new ArrayList<>();
        BaseballService service = new BaseballService();

        for (int i = 1; i < 4; i++) {
            computer.add(i);
        }
        for (int i = 3; i < 6; i++) {
            user.add(i);
        }
        int ball = service.countBall(computer, user);
        System.out.println("ball = " + ball);
    }

    @Test
    void printBaseball() {
        BaseballService service = new BaseballService();
        service.printBaseball(0, 0);
        service.printBaseball(0, 1);
        service.printBaseball(1, 0);
        service.printBaseball(1, 1);
    }
}