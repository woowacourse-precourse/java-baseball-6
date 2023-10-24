package baseball.service;

import static baseball.util.MessageFormatter.*;

import baseball.domain.Computer;
import baseball.domain.User;
import baseball.dto.response.StrikeBallResponse;
import baseball.util.GameResultPrinter;
import baseball.util.WrappedString;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.IntStream;

public class BaseballService {
    private final GameResultPrinter gameResultPrinter = new GameResultPrinter();

    public void startGame(Computer computer) {
        boolean running = true;
        while (running) {
            System.out.print(USER_START);
            WrappedString consoleData = new WrappedString(Console.readLine());
            String inputData = consoleData.getValue();
            if (inputData.equalsIgnoreCase(QUIT) || handleUserInput(computer, inputData)) {
                gameResultPrinter.handleGameExit();
                running = false;
            }
        }
    }

    private boolean handleUserInput(Computer computer, String inputData) {
        User user = new User(inputData);
        StrikeBallResponse result = playBall(computer, user);
        if (result.getStrikeCount() == MAX_STRIKES) {
            gameResultPrinter.printThreeStrike(MAX_STRIKES);
            return true;
        }
        System.out.println(gameResultPrinter.printOtherResult(result));
        return false;
    }

    private StrikeBallResponse playBall(Computer computer, User user) {
        List<Integer> comData = computer.getRandomNumber();
        String userDataValue = user.getUserData();

        long strikeCount = IntStream.range(0, comData.size())
                .filter(i -> comData.get(i) == Character.getNumericValue(userDataValue.charAt(i)))
                .count();

        long ballCount = IntStream.range(0, comData.size())
                .filter(i -> comData.get(i) != Character.getNumericValue(userDataValue.charAt(i))
                        && comData.contains(Character.getNumericValue(userDataValue.charAt(i))))
                .count();
        return new StrikeBallResponse((int) strikeCount, (int) ballCount);
    }
}
