package baseball.controller;


import baseball.service.ComputerBehavior;
import baseball.service.UserBehavior;
import constant.Constant;
import exception.CheckException;

import java.util.ArrayList;
import java.util.List;

public class BaseBall {
    private CheckException checkException = new CheckException();
    private ComputerBehavior computerBehavior = new ComputerBehavior();
    private List<Integer> computerNumbers = new ArrayList<>();
    public void start() {
        System.out.println(Constant.START);
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
