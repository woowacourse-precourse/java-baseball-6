package baseball.domain.game;

import baseball.domain.input.ConsoleReader;
import baseball.domain.stadium.BaseBallStadium;

public class BaseBallGame implements Game {

    private final BaseBallStadium baseBallStadium;
    private final BaseBallGameExitManager baseBallGameExitManager;

    private BaseBallGame(final BaseBallStadium baseBallStadium, final BaseBallGameExitManager baseBallGameExitManager) {
        this.baseBallStadium = baseBallStadium;
        this.baseBallGameExitManager = baseBallGameExitManager;
    }

    public static BaseBallGame of(final BaseBallStadium baseBallStadium, final BaseBallGameExitManager baseBallGameExitManager) {
        return new BaseBallGame(baseBallStadium, baseBallGameExitManager);
    }

    @Override
    public void play() {
        printStartMessage();
        while (true) {
            baseBallStadium.startNewRound();

            if (isExitingBaseballGame()) {
                printExitMessage();
                return;
            }
        }
    }

    private void printStartMessage() {
        final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
        System.out.println(GAME_START_MESSAGE);
    }

    private void printExitMessage() {
        final String GAME_EXIT_MESSAGE = "숫자 야구 게임을 종료합니다.";
        System.out.println(GAME_EXIT_MESSAGE);
    }

    private boolean isExitingBaseballGame() {
//        return baseBallGameExitManager.isExitingBaseballGame();
        baseBallGameExitManager.printInputExitOption();
        final String userRetryInput = ConsoleReader.input();
        if (baseBallGameExitManager.isUserInputRetryOption(userRetryInput)) return false;
        if (baseBallGameExitManager.isUserInputExitOption(userRetryInput)) return true;
        throw new IllegalArgumentException();
        // TODO : EXCEPTION
    }

}
