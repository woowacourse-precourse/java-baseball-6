package baseball.entity;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class BaseBallGame {

    private boolean gameEnd;  // 현재 게임의 진행 상태
    private CorrectNumber correctNumber;

    public BaseBallGame() {
        this.gameEnd = false;
        this.correctNumber = new CorrectNumber();
        correctNumber.generateCorrectNumbers();
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
            if (correctNumber.isCorrect(input)) {
                // 입력값 비교
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                askUserToEndGame();
            }
        }
    }

    private void completeGame() {
        this.gameEnd = true;
    }

    private void askUserToEndGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = readLine();
        checkValidEndGameInput(input);
        if (input.equals("2")) {
            this.completeGame();
        }
        correctNumber.generateCorrectNumbers();
    }

    private void checkValidEndGameInput(String input) {
        if (!input.matches("[1-2]")) { // 입력값이 1또는 2가 아니라면
            throw new IllegalArgumentException("사용자 입력 값은 1또는 2만 가능합니다!");
        }
    }

    private void checkValidInput(String input) {
        if (!input.matches("[1-9]{3}")) { // 입력값이 각각 1에서 9 사이의 숫자로 이루어진 세 자리 수가 아니라면
            throw new IllegalArgumentException("사용자 입력 값은 1에서 9만 가능합니다!");
        }
    }
}
