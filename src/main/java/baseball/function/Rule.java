package baseball.function;
import baseball.value.GameCount;
import baseball.value.ResultNum;
import camp.nextstep.edu.missionutils.Console;

public class Rule {

    GameCount gameCount;
    ResultNum resultNum;

    public Rule(ResultNum resultNum, GameCount gameCount) {
        this.resultNum = resultNum;
        this.gameCount = gameCount;
    }


    public Rule(ResultNum resultNum) {
        this.resultNum = resultNum;
    }

    public void checkMatches() {
        for (int i = 0; i < 3; i++) {
            compareNumber(resultNum.getComputerNumber(), resultNum.getUserNumber(), i);
            System.out.println("qqq");
        }
    }

    public void compareNumber(int[] computerNumber, int[] userNumber, int userIndex) {
        int isNon = -1;
        for (int j = 0; j < 3; j++) {
            if (computerNumber[j] == userNumber[userIndex]) {
                isNon = j;
                break;
            }
        }
        addCount(isNon, userIndex);
    }

    public void addCount(int isNon, int userIndex) {
        if (isNon != -1 && isNon == userIndex) {
            gameCount.strike();
        }
        if (isNon != -1 && isNon != userIndex) {
            gameCount.ball();
        }
    }

    public boolean checkReGame() throws IllegalArgumentException {
        String input = Console.readLine();
        if (input.equals("1")) {
            return true;
        } else if (input.equals("2")) {
            return false;
        }
        throw new IllegalArgumentException();
    }
}
