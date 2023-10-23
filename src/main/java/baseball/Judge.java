package baseball;

import java.util.List;


public class Judge {
    public Judge() {
    }

    public boolean judgmentFinish(Player player, Computer computer) {
        boolean isFinished = false;
        List<Integer> playerNumberList = player.getNumberList();
        List<Integer> computerNumberList = computer.getNumberList();

        int ballCount = getBallCount(playerNumberList, computerNumberList);
        int strikeCount = getStrikeCount(playerNumberList, computerNumberList);

        printResult(ballCount, strikeCount);

        if (strikeCount == 3) {
            isFinished = true;
        }

        return isFinished;
    }

    private int getBallCount(List<Integer> playerNumberList, List<Integer> computerNumberList) {
        int ballCount = 0;
        for (int i = 0; i < 3; i++) {
            Integer playerNumber = playerNumberList.get(i);
            if (computerNumberList.contains(playerNumber)) {
                int playerIndex = playerNumberList.indexOf(playerNumber);
                int computerIndex = computerNumberList.indexOf(playerNumber);

                if (playerIndex != computerIndex) {
                    ballCount++;
                }
            }
        }
        return ballCount;
    }

    private int getStrikeCount(List<Integer> playerNumbers, List<Integer> computerNumbers) {
        int strikeCount = 0;
        for (int i = 0; i < 3; i++) {
            int playerNumber = playerNumbers.get(i);
            int computerNumber = computerNumbers.get(i);

            if (playerNumber == computerNumber) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private static void printResult(int ballCount, int strikeCount) {
        if (ballCount != 0) {
            System.out.print(ballCount + "볼");
        }

        if (ballCount != 0 && strikeCount != 0) {
            System.out.print(" ");
        }

        if (strikeCount != 0) {
            System.out.print(strikeCount + "스트라이크");

        }
        if (ballCount == 0 && strikeCount == 0) {
            System.out.print("낫싱");
        }

        if (strikeCount == 3) {
            System.out.println();
            System.out.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

        }

        System.out.println();
    }
}
