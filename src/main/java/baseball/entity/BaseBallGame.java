package baseball.entity;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class BaseBallGame {

    private boolean gameEnd;  // 현재 게임의 진행 상태

    public BaseBallGame() {
        this.gameEnd = false;
    }

    public boolean isGameEnd() {
        return gameEnd;
    }

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다");
        while (!isGameEnd()) {
            System.out.println("숫자를 입력해주세요 :");
            String input = readLine();
            checkValidInput(input);  // 입력값 확인
        }
    }

    private void checkValidInput(String input) {
        if (!input.matches("[1-9]{3}")) { // 입력값이 각각 1에서 9 사이의 숫자로 이루어진 세 자리 수가 아니라면
            throw new IllegalArgumentException("사용자 입력 값은 1에서 9만 가능합니다!");
        }
    }
}
