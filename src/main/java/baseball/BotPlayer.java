package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class BotPlayer {

    private final List<Integer> botNumbers;

    public BotPlayer(List<Integer> botNumbers) {
        this.botNumbers = botNumbers;
    }

    public List<Integer> generateNumbers() {
        while (botNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!botNumbers.contains(randomNumber)) {
                botNumbers.add(randomNumber);
            }
        }
        return botNumbers;
    }
}

