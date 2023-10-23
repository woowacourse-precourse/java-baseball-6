package baseball;

import java.util.List;
import java.util.Map;

public class MenuHandler {
    private final Computer computer;

    public MenuHandler(Computer computer) {
        this.computer = computer;
    }

    public void tryHandle() {
        try {
            initialHandle();
            handle();
        } catch (RuntimeException exception) {
            Communicator.printException(exception);
            throw exception;
        }
    }

    private void initialHandle() {
        Communicator.printStart();
        runGame();
    }

    private void handle() {
        boolean runningFlag = true;
        while (runningFlag) {
            Menu menu = Communicator.instructMenu();
            runningFlag = switch (menu) {
                case START -> {
                    runGame();
                    yield true;
                }
                case TERMINATE -> {
                    Communicator.printTerminate();
                    yield false;
                }
            };
        }
    }

    private void runGame() {
        computer.decideAnswer();

        boolean isOver = false;
        while (!isOver) {
            List<Integer> inputNumbers = Communicator.instructInputNumbers();
            Map<Count, Integer> counts = computer.count(inputNumbers);
            Communicator.printResult(counts);
            isOver = isCorrect(counts.get(Count.STRIKE));
        }
    }

    private boolean isCorrect(int strikeCount) {
        return strikeCount == 3;
    }
}
