package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

    public static final String RESULT_NOTHING = "낫싱";
    private final int RANDOM_NUMBER_START = 1;
    private final int RANDOM_NUMBER_END = 9;
    private Picks randomPicks = new Picks();
    private Result result = new Result();

    public Picks createRandomPicks() {
        randomPicks.initializePicks();
        while (!randomPicks.isFull()) {
            Pick newPick = new Pick(Randoms.pickNumberInRange(RANDOM_NUMBER_START, RANDOM_NUMBER_END));
            if (!randomPicks.contains(newPick)) {
                randomPicks.add(newPick);
            }
        }
        return randomPicks;
    }

    public void call(Picks picks) {
        result = randomPicks.compare(picks);

        if (result.isNothing()) {
            System.out.println(RESULT_NOTHING);
        }
        if (result.onlyBall()) {
            System.out.printf("%d볼\n", result.getBall());
        }
        if (result.onlyStrike()) {
            System.out.printf("%d스트라이크\n", result.getStrike());
        }
        if (result.strikeNBall()) {
            System.out.printf("%d볼 %d스트라이크\n", result.getBall(), result.getStrike());
        }
    }

    public boolean gameFinished(Picks picks) {
        result = randomPicks.compare(picks);

        return result.getStrike() == Picks.MAX_SIZE;
    }
}
