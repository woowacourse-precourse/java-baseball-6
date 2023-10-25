package baseball.Controller;

import baseball.Domain.Counter;

import java.util.List;

public class InputContrast {

    public Boolean contrastList(List<Integer> computer, List<Integer> user) {

        OutputResult outputResult = new OutputResult();
        Counter counter = new Counter();

        for(int i = 0; i < 3; i++) {
            if(computer.contains(user.get(i))) {
                if(user.get(i) == computer.get(i)) {
                    counter.setStrike(counter.getStrike() + 1);
                }else {
                    counter.setBall(counter.getBall() + 1);
                }
            }
        }
        return outputResult.result(counter.getStrike(), counter.getBall());
    }
}
