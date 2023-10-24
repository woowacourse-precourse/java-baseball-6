package baseball.service;

import baseball.domain.GameInfo;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameService {
    final int SIZE = 3;
    final int START_NUM = 1;
    final int END_NUM = 9;
    final int FLAG_SIZE = 1;
    final int REPLAY = 1;
    final int END = 2;
    private InputValidator inputValidator;

    public GameService() {
        this.inputValidator = new InputValidator();
    }
    public List<Integer> makeComputerNum() {
        List<Integer> computerNum = new ArrayList<>();

        while (computerNum.size() < SIZE) {
            int randomNumber = Randoms.pickNumberInRange(START_NUM, END_NUM);

            if (!computerNum.contains(randomNumber)) {
                computerNum.add(randomNumber);
            }
        }

        return computerNum;
    }

    public void guessNum(GameInfo gameInfo) {
        char[] charArr = gameInfo.getInput().toCharArray();
        List<Integer> computerNum = gameInfo.getComputerNum();
        int strikeCount = 0, ballCount = 0;

        for (int i = 0; i < charArr.length; i++) {
            int temp = charArr[i] - '0';

            if (computerNum.contains(temp)) {
                if (temp == computerNum.get(i)) {
                    strikeCount++;
                } else {
                    ballCount++;
                }
            }
        }
        gameInfo.setStrikeCount(strikeCount);
        gameInfo.setBallCount(ballCount);
    }

    public String inputValidateCheck() {
        String input = Console.readLine();

        inputValidator.numericCheck(input);
        inputValidator.lengthCheck(input, SIZE);
        inputValidator.duplicateCheck(input);
        inputValidator.validateDigitCheck(input, START_NUM, END_NUM);

        return input;
    }

    public boolean flagInputValidateCheck() {
        String input = Console.readLine();

        inputValidator.numericCheck(input);
        inputValidator.lengthCheck(input, FLAG_SIZE);
        inputValidator.validateDigitCheck(input, REPLAY, END);
        int inputNum = Integer.parseInt(input);

        if(inputNum == REPLAY){
            return true;
        }else {
            return false;
        }
    }
}
