package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class Baseball {

    private final PrintMessage printMessage = new PrintMessage();
    private final InputLineConverter InputNumberConverter = new InputLineConverter();
    private ArrayList<Integer> answerNumberList = new ArrayList<>();
    private ArrayList<Integer> myInputNumber = new ArrayList<>();

    public void run() {
        printMessage.gameStartMessage();
        startGame();
    }

    public void startGame() {
        int commandNumber;
        do {
            initRandomNumberList();

            myInputNumber = InputNumberConverter.stringToIntegerList().orElseThrow(
                    () -> new IllegalArgumentException("입력값이 잘못되었습니다.")
            );

            while (!checkGameScore()) {
                myInputNumber = InputNumberConverter.stringToIntegerList().orElseThrow(
                        () -> new IllegalArgumentException("입력값이 잘못되었습니다.")
                );
            }

            printMessage.endGameCommand();
            commandNumber = InputNumberConverter.commandNumber().orElseThrow(
                    () -> new IllegalArgumentException("입력값이 잘못되었습니다.")
            );

        } while (commandNumber == 1);
    }

    public void initRandomNumberList() {

        answerNumberList = new ArrayList<>();
        answerNumberList.add(Randoms.pickNumberInRange(1, 9));

        while (answerNumberList.size() < 3) {

            int nowNumber = Randoms.pickNumberInRange(1, 9);
            int isDupleNumber = (int) answerNumberList.stream()
                    .filter(n -> n == nowNumber)
                    .count();

            if (isDupleNumber == 0) {
                answerNumberList.add(nowNumber);
            }
        }

    }

    public boolean checkGameScore() {
        int nowNumber;
        int comparisonTarget;
        int ballCount = 0;
        int strikeCount = 0;

        for (int i = 0; i < 3; i++) {
            nowNumber = answerNumberList.get(i);
            for (int j = 0; j < 3; j++) {
                comparisonTarget = myInputNumber.get(j);
                if (nowNumber == comparisonTarget) {
                    if (i == j) {
                        strikeCount++;
                        continue;
                    }
                    ballCount++;
                }
            }
        }

        printMessage.gameResult(ballCount, strikeCount);

        if (strikeCount == 3) {
            return true;
        }

        return false;
    }
}
