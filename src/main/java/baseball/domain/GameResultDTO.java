package baseball.domain;

import java.util.List;

public class GameResultDTO {
    private int ballCount;
    private int strikeCount;


    public GameResultDTO(GameNumber computerNumber, GameNumber playerNumber) {
        List<Integer> computerNum = playerNumber.getNumber();
        List<Integer> playerNums = computerNumber.getNumber();
        int idx = 0;
        for (int num : playerNums) {
            if (isInComputerNumber(computerNum, num)) {
                isSameIndex(computerNum.indexOf(num), idx);
            }
            idx++;
        }
    }

    private boolean isInComputerNumber(List<Integer> computerNumber, int num) {
        return computerNumber.contains(num);
    }

    private void isSameIndex(int computerNumberIdx, int playerNumberIdx) {
        if (computerNumberIdx == playerNumberIdx) {
            strikeCount++;
        } else {
            ballCount++;
        }
    }

    public StringBuilder getResult(StringBuilder messageBuilder) {
        if (strikeCount == 0 && ballCount == 0) {
            messageBuilder.append("낫싱");
        }

        if (ballCount != 0) {
            messageBuilder.append(ballCount).append("볼 ");
        }

        if (strikeCount != 0) {
            messageBuilder.append(strikeCount).append("스트라이크");
        }

        return messageBuilder;
    }

    public boolean getIsGameFinished() {
        return strikeCount == 3;
    }

}
