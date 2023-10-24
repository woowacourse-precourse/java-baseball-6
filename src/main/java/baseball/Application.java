package baseball;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseBallGame baseBallGame = new BaseBallGame(new RandomNumberGenerator(new DefaultRandomService()));
        InputDevice inputDevice = new InputDevice(new DefaultConsoleService(), new InputValidator());
        String gameResult;

        System.out.println("숫자 야구 게임을 시작합니다.");

        do {
            List<Integer> answerNumbers = baseBallGame.createAnswerNumbers();
            BaseBallGameController controller = new BaseBallGameController(inputDevice, baseBallGame);
            gameResult = controller.competeWith(answerNumbers);
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        } while (playingGame(gameResult, inputDevice));
    }

    private static boolean playingGame(String gameResult, InputDevice inputDevice) {
        if (gameResult.equals(Score.THREE_STRIKE.getName())) {
            int restartOrExit = inputDevice.restartOrExit();
            return restartOrExit != 2;
        }
        return true;
    }
}
