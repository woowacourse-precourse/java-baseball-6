package baseball.view;

import baseball.domain.game.GameResult;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static void printEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void printResult(GameResult gameResult) {
        String ballMessage = getBallMessage(gameResult);
        String strikeMessage = getStrikeMessage(gameResult);
        String resultMessage = getResultMessage(ballMessage, strikeMessage);
        printResultMessage(resultMessage);
    }

    private static String getBallMessage(GameResult gameResult) {
        String ballMessage = "";
        if (gameResult.hasBall()) {
            ballMessage = gameResult.getBall() + "볼";
        }
        return ballMessage;
    }

    private static String getStrikeMessage(GameResult gameResult) {
        String strikeMessage = "";
        if (gameResult.hasStrike()) {
            strikeMessage = gameResult.getStrike() + "스트라이크";
        }
        return strikeMessage;
    }

    private static String getResultMessage(String ballMessage, String strikeMessage) {
        List<String> results = List.of(ballMessage, strikeMessage);
        return results.stream()
                .filter(value -> !value.isEmpty())
                .collect(Collectors.joining(" "));
    }

    private static void printResultMessage(String resultMessage) {
        if (resultMessage.isEmpty()) {
            System.out.println("낫싱");
            return;
        }
        System.out.println(resultMessage);
    }
}
