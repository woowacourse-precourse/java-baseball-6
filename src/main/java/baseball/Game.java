package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Game {

    private final Store store;
    private final int NUMBER_OF_DIGITS;

    public Game(Store store, int numberOfDigits) {
        this.store = store;
        NUMBER_OF_DIGITS = numberOfDigits;
    }

    public void generateAnswer() {
        while (store.computer.size() < NUMBER_OF_DIGITS) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (store.exist.getOrDefault(randomNumber,false)) continue;
            store.exist.put(randomNumber, true);
            store.computer.add(randomNumber);
        }
    }

    public void compareAnswer() {
        for (int i = 0; i < NUMBER_OF_DIGITS; i++) {
            int num = store.computer.get(i);
            int inputNum = Integer.parseInt(String.valueOf(store.input.charAt(i)));
            if (!store.exist.getOrDefault(inputNum, false)) continue;
            String key = num == inputNum ? "스트라이크" : "볼";
            store.result.put(key, store.result.getOrDefault(key, 0) + 1);
        }
    }
}
