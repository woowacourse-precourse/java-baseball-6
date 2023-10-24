package baseball;

import baseball.util.PrintMessage;
import baseball.util.Validation;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class BaseBallGame {
    private Numbers numbers;
    private static int START_INCLUSIVE = 1;
    private static int END_INCLUSIVE = 9;
    private static int DIGIT = 3;
    private static String GAME_FLAG = "1";

    public BaseBallGame() {
    }

    public void run() {
        PrintMessage.printInitMessage();
        while (GAME_FLAG.equals("1")) {
            this.numbers = new Numbers();
            initNumbers();
            playGame();
        }
    }

    private void playGame() {
        GameResult gameResult;
        while (true) {
            gameResult = oneWayOfGame();

            if (gameResult.isSuccess())
                break;

            gameResult.printGameResult();
        }
        PrintMessage.printSuccessMessage();

        GAME_FLAG = Validation.isValidGameFlag(Console.readLine());
    }


    private GameResult oneWayOfGame() {
        PrintMessage.printInputMessage();

        String inputNum = Console.readLine();
        Validation.isValidInputNumber(inputNum);

        String computerNum = numbers.toString();
        GameResult gameResult = new GameResult();

        for (int i = 0; i < inputNum.length(); i++) {
            //자리수와 문자가 같으면 스트라이크
            if (inputNum.charAt(i) == computerNum.charAt(i)) {
                gameResult.addStrikeCnt();
                continue;
            }
            //해당 자리엔 없어도 다른 곳에 포함되어 있으면 ball
            if (computerNum.contains(Character.toString(inputNum.charAt(i)))) {
                gameResult.addBallCnt();
                continue;
            }
        }
        if (gameResult.getStrikeCnt() == DIGIT)
            gameResult.setSuccess(true);
        return gameResult;
    }

    private void initNumbers() {
        numbers = new Numbers();
        while (!numbers.isReady(DIGIT)) {
            int randomNum = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
            numbers.addNumber(randomNum);
        }
    }
}
