package baseball.service;

import baseball.validation.InputValidator;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class BaseBallService {
    private static List<Integer> computerNum;
    private static List<Integer> userNum;
    private static int strike = 0;
    private static int ball = 0;

    private static InputValidator inputValidator = new InputValidator();

    public void init(List<Integer> generatedComputerNum) {
        computerNum = generatedComputerNum;
    }

    public void start() {
        boolean restart = true;

        while (restart) {
            receiveUserInput();
        }

    }

    public void checkValid(String strUserNum) {
        if (!inputValidator.isValidLength(strUserNum) || !inputValidator.isValidNumber(strUserNum)) {
            throw new IllegalArgumentException();
        }
    }

    public void receiveUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String strUserNum = Console.readLine();
        checkValid(strUserNum);

        String[] strArrUserNum = strUserNum.split("");
        userNum = new ArrayList<>();
        for (int i = 0; i < strArrUserNum.length; i++) {
            userNum.add(Integer.parseInt(strArrUserNum[i]));
        }
    }

}