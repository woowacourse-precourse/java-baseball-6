package baseball.domain;

import camp.nextstep.edu.missionutils.Console;

public class GameStatus {
    private int gameState;

    public void inputStatusCode() {
        String inputStatusCode = Console.readLine();
        checkIsValidStatusCode(inputStatusCode);
        this.gameState = Integer.parseInt(inputStatusCode);
    }

    public int getGameState() {
        return gameState;
    }

    private void checkIsValidStatusCode(String statusCode) {
        if (statusCode == null || statusCode.isEmpty()) {
            throw new IllegalArgumentException("입력 값은 공백일 수 없습니다.");
        }

        if (statusCode.length() > 1) {
            throw new IllegalArgumentException("입력 값은 반드시 한 자리만 입력해야 합니다.");
        }

        char charValue = statusCode.charAt(0);
        if (charValue != '1' && charValue != '2') {
            throw new IllegalArgumentException("입력 값은 반드시 1 혹은 2여야 합니다.");
        }
    }
}
