package baseball;

import java.util.List;
public class BaseballGame {
    public Computer computer = new Computer();
    public CheckRestart checkRestart = new CheckRestart();
    public void startGame() {
        String restartNum = Constant.RESTART_NUM;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (restartNum.equals(Constant.RESTART_NUM)) {
            List<Integer> computerNumber = computer.generateNumbers();
            restartNum = checkRestart.strikeNum(computerNumber);
        }
    }
}