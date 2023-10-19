package baseball;


import java.util.ArrayList;
import java.util.List;

public class BaseBall {
    private CheckException checkException = new CheckException();
    private ComputerBehavior computerBehavior = new ComputerBehavior();
    private List<Integer> computerNumbers = new ArrayList<>();
    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        computerNumbers = computerBehavior.generatedNumbers();
        UserBehavior userBehavior = new UserBehavior(computerNumbers);
        int isRe = userBehavior.input();
        restart(isRe);
    }

    public void restart(int isRe) {
        checkException.checkRestart(isRe);
        if (isRe == 1) {
            computerNumbers = computerBehavior.generatedNumbers();
            UserBehavior userBehavior = new UserBehavior(computerNumbers);
            isRe = userBehavior.input();
            restart(isRe);
        }
    }
}
