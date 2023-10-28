package baseball.application;

import baseball.domain.Hint;
import baseball.domain.Player;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static baseball.util.validateCondition.LengthCondition.LENGTH;
import static baseball.util.validateCondition.RangeCondition.END;
import static baseball.util.validateCondition.RangeCondition.START;

public class NumberService {

    private static final NumberService instance = new NumberService();

    private NumberService() {

    }

    public static NumberService getInstance() {
        return instance;
    }

    public List<Integer> getRandomNumber() {
        Set<Integer> numberSet = new HashSet<>();
        while (numberSet.size() < LENGTH.getLength()) {
            numberSet.add(Randoms.pickNumberInRange(START.getNumber(), END.getNumber()));
        }

        return new ArrayList<>(numberSet);
    }

    public Hint generateHint(Player computer, Player player) {
        List<Integer> computerNumber = computer.getNumberList();
        List<Integer> playerNumber = player.getNumberList();
        Hint hint = new Hint();

        compareNumber(computerNumber, playerNumber, hint);

        return hint;
    }

    private void compareNumber(List<Integer> computerNumber, List<Integer> playerNumber, Hint hint) {
        for (int i = 0; i < playerNumber.size(); i++) {
            Integer myNumber = playerNumber.get(i);
            if (isStrike(computerNumber, i, myNumber)) {
                hint.increaseStrike();
            } else if (isBall(computerNumber, myNumber)) {
                hint.increaseBall();
            }
        }
    }

    private boolean isBall(List<Integer> computerNumber, Integer myNumber) {
        return computerNumber.contains(myNumber);
    }

    private boolean isStrike(List<Integer> computerNumber, int i, Integer myNumber) {
        return Objects.equals(myNumber, computerNumber.get(i));
    }
}
