package baseball.menu;

import baseball.computer.Computer;
import baseball.utils.Count;
import baseball.communicator.Communicator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class MenuHandler {
    //---Constants---
    private static final int MAX_STRIKE_COUNTS = 3;
    //---------

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

            if (exception.getClass().equals(NoSuchElementException.class)) {
                throw new IllegalArgumentException(exception.getMessage());
            }

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
            executeMenu(menu);
            runningFlag = menu.isRunning();
        }
    }

    private void executeMenu(Menu menu) {
        switch (menu) {
            case START -> runGame();
            case TERMINATE -> Communicator.printTerminate();
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
        return strikeCount == MAX_STRIKE_COUNTS;
    }
}
