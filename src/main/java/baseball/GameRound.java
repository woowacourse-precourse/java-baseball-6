package baseball;

import camp.nextstep.edu.missionutils.Console;

/**
 * 게임 라운드를 진행하는 클래스입니다.
 * 사용자 입력과 컴퓨터의 랜덤 숫자를 통해 볼, 스트라이크를 계산하고 결과를 출력합니다.
 */
public class GameRound {
    private final GameScore gameScore;
    private final Person person;
    private final Computer computer;

    /**
     * GameRound 객체를 초기화하고 GameScore객체를 생성합니다.
     *
     * @param person 플레이어 객체
     * @param computer 컴퓨터 객체
     */
    public GameRound(Person person, Computer computer) {
        this.person = person;
        this.computer = computer;
        gameScore = new GameScore(person, computer);
    }

    /**
     * 한 라운드의 게임을 진행합니다.
     *
     * @return 게임이 계속되어야 하면 true, 그렇지 않으면 false
     */
    public boolean playRound() {
        // 사용자 입력 받기
        String input = getInput();
        person.insertNumberAndValidate(input);

        // 볼, 스트라이크 계산
        BallStrikeCount ballStrikeCount = gameScore.calculateScore();

        // 결과 메시지 출력
        printMessage(ballStrikeCount);

        // 게임 계속 여부 확인
        return checkContinueGame(ballStrikeCount);
    }

    private String getInput() {
        GamePrinter.inputMessage();
        return Console.readLine();
    }

    private void printMessage(BallStrikeCount ballStrikeCount) {
        int ball = ballStrikeCount.getBallCount();
        int strike = ballStrikeCount.getStrikeCount();
        GamePrinter.resultMessage(ball, strike);
    }

    private boolean checkContinueGame(BallStrikeCount ballStrikeCount) {
        // 3 스트라이크가 나왔는지 검사
        if (isThreeStrike(ballStrikeCount)) {
            // 사용자가 게임을 계속할지 결정
            return handleUserChoice();
        }

        // 현재 라운드를 다시 시작
        restartRound();
        return true;
    }

    // 사용자 선택에 따라 게임을 계속할지 정합니다.
    private boolean handleUserChoice() {
        String input = Console.readLine();
        InputValidator.validateChoiceInput(input);

        int choice = Integer.parseInt(input);

        // 게임을 재시작할 경우
        if (choice == GameConstants.RESTART_GAME) {
            restartGame();
            return true;
        }

        // 게임을 종료할 경우
        return false;
    }

    // 3 스트라이크인지 확인합니다.
    private boolean isThreeStrike(BallStrikeCount ballStrikeCount) {
        return ballStrikeCount.getStrikeCount() == GameConstants.THREE_STRIKE;
    }

    // 라운드를 다시 시작하기 위해 리스트를 초기화합니다.
    public void restartRound() {
        person.cleanList();
    }

    // 게임을 다시 시작하기 위해 상태를 초기화합니다.
    public void restartGame() {
        person.cleanList();
        computer.clearAndInitialize();
    }
}
