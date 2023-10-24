package game;

import domain.Ball;
import domain.BallComparator;
import domain.Balls;
import domain.GameResult;
import domain.NumbersGenerator;
import io.ConsoleView;
import io.View;
import java.util.List;
import util.convertor.IntegerListToBallListConvertor;
import util.convertor.StringToIntegerListConvertor;

public class BaseballGame implements Game {


    private static GameStatus gameStatus = GameStatus.START;
    private static NumbersGenerator numbersGenerator = new NumbersGenerator();
    private static BallComparator ballComparator = new BallComparator();

    private static Balls computerBalls;
    private static View console = new ConsoleView();

    @Override
    public void executeGame() {
        console.printStartGame();
        computerBalls = createNewComputerBalls();
        do {
            console.printEnterNumberMsg();
            String number = console.inputNumbers();
            List<Integer> numbers = StringToIntegerListConvertor.convert(number);
            List<Ball> userBallList = IntegerListToBallListConvertor.convert(numbers);
            Balls userBalls = new Balls(userBallList);
            GameResult gameResult = ballComparator.compareStatus(userBalls, computerBalls);
            console.printResult(gameResult);
            checkResultAndRetry(gameResult);

        } while (gameStatus.isOngoing());
    }

    private void checkResultAndRetry(GameResult gameResult) {
        if (isFinish(gameResult)) {
            console.printEndMessage();
            console.printEndOrRetryMessage();
            int menu = Integer.parseInt(console.inputRetryMenu());
            if (menu == 2) {
                gameStatus = GameStatus.END;
                return;
            }
            computerBalls = createNewComputerBalls();
        }
    }

    private Balls createNewComputerBalls() {
        List<Ball> computerBallList = IntegerListToBallListConvertor
                .convert(numbersGenerator.generateNumbers());
        return new Balls(computerBallList);

    }

    private boolean isFinish(GameResult gameResult) {
        if (gameResult.strike() == 3) {
            return true;
        }
        return false;
    }

    @Override
    public void restartGame() {

    }
}
