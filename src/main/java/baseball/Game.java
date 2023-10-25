package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Game {

    private final Store store;

    public Game(Store store) {
        this.store = store;
    }

    public void generateAnswer() {
        while (store.computer.size() < GameInfo.NUMBER_OF_DIGITS) {
            int randomNumber = Randoms.pickNumberInRange(GameInfo.MIN_NUMBER, GameInfo.MAX_NUMBER);
            if (store.exist.getOrDefault(randomNumber,false)) continue;
            store.exist.put(randomNumber, true);
            store.computer.add(randomNumber);
        }
    }

    public void compareAnswer() {
        for (int i = 0; i < GameInfo.NUMBER_OF_DIGITS; i++) {
            int num = store.computer.get(i);
            int inputNum = Integer.parseInt(String.valueOf(store.input.charAt(i)));

            if (!store.exist.getOrDefault(inputNum, false)) continue;

            String key = num == inputNum ? GameInfo.CORRECT : GameInfo.WRONG;
            store.result.put(key, store.result.getOrDefault(key, 0) + 1);
        }
    }

    public boolean checkCorrect() {
        return store.result.getOrDefault(GameInfo.CORRECT, 0) == GameInfo.NUMBER_OF_DIGITS;
    }

    public boolean checkGameEnd(String input) {
        return input.equals(GameInfo.GAME_END_INPUT);
    }
}
