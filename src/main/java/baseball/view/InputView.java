package baseball.view;
import camp.nextstep.edu.missionutils.Console;
public class InputView {
    public int readPlayerNum() {
        int player = Integer.parseInt(Console.readLine());
        //예외처리 필요
        return player;
    }
}
