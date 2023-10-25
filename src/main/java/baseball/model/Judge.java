package baseball.model;

import java.util.List;

import static baseball.constant.Const.RESTART_GAME;

public class Judge {
    public void createHint(User user, Computer computer) {
        List<Integer> numbers = user.inputNumbers();
        List<Integer> computerNumbers = computer.getRandomNumbers();
        Hint.init();

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == computerNumbers.get(i)) {
                Hint.addCount(Hint.STRIKE);
            } else if (computerNumbers.contains(numbers.get(i))) {
                Hint.addCount(Hint.BALL);
            }
        }
    }
    public boolean isReset(User user) {
        return user.inputReset().equals(RESTART_GAME);
    }
}

