package baseball.application;

import baseball.domain.Hint;
import baseball.domain.Player;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class NumberService {

    private static final NumberService instance = new NumberService();

    public static NumberService getInstance() {
        return instance;
    }

    public List<Integer> getRandomNumber() {
        Set<Integer> numberSet = new HashSet<>();
        while (numberSet.size() < 3) {
            numberSet.add(Randoms.pickNumberInRange(1, 9));
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

    private static void compareNumber(List<Integer> computerNumber, List<Integer> playerNumber, Hint hint) {
        for (int i = 0; i < playerNumber.size(); i++) {
            Integer myNumber = playerNumber.get(i);
            if (isStrike(computerNumber, i, myNumber)) {
                hint.increaseStrike();
            } else if (isBall(computerNumber, myNumber)) {
                hint.increaseBall();
            }
        }
    }

    private static boolean isBall(List<Integer> computerNumber, Integer myNumber) {
        return computerNumber.contains(myNumber);
    }

    private static boolean isStrike(List<Integer> computerNumber, int i, Integer myNumber) {
        return Objects.equals(myNumber, computerNumber.get(i));
    }
}
