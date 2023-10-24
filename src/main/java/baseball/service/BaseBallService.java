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

    //생성된 컴퓨터 번호 저장
    public void init(List<Integer> generatedComputerNum) {
        computerNum = generatedComputerNum;
    }

    // 매 추론마다 비교를 위해 스트라이크와 볼 초기화
    public void initStrikeAndBall() {
        strike = 0;
        ball = 0;
    }

    /*
    1. initStrikeAndBall: 스트라이크 및 볼 초기화
    2. receiveUserInput: 유저의 입력값 받기
    3. compareUserAndComputer: 컴퓨터의 번호와 입력값 비교
    4. judegeStrikeAndBall: 게임 종료 및 진행 판단
     */
    public void start() {

        do {
            initStrikeAndBall();
            receiveUserInput();
            compareUserAndComputer();
        } while (judgeStrikeAndBall());
    }

    // 스트라이크 개수를 통해 게임 종료 및 진행 판단 및 결과 출력
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

    // 컴퓨터의 번호와 입력값 비교: 숫자와 자리가 같으면 스트라이크, 숫자가 같고 위치가 다르면 볼, 다르면 카운트 안함
    public void compareUserAndComputer() {
        strike = (int) IntStream.range(0, 3)
                .filter(i -> userNum.get(i).equals(computerNum.get(i)))
                .count();
        ball = (int) IntStream.range(0, 3)
                .filter(i -> userNum.get(i).equals(computerNum.get((i + 1) % 3)) || userNum.get(i)
                        .equals(computerNum.get((i + 2) % 3)))
                .count();
    }

    // 유저 입력값을 판단하기 위한 함수: 자리가 3자리인지, 허용된 범위의 숫자인지, 중복은 없는지 체크
    public void checkValid(String strUserNum) {
        if (!inputValidator.isValidLength(strUserNum) || !inputValidator.isValidNumber(strUserNum)) {
            throw new IllegalArgumentException();
        }
    }

    // 유저의 입력값 받기: ArrayList로 저장
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