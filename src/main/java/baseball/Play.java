package baseball;

import baseball.domain.Computer;
import baseball.domain.Result;
import baseball.domain.User;

import baseball.utils.Caculator;
import baseball.utils.Generator;
import baseball.utils.BaseBallParser;

import baseball.view.View;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Play {
    private final int FINISH = 3;

    private int size;
    private Computer computer;
    private User user;

    public Play(int size) {
        this.size = size;
        computer = new Computer();
        user = new User();
    }

    public void run() {
        Result result;
        do {
            user.setNumbers(getUserNumbers());
            result = Caculator.count(computer.getNumbers(), user.getNumbers());
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
        computer.setNumbers(Generator.makeNumbers(size, startRange, endRange));
    }
}
