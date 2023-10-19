package baseball;


import java.util.ArrayList;
import java.util.List;

public class BaseBall {
    ComputerBehavior computerBehavior = new ComputerBehavior();
    List<Integer> computerNumbers = new ArrayList<>();
    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        computerNumbers = computerBehavior.generatedNumbers();
        UserBehavior userBehavior = new UserBehavior(computerNumbers);
        int isRe = userBehavior.input();
    }
}
