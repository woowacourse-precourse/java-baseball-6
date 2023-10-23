package baseball;

import java.util.List;
import java.util.Map;

public class MenuHandler {
    private final Computer computer;
    private final Communicator communicator;

    public MenuHandler(Computer computer, Communicator communicator) {
        this.computer = computer;
        this.communicator = communicator;
        initialHandle();
    }

    private void initialHandle() {
        communicator.printStart();
        runGame();
    }

    public void handle() {
        boolean runningFlag = true;
        while (runningFlag) {
            Menu menu = communicator.instructMenu();
            runningFlag = switch (menu) {
                case START -> {
                    runGame();
                    yield true;
                }
                case TERMINATE -> {
                    communicator.printTerminate();
                    yield false;
                }
            };
        }
    }

    private void runGame() {
        computer.decideAnswer();

        boolean isOver = false;
        while (!isOver) {
            List<Integer> inputNumbers = communicator.instructInputNumbers();
            Map<String, Integer> counts = computer.count(inputNumbers);
            communicator.printResult(counts);
            isOver = isCorrect(counts.get("strikeCount"));
        }
    }

    private boolean isCorrect(int strikeCount) {
        return strikeCount == 3;
    }
}
