package baseball.view;

import java.util.List;

public interface View {

    void start();
    List<Integer> input();
    void result(int strike, int ball);
    void end();
    boolean restartQuestion();
}
