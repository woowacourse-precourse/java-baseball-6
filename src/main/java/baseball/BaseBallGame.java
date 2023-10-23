package baseball;

import baseball.util.PrintMessage;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class BaseBallGame {
    private Numbers numbers;
    private static int START_INCLUSIVE = 1;
    private static int END_INCLUSIVE = 9;
    private static int DIGIT = 3;
    private static String GAME_FLAG = "1";

    public BaseBallGame() {
        this.numbers = new Numbers();
        initNumbers();
    }

    public BaseBallGame(int startInclusive, int endInclusive) {
        this.numbers = new Numbers();
        START_INCLUSIVE = startInclusive;
        END_INCLUSIVE = endInclusive;
        initNumbers();
    }

    public void run() {
        PrintMessage.printInitMessage();
        while (GAME_FLAG.equals("1")) {
            GAME_FLAG = playGame();
        }
    }

    private String playGame() {
        if (oneWayOfGame()) {
            PrintMessage.printSuccessMessage();
            GAME_FLAG = Console.readLine();
        }
        return GAME_FLAG;
    }

    private boolean oneWayOfGame() {
        PrintMessage.printInputMessage();
        String inputNum = Console.readLine();
        String number = numbers.toString();
        int ballCnt = 0;
        int strikeCnt = 0;


        for (String input : inputNum.split("")) {
            for (String num : number.split("")) {
                if (input.equals(num)) {
                    strikeCnt += 1;
                } else if (number.contains(input)) {
                    ballCnt += 1;
                }
            }
        }
        if (strikeCnt == DIGIT)
            return true;
        if(strikeCnt > 0){
            PrintMessage.printStrikeMessage(strikeCnt);
            return false;
        }

        PrintMessage.printBallMessage(ballCnt);
        return false;
    }

    private void initNumbers() {
        while (!numbers.isReady(DIGIT)) {
            int randomNum = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
            numbers.addNumber(randomNum);
        }
    }
}
