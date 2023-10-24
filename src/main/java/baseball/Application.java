package baseball;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator(new DefaultRandomService());
        BaseBallGame baseBallGame = new BaseBallGame(randomNumberGenerator);
        DefaultConsoleService consoleService = new DefaultConsoleService();
        InputDevice inputDevice = new InputDevice(consoleService, new InputValidator());
        String gameResult;

        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            List<Integer> answerNumbers = baseBallGame.createAnswerNumbers();

            do {
                List<Integer> tryNumbers = inputDevice.inputTryNumber();

                gameResult = baseBallGame.createGameResult(tryNumbers, answerNumbers);
                System.out.println(gameResult);
            } while (start1(gameResult));
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

        } while (start(gameResult, inputDevice, consoleService));
    }

    private static boolean start(String gameResult, InputDevice inputDevice, ConsoleService consoleService) {
        if (gameResult.equals(Score.THREE_STRIKE.getName())) {
            int restartOrExit = inputDevice.restartOrExit();
            return restartOrExit != 2;
        }
        return true;
    }

    private static boolean start1(String gameResult) {
        return !gameResult.equals(Score.THREE_STRIKE.getName());
    }
}
