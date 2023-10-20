package baseball.domain;

public final class Round {
    private final ComputerNumbers computerNumbers;
    private final UserNumbers userNumbers;


    public Round(ComputerNumbers computerNumbers, UserNumbers userNumbers) {
        this.computerNumbers = computerNumbers;
        this.userNumbers = userNumbers;
    }

    private int getComputerNumber(int i) {
        return computerNumbers.get(i);
    }

    private int getUserNumber(int i) {
        return userNumbers.get(i);
    }

    private boolean IsStrike(int i) {
        return getUserNumber(i) == getComputerNumber(i);
    }

    public RoundResult calculateRoundResult() {
        int ballCount = 0;
        int strikeCount = 0;
        for (int i = 0; i < 3; i++) {
            if (IsStrike(i)) {
                strikeCount++;
                continue;
            }
            if (computerNumbers.contains(getUserNumber(i))) {
                ballCount++;
            }
        }
        return new RoundResult(ballCount, strikeCount);
    }
}

