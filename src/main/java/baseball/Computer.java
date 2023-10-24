package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

    public static final String RESULT_NOTHING = "낫싱";
    private Picks randomPicks = new Picks();
    private Result result = new Result();

    public Picks createRandomPicks() {
        while (!randomPicks.isFull()) {
            Pick newPick = new Pick(Randoms.pickNumberInRange(1, 9));
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
            return;
        }
        if (result.onlyStrike()) {
            System.out.printf("%d스트라이크\n", result.getStrike());
            return;
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
