package baseball.game;

import baseball.constant.ErrorConstant;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static baseball.constant.ErrorConstant.*;
import static baseball.constant.GameConstant.*;

public class Game {
    List<Integer> randomNumber = new ArrayList<>();

    public void run()  {
        do {
            oneGame();
        } while (restartOrExit());
    }

    //한 게임
    private void oneGame() {
        boolean iterCheck;
        System.out.println(GAME_START);
        createRandomNumber();
        System.out.println(randomNumber);
        do {
            String stringNumber = userInput();
            errorValidate(stringNumber);
            List<Integer> inputNumber = stringToIntegerList(stringNumber);
            iterCheck = inputCheck(inputNumber);
        } while (iterCheck);
    }

    //난수 생성
    private void createRandomNumber(){
        randomNumber.clear();
        while (randomNumber.size() < RANDOM_NUMBER_SIZE) {
            int intRandomNumber = Randoms.pickNumberInRange(START_RANGE, LAST_RANGE);
            if (!randomNumber.contains(intRandomNumber)) {
                randomNumber.add(intRandomNumber);
            }
        }
    }

    //유저 입력
    private String userInput()  {
        System.out.print(INPUT_NUMBER);
        return Console.readLine();
    }

    //입력값 에러 체킹
    private void errorValidate(String stringNumber) {
        if (!stringNumber.matches(REGULAR_EXPRESSION_INPUT_NUMBER)) {
            throw new IllegalArgumentException(INCORRECT_ERROR);
        }
    }

    //String -> List<Integer>
    private List<Integer> stringToIntegerList(String stringNumber)  {
        List<Integer> inputNumber = new ArrayList<>();
        for(char charNumber : stringNumber.toCharArray()) {
            inputNumber.add(Character.getNumericValue(charNumber));
        }
        return inputNumber;
    }

    //입력값과 정해진 난수와 비교하여 볼 , 스트라이크 , 낫싱 결정
    private boolean inputCheck(List<Integer> number){
        int strike = strikeCheck(number);
        int ball = ballCheck(number);
        boolean nothing = nothingCheck(strike,ball);
        if (nothing) {
            printNothing();
            return true;
        } else if (strike == THREE_STRIKE) {
            printStrike(strike);
            System.out.println();
            return false;
        }
        printBall(ball);
        printStrike(strike);
        System.out.println();
        return true;
    }

    //입력값과 난수를 비교하여 스트라이크 결정
    private int strikeCheck(List<Integer> number){
        int count = 0;
        for (int i = 0; i<INPUT_NUMBER_SIZE; i++) {
            if (number.get(i).equals(randomNumber.get(i))) {
                count+=1;
                number.set(i,COMPLETE_CHECK_NUM);
            }
        }
        return count;
    }

    //입력값과 난수를 비교하여 볼 결정
    private int ballCheck(List<Integer> number){
        int count = 0;
        for (int i = 0; i<INPUT_NUMBER_SIZE; i++) {
            if (randomNumber.contains(number.get(i))) {
                count+=1;
                number.set(i,COMPLETE_CHECK_NUM);
            }
        }
        return count;
    }

    //입력값과 난수를 비교하여 낫싱 결정
    private boolean nothingCheck(int strike, int ball){
        return ball == NOTHING_CHECK_NUM && strike == NOTHING_CHECK_NUM;
    }

    //낫싱 프린트
    private void printNothing(){
        System.out.println(NOTHING);
    }

    //스트라이크 프린트
    private void printStrike(int strike){
        if (strike != 0) {
            System.out.print(strike+STRIKE);
        }
    }

    //볼 프린트
    private void printBall(int ball){
        if (ball != 0) {
            System.out.print(ball+BALL);
            System.out.print(" ");
        }
    }

    //게임 끝 프린트
    private void gameEnd(){
        System.out.println(GAME_END);
    }

    //게임이 끝나고 입력값에 따라서 재시작할지(1) , 게임을 종료할지(2) 결정
    private boolean restartOrExit()  {
        gameEnd();
        System.out.println(RESTART_OR_EXIT);
        String restartOrExit = Console.readLine();
        restartOrExitValueValidate(restartOrExit);
        return restartOrExitCheck(restartOrExit);

    }

    //입력값이 올바른지 , 재시작인지 , 종료인지를 확인
    private boolean restartOrExitCheck(String restartOrExit)  {
        if (restartOrExit.equals(RESTART_VALUE)) {
            return true;
        } else if (restartOrExit.equals(END_VALUE)) {
            return false;
        }
        return false;
    }

    private void restartOrExitValueValidate(String restartOrExit) {
        if (!restartOrExit.matches(REGULAR_EXPRESSION_RESTART_OR_END_NUMBER)) {
            throw new IllegalArgumentException(INCORRECT_ERROR);
        }
    }

}
