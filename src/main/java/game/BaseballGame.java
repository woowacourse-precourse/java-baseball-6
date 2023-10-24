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
    private static final NumbersGenerator numbersGenerator = new NumbersGenerator();
    private static final BallComparator ballComparator = new BallComparator();

    private static Balls computerBalls;
    private static final View console = new ConsoleView();

    private static final int MAX_STRIKE = 3;

    private static final int STOP_NUMBER = 2;

    @Override
    public void executeGame() {
        console.printStartGame();
        computerBalls = createNewComputerBalls();
        do {
            console.printEnterNumberMsg();
            String number = console.inputNumbers();
            List<Ball> userBallList = convertStringToBallList(number);
            Balls userBalls = new Balls(userBallList);
            GameResult gameResult = ballComparator.compareStatus(userBalls, computerBalls);
            console.printResult(gameResult);
            checkResultAndRetry(gameResult);

        } while (gameStatus.isOngoing());
    }

    private List<Ball> convertStringToBallList(String number) {
        List<Integer> numbers = StringToIntegerListConvertor.convert(number);
        return IntegerListToBallListConvertor.convert(numbers);

    }

    private void checkResultAndRetry(GameResult gameResult) {
        if (isFinish(gameResult)) {
            console.printEndMessage();
            console.printEndOrRetryMessage();
            int menu = Integer.parseInt(console.inputRetryMenu());
            if (menu == STOP_NUMBER) {
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
        return gameResult.strike() == MAX_STRIKE;
    }

    @Override
    public void restartGame() {

    }
}
