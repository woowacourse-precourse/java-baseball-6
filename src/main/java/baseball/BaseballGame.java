package baseball;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class BaseballGame {
    private static int computerNumberLength = 3;
    private static PrintStream printStream = System.out;
    private List<Integer> computerNumbers;
    private List<Integer> userNumbers;

    public BaseballGame() {
        this.computerNumbers = pickComputerNumbers();
        this.userNumbers = new ArrayList<Integer>(computerNumberLength);
    }

    public List<Integer> getComputerNumbers() {
        return computerNumbers;
    }

    public List<Integer> getUserNumbers() {
        return userNumbers;
    }

    public List<Integer> pickComputerNumbers() {
        List<Integer> computerNumbers = new ArrayList<Integer>(computerNumberLength);

        for (int i = 0; i < computerNumberLength; i++) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (computerNumbers.indexOf(randomNumber) != -1) {
                i--;
                continue;
            }
            
            computerNumbers.add(randomNumber) ;
        }

        return computerNumbers;
    }
    
    public void inputAnswer() {
        List<Integer> inputNumbers = new ArrayList<Integer>(computerNumberLength);
        String REGEXP_ONLY_NUM = "^[1-9]{" + computerNumberLength + "}$";
        String input = "";

        input = Console.readLine();

        if (!Pattern.matches(REGEXP_ONLY_NUM, input)) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < input.length(); i++) {
            inputNumbers.add(input.charAt(i) - '0');
        }

        this.userNumbers = inputNumbers;
    }

    public boolean isMatchedAnswer() {
        int ballCount = 0;
        int strikeCount = 0;

        for (int idx = 0; idx < this.computerNumbers.size(); idx++) {
            int userNumberIdx = this.userNumbers.indexOf(this.computerNumbers.get(idx));

            if (userNumberIdx == idx) strikeCount += 1;
            else if (userNumberIdx > -1) ballCount += 1;
        }

        printStream.println(this.getComparedResult(ballCount, strikeCount));

        return strikeCount == computerNumberLength;
    }

    public String getComparedResult(int ballCount, int strikeCount) {
        String comparedResult = "";

        if (ballCount == 0 && strikeCount == 0) return "낫싱";
        if (ballCount > 0) comparedResult += ballCount + "볼";
        if (strikeCount > 0) comparedResult += " " + strikeCount + "스트라이크";

        return comparedResult;
    }

    public int selectMode() {
        String REGEXP_ONLY_NUM = "^[1|2]{1}$";
        String input = Console.readLine();
        
        if (!Pattern.matches(REGEXP_ONLY_NUM, input)) {
            throw new IllegalArgumentException();
        }

        return Integer.parseInt(input);
    }
}
