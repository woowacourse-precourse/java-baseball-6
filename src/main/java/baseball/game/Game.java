package baseball.game;

import baseball.io.InputHandler;
import baseball.io.OutputHandler;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Integer> numbers;
    InputHandler inputHandler;
    OutputHandler outputHandler;
    Message message;

    public Game(InputHandler inputHandler, OutputHandler outputHandler, Message message) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.message = message;
    }

    // 실행
    public void run() {
        GameStatus gameStatus = GameStatus.INIT;

        outputHandler.printMessage(message.start);

        while (gameStatus != GameStatus.EXIT) {
            if (gameStatus == GameStatus.INIT) {
                init();
                gameStatus = GameStatus.PROGRESS;
            }

            outputHandler.printMessage((message.requestNumber));
            int[] ballCount = countBallAndStrike(inputHandler.getNumber());

            // ball/strike 메시지
            outputHandler.printMessage((message.makeMessage(ballCount)));

            if (ballCount[1] == 3) {
                outputHandler.printMessage((message.requestCommand));

                String cmd = inputHandler.getCommand();
                int status = Integer.parseInt(cmd);

                switch (status) {
                    case 1:
                        gameStatus = GameStatus.INIT;
                        break;
                    case 2:
                        gameStatus = GameStatus.EXIT;
                }

                if (gameStatus == GameStatus.EXIT) {
                    outputHandler.printMessage((message.end));
                }
            }
        }
    }

    // 게임 초기화
    private void init() {
        numbers = setNumbers();
    }

    // 난수 뽑기
    private List<Integer> setNumbers() {
        boolean[] check = new boolean[10];

        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < 3) {
            Integer number = Randoms.pickNumberInRange(1, 9);

            if (check[number]) {
                continue;
            }

            check[number] = true;
            numbers.add(number);
        }

        return numbers;
    }

    // 입력된 숫자 카운트
    private int[] countBallAndStrike(String param) {
        int ballCount = 0;
        int strikeCount = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < numbers.size(); j++) {
                if (param.charAt(i) - '0' == numbers.get(j)) {
                    if (i == j) {
                        strikeCount++;
                    } else {
                        ballCount++;
                    }
                }
            }
        }

        return new int[]{ballCount, strikeCount};
    }
}
