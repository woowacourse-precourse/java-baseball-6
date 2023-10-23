package baseball.domain;

import baseball.view.View;

import java.util.List;

public class BaseballGame {

    private final BaseballNumbers baseballNumbers;

    public BaseballGame(BaseballNumbers baseballNumbers) {
        this.baseballNumbers = baseballNumbers;
    }

    public void start() {
        BaseballNumbers baseballNumbers = BaseballNumbers.generateBaseballNumbers();
        while (true) {
            PlayerNumbers playerNumbers = View.inputPlayerNumbers();
            int[] hits = this.checkHitsResult(baseballNumbers.getNumbers(), playerNumbers.getNumbers());
            this.printResult(hits);
        }
    }

    private int[] checkHitsResult(List<Integer> baseballNumbers, List<Integer> playerNumbers) {
        int[] hits = new int[2];

        for (int i = 0; i < baseballNumbers.size(); i++) {
            if (baseballNumbers.get(i).equals(playerNumbers.get(i))) {
                hits[1] += 1;
            } else if (playerNumbers.contains(baseballNumbers.get(i))) {
                hits[0] += 1;
            }
        }
        return hits;
    }

    private void printResult(int[] hits) {
        StringBuilder message = new StringBuilder();

        if (hits[0] > 0) {
            message.append(hits[0]).append("볼 ");
        }
        if (hits[1] > 0) {
            message.append(hits[1]).append("스트라이크");
        }

        if (message.isEmpty()) {
            message.append("낫싱");
        }

        System.out.println(message);
    }
}
