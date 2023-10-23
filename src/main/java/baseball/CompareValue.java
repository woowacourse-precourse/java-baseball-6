package baseball;

public class CompareValue {

    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";

    private final String message;
    private int strikeCount;
    private int ballCount;

    public CompareValue(PlayerNumber player, ComputerNumber computer) {
        compare(player, computer);
        message = makeCompareMessage();
    }


    private void compare(PlayerNumber player, ComputerNumber computer) {
        for (int i = 0; i < 3; i++) {
            int number = player.getIndexNumber(i);
            if (computer.isNumberContains(number)) {
                if (computer.getNumberIndex(number) == i) {
                    strikeCount++;
                } else {
                    ballCount++;
                }
            }
        }
    }

    private String makeCompareMessage() {
        if (ballCount == 0 && strikeCount == 0) {
            return NOTHING;
        }

        String makeMessage = "";
        if (0 < ballCount) {
            makeMessage += (ballCount + BALL + " ");
        }
        if (0 < strikeCount) {
            makeMessage += (strikeCount + STRIKE);
        }

        return makeMessage;
    }

    public boolean isGameEnd() {
        return strikeCount == 3;
    }

    public String getMessage() {
        return message;
    }
}