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
        computer.decideAnswer();

        boolean isOver = false;
        while (!isOver) {
            List<Integer> inputNumbers = communicator.instructInputNumbers();
            Map<String, Integer> counts = computer.count(inputNumbers);
            communicator.printResult(counts);
            isOver = isCorrect(counts.get("strikeCount"));
        }
    }

    public void handle() {
        Menu menu = communicator.instructMenu();
        switch (menu) {
            case START -> {
                computer.decideAnswer();
                boolean isOver = false;
                while (!isOver) {
                    List<Integer> inputNumbers = communicator.instructInputNumbers();
                    Map<String, Integer> counts = computer.count(inputNumbers);
                    communicator.printResult(counts);
                    isOver = isCorrect(counts.get("strikeCount"));
                }
            }
            case TERMINATE -> communicator.printTerminate();
        }
    }

    private boolean isCorrect(int strikeCount) {
        return strikeCount == 3;
    }
}
