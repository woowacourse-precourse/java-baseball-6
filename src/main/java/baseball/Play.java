package baseball;

import baseball.domain.BaseBall;
import baseball.domain.Result;
import baseball.utils.BaseBallParser;
import baseball.utils.Caculator;
import baseball.utils.Generator;
import baseball.view.View;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Play {
    private final int FINISH = 3;

    private int size;
    private BaseBall computer;
    private BaseBall user;

    public Play(int size) {
        this.size = size;
    }

    public void run() {
        Result result;
        do {
            user = new BaseBall(getUserNumbers());
            result = Caculator.count(computer.numbers(), user.numbers());
            View.result(result.getStrike(), result.getBall());
        } while (!isFinish(result));
    }

    private List<Integer> getUserNumbers() {
        View.input();
        String input = Console.readLine();
        return BaseBallParser.parse(input, size);
    }

    private boolean isFinish(Result result) {
        return result.getStrike() == FINISH;
    }

    public void setPlay(int size, int startRange, int endRange) {
        computer = new BaseBall(Generator.makeNumbers(size, startRange, endRange));
    }
}
