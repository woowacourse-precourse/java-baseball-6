package baseball.view;

import baseball.model.GameResult;
import java.util.StringJoiner;

public class ConsoleOutputView implements OutputView {
    private static final String GAME_START = "숫자 야구 게임을 시작합니다.";
    private static final String REQUEST_NUMBER = "숫자를 입력해주세요 : ";
    private static final String MORE_GAME = "게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.";
    private static final String GOOD_GAME = "개의 숫자를 모두 맞히셨습니다! 게임 종료";

    @Override
    public void gameStart() {
        System.out.println(GAME_START);
    }

    @Override
    public void requestNumber() {
        System.out.print(REQUEST_NUMBER);
    }

    @Override
    public void showGameResult(GameResult gameResult) {
        String gameResultMessage = createGameResultMessage(gameResult);
        System.out.println(gameResultMessage);
    }

    private String createGameResultMessage(GameResult gameResult) {
        int correctAnswerCount = gameResult.correctAnswerCount();
        int similarAnswerCount = gameResult.similarAnswerCount();

        if (correctAnswerCount + similarAnswerCount == 0) {
            return "낫싱";
        }

        StringJoiner stringJoiner = new StringJoiner(" ");

        if (0 < similarAnswerCount) {
            stringJoiner.add(similarAnswerCount + "볼");
        }

        if (0 < correctAnswerCount) {
            stringJoiner.add(correctAnswerCount + "스트라이크");
        }

        return stringJoiner.toString();
    }

    @Override
    public void goodGame(final int targetSize) {
        System.out.println(targetSize + GOOD_GAME);
    }

    @Override
    public void areYouWantStopGame(final String moreValue, final String stopValue) {
        System.out.printf(MORE_GAME, moreValue, stopValue);
    }
}
