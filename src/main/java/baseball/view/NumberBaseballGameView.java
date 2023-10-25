package baseball.view;

import static baseball.model.NumberBaseballGame.DIGIT;

import baseball.model.Game;
import baseball.model.NumberBaseballGame;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class NumberBaseballGameView implements GameView {
    private final Properties messageProperties = new Properties();

    public NumberBaseballGameView(String messagePath) {
        try (FileInputStream file = new FileInputStream(messagePath)) {
            messageProperties.load(file);
        } catch (IOException e) {
            throw new RuntimeException("메시지 로드 오류", e);
        }
        showStartGameMessage();
    }

    @Override
    public void showStartGameMessage() {
        System.out.println(messageProperties.get("start-game"));
    }

    @Override
    public void showInputRequiredMessage() {
        System.out.println(messageProperties.get("number-input"));
    }

    @Override
    public void showResultOf(Game game) {
        if (game instanceof NumberBaseballGame numberBaseballGame) {
            int strikes = numberBaseballGame.getStrikes();
            int balls = numberBaseballGame.getBalls();
            StringBuilder message = new StringBuilder();

            if (strikes > 0) {
                message.append(strikes).append(messageProperties.get("strike"));
            }

            if (strikes == DIGIT) {
                message.append('\n').append(DIGIT).append(messageProperties.get("game-end"));
            } else if (balls > 0) {
                message.insert(0, balls + (String) messageProperties.get("ball"));
            } else {
                message.append(messageProperties.get("nothing"));
            }

            System.out.println(message);
        } else {
            throw new IllegalArgumentException("숫자 야구 게임이 아닙니다.");
        }
    }

    @Override
    public void showToBeContinueMessage() {
        System.out.println(messageProperties.get("to-be-continue?"));
    }

    @Override
    public void showQuitGameMessage() {
        System.out.println(messageProperties.get("quit-game"));
    }
}
