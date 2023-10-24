package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class gameManage implements gameManageInterface {
    final int ALLSTRIKE = 3;
    final int NOSTRIKE = 0;
    final int NOBALL = 0;
    final int PLAYAGAIN = 1;
    final int EXITGAME = 2;

    public void init() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        try {
            play();
        } catch (IllegalArgumentException e) {
            return;
        }
    }

    public List<Integer> selectComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public void selectPlayerNumber(playerEntity playerEntity) {
        System.out.println("숫자를 입력해주세요 : ");
        String playerNumber = Console.readLine();

        if (playerNumber.length() > 3) {
            throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
        }

        List<Integer> intOfPlayerNumber = stringToIntArray(playerNumber);
        playerEntity.setHumanNumber(intOfPlayerNumber);
    }

    public List<Integer> stringToIntArray(String playerNumber) {
        List<Integer> digits = new ArrayList<>();
        for (int i = 0; i < playerNumber.length(); i++) {
            digits.add(playerNumber.charAt(i) - '0');
        }
        return digits;
    }

    public resultCompareNumber judgeNumber(List<Integer> playerNumber, List<Integer> computerNumber) {
        int strikeCount = 0;
        int ballCount = 0;
        for (int i = 0; i < playerNumber.size(); i++) {
            if (Objects.equals(playerNumber.get(i), computerNumber.get(i))) {
                strikeCount++;
            } else if (computerNumber.contains(playerNumber.get(i))) {
                ballCount++;
            }
        }
        return PrintNumber(strikeCount, ballCount);
    }

    public resultCompareNumber PrintNumber(int strikeCount, int ballCount) {
        printNumberFormat printNumber = new printNumberFormat();
        if (strikeCount == ALLSTRIKE) {
            printNumber.onlyStrike(strikeCount);
            return resultCompareNumber.MATCH;
        }
        if (strikeCount == NOSTRIKE && ballCount == NOBALL) {
            printNumber.nothing();
        }
        if (ballCount == NOBALL) {
            printNumber.onlyStrike(strikeCount);
        }
        if (strikeCount == NOSTRIKE) {
            printNumber.onlyBall(ballCount);
        }
        return resultCompareNumber.NOT_MATCH;
    }

    public void play() {
        List<Integer> computerNumber = selectComputerNumber();
        playerEntity playerEntity = new playerEntity();
        while (true) {
            selectPlayerNumber(playerEntity);
            resultCompareNumber isMatched = judgeNumber(playerEntity.getHumanNumber(), computerNumber);
            if (isMatched == resultCompareNumber.MATCH) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }
}
