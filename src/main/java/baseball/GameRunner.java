package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameRunner {
    private final GameScore gameScore;
    private final Person person;
    private final Computer computer;

    public GameRunner(Person person, Computer computer, GameScore gameScore) {
        this.person = person;
        this.computer = computer;
        this.gameScore = gameScore;
    }

    public void playGame() {
        GameMessages.printStartMessage();
        while (true) {
            if (playRound()) {
                return;
            }
        }
    }

    public boolean playRound() {
        BallStrikeCount ballStrikeCount = executeRound();
        determineMessage(ballStrikeCount);
        return checkContinueGame(ballStrikeCount);
    }

    private BallStrikeCount executeRound() {
        GameMessages.printInputMessage();
        String input = Console.readLine();
        person.insert(input);
        return gameScore.calculateScore();
    }

    private void determineMessage(BallStrikeCount ballStrikeCount) {
        int ball = ballStrikeCount.getBallCount();
        int strike = ballStrikeCount.getStrikeCount();
        GameMessages.printStatusMessage(ball, strike);
    }

    private boolean checkContinueGame(BallStrikeCount ballStrikeCount) {
        if (isThreeStrike(ballStrikeCount)) {
            return handleUserChoice(ballStrikeCount);
        }

        restartRound(ballStrikeCount);
        return false;
    }

    private void restartRound(BallStrikeCount ballStrikeCount) {
        // 라운드를 다시 시작하기 위한 초기화 작업
        ballStrikeCount.clean();
        person.clean();
    }

    private boolean handleUserChoice(BallStrikeCount ballStrikeCount) {
        int choice = Integer.parseInt(Console.readLine());
        if (choice == GameConstants.RESTART_GAME) {
            restartGame(ballStrikeCount);
            return false;
        }
        return choice == GameConstants.END_GAME;
    }

    private void restartGame(BallStrikeCount ballStrikeCount) {
        // 게임을 다시 시작하기 위한 초기화 작업
        ballStrikeCount.clean();
        person.clean();
        computer.clearAndInitialize();
    }

    private boolean isThreeStrike(BallStrikeCount ballStrikeCount) {
        return ballStrikeCount.getStrikeCount() == GameConstants.THREE_STRIKE;
    }
}
