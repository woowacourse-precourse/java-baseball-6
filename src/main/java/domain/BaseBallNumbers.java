package domain;

import exception.InvalidBaseBallLengthException;

import java.util.ArrayList;
import java.util.List;

public class BaseBallNumbers {
    private static final int BASEBALL_LENGTH = 3;
    private static List<BaseBall> playerBaseBallNumbers;

    public BaseBallNumbers(String playerBaseballNumbers) {
        validateNumberLength(playerBaseballNumbers);
        this.playerBaseBallNumbers = convertBaseBallNumbers(playerBaseballNumbers);
    }

    // convertBaseBallNumbers: 사용자의 공 입력값을 BaseBallNumber 객체로 변환
    private List<BaseBall> convertBaseBallNumbers(String playerBaseballNumbers) {
        List<BaseBall> playerBaseBallList = new ArrayList<>();
        for (int i = 0; i < BASEBALL_LENGTH; i++) {
            playerBaseBallList.add(new BaseBall(playerBaseballNumbers.charAt(i)));
        }
        return playerBaseBallList;
    }

    // validateNumberLength: 사용자가 입력한 공이 세 개인지 확인
    private void validateNumberLength(String playerBaseballNumbers) {
        if (playerBaseballNumbers.length() != BASEBALL_LENGTH) {
            throw new InvalidBaseBallLengthException();
        }
    }
}
