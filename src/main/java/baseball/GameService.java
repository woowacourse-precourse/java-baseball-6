package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;


public class GameService {
    public static void runWholeGame() {
        OutputMessage.startGame();

        do {
            runOneGame();
            inputContinueFlag();
        } while (!Player.endFlag);
    }

    public static void runOneGame() {
        Com.setAnswerNumbers();
        Player.initBallAndStrikeCount();

        do {
            inputPlayerNumbers();
            countBallStrike();
            OutputMessage.printResultMessage(Player.ballCount, Player.strikeCount);
        } while (!is3Strike());
    }

    public static void countBallStrike() {
        for (int i = 0; i < 3; i++) {
            int target = Player.numbers.get(i);
            if (Com.answerNumbers.get(i) == target) {
                Player.strikeCount++;
            }
            else if (Com.answerNumbers.contains(target)) {
                Player.ballCount++;
            }
        }
    }

    public static void inputPlayerNumbers() {
        OutputMessage.demandNumbers();
        Player.setNumbers(readLine());
    }

    public static void inputContinueFlag() {
        OutputMessage.demandContinueFlag();
        Player.setEndFlag(readLine());
    }

    public static boolean is3Strike(){
        return Player.strikeCount == 3;
    }

}
