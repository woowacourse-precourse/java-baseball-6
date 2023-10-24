package baseball.Game;

import baseball.Check.Ball;
import baseball.Check.Score;
import baseball.Check.Strike;
import baseball.CreateNum.Computer;
import baseball.CreateNum.User;

import java.util.List;

public class Play {
    public static void play() {

        int str = 0;

        List<Integer> com = Computer.comNumberList();

        while (!(str == 3)) {

            List<Integer> user = User.userNumberList();

            str = Strike.count(user, com);
            int ball = Ball.count(user, com);

            Score.result(str, ball);
        }
    }
}
