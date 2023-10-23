package baseball.service;

import static baseball.common.Constants.NUMBER_LENGTH;

import baseball.validation.InputValidator;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class BaseBallService {
    private static List<Integer> computerNum;
    private static List<Integer> userNum;
    private static int strike;
    private static int ball;

    private static InputValidator inputValidator = new InputValidator();

    public void init(List<Integer> generatedComputerNum) {
        computerNum = generatedComputerNum;
        initStrikeAndBall();
    }

    public void initStrikeAndBall() {
        strike = 0;
        ball = 0;
    }

    public void start() {

        do {
            initStrikeAndBall();
            receiveUserInput();
            compareUserAndComputer();
        } while (judgeStrikeAndBall());
    }

    public boolean judgeStrikeAndBall() {
        if (strike == NUMBER_LENGTH) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return false;
        } else if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (strike == 0 && ball != 0) {
            System.out.println(ball + "볼");
        } else if (strike != 0 && ball == 0) {
            System.out.println(strike + "스트라이크");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
        return true;
    }

    public void compareUserAndComputer() {
        strike = (int) IntStream.range(0, 3)
                .filter(i -> userNum.get(i).equals(computerNum.get(i)))
                .count();
        ball = (int) IntStream.range(0, 3)
                .filter(i -> userNum.get(i).equals(computerNum.get((i + 1) % 3)) || userNum.get(i)
                        .equals(computerNum.get((i + 2) % 3)))
                .count();
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