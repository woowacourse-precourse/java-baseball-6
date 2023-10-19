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
            iterCheck = inputValidate(inputNumber);
        } while (iterCheck);
    }

    private void createRandomNumber(){
        randomNumber.clear();
        while (randomNumber.size() < RANDOM_NUMBER_SIZE) {
            int intRandomNumber = Randoms.pickNumberInRange(START_RANGE, LAST_RANGE);
            if (!randomNumber.contains(intRandomNumber)) {
                randomNumber.add(intRandomNumber);
            }
        }
    }

    private String userInput()  {
        System.out.print(INPUT_NUMBER);
        return Console.readLine();
    }

    private void errorValidate(String stringNumber) {
        if (!stringNumber.matches(REGULAR_EXPRESSION_INPUT_NUMBER)) {
            throw new IllegalArgumentException(INPUT_ERROR);
        }
    }

    private List<Integer> stringToIntegerList(String stringNumber)  {
        List<Integer> inputNumber = new ArrayList<>();
        for(char charNumber : stringNumber.toCharArray()) {
            inputNumber.add(Character.getNumericValue(charNumber));
        }
        return inputNumber;
    }

    private boolean inputValidate(List<Integer> number){
        int strike = strikeValidate(number);
        int ball = ballValidate(number);
        boolean nothing = nothingValidate(strike,ball);
        if (nothing) {
            printNothing();
            return true;
        } else if (strike == THREE_STRIKE) {
            printStrike(strike);
            System.out.println();
            return false;
        }
        printBall(ball);
        System.out.print(" ");
        printStrike(strike);
        System.out.println();
        return true;
    }

    private int strikeValidate(List<Integer> number){
        int count = 0;
        for (int i = 0; i<INPUT_NUMBER_SIZE; i++) {
            if (number.get(i).equals(randomNumber.get(i))) {
                count+=1;
                number.set(i,COMPLETE_CHECK_NUM);
            }
        }
        return count;
    }

    private int ballValidate(List<Integer> number){
        int count = 0;
        for (int i = 0; i<INPUT_NUMBER_SIZE; i++) {
            if (randomNumber.contains(number.get(i))) {
                count+=1;
                number.set(i,COMPLETE_CHECK_NUM);
            }
        }
        return count;
    }

    private boolean nothingValidate(int strike, int ball){
        return ball == NOTHING_CHECK_NUM && strike == NOTHING_CHECK_NUM;
    }

    private void printNothing(){
        System.out.println(NOTHING);
    }

    private void printStrike(int strike){
        if (strike != 0) {
            System.out.print(strike+STRIKE);
        }
    }

    private void printBall(int ball){
        if (ball != 0) {
            System.out.print(ball+BALL);
        }
    }

    private void gameEnd(){
        System.out.println(GAME_END);
    }

    private boolean restartOrExit()  {
        gameEnd();
        System.out.print(RESTART_OR_EXIT);
        String restartOrExit = Console.readLine();
        return restartOrExitValidate(restartOrExit);

    }

    private boolean restartOrExitValidate(String restartOrExit)  {
        if (!restartOrExit.matches(REGULAR_EXPRESSION_RESTART_OR_END_NUMBER)) {
            throw new IllegalArgumentException(INPUT_ERROR);
        }
        if (restartOrExit.equals(RESTART_VALUE)) {
            return true;
        } else if (restartOrExit.equals(END_VALUE)) {
            return false;
        }
        return false;
    }
    
}
