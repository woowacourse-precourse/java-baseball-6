package baseball;

import static baseball.Validator.checkNumber;
import static baseball.Validator.validatePick;

import java.util.ArrayList;
import java.util.List;

public class Picks {

    public static final int MAX_SIZE = 3;

    private List<Pick> picks = new ArrayList<>();

    public boolean isFull() {
        return picks.size() == MAX_SIZE;
    }

    public boolean contains(Pick newPick) {
        return picks.contains(newPick);
    }

    public void add(Pick newPick) {
        picks.add(newPick);
    }

    public Pick get(int index) {
        return picks.get(index);
    }

    public void initializePicks() {
        picks = new ArrayList<>();
    }

    public void createPicks(String input) {
        initializePicks();

        for (int i = 0; i < input.length(); i++) {
            int number = checkNumber(input.charAt((i)));
            Pick newPick = new Pick(number);
            validatePick(picks, newPick);
            picks.add(newPick);
        }
    }

    public Result compare(Picks playerPicks) {
        Result result = new Result();
        for (int i = 0; i < picks.size(); i++) {
            if (picks.get(i).equals(playerPicks.get(i))) {
                result.addStrike();
                continue;
            }
            if (picks.contains(playerPicks.get(i))) {
                result.addBall();
            }
        }
        return result;
    }
}
