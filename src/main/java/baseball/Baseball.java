package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class Baseball {
    ArrayList<Integer> computerNumber;
    ArrayList<Integer> userNumber;
    int ball;
    int strike;

    Baseball() {
        this.ball = 0;
        this.strike = 0;
    }

    void inputResult() {

    }

    void resetComputerNumber() {
        computerNumber = new ArrayList<Integer>();
        while(computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!computerNumber.contains(randomNumber))
                computerNumber.add(randomNumber);
        }
    }

    void resetUserNumber(String inputNumber) throws InputNumberException {
        userNumber = new ArrayList<Integer>();
        String[] inputNumberArray = inputNumber.split("");
        for(String s : inputNumberArray) {
            int addNumber = Integer.valueOf(s).intValue();
            // 입력 예외 처리
            if(userNumber.contains(addNumber) || userNumber.size() + 1 > 3) {
                throw new InputNumberException();
            }
            userNumber.add(addNumber);
        }
    }

    void checkStrike() {
        strike = 0; ball = 0;
        for(int i = 0; i < computerNumber.size(); i++) {
            if(computerNumber.get(i) == userNumber.get(i)) {
                strike++;
            } else {
                checkBall(userNumber.get(i));
            }
        }
    }

    void checkBall(int i) {
        if(computerNumber.contains(i)) {
            ball++;
        }
    }

    void printResult() {
        if(strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return;
        }
        if (ball > 0) {
            System.out.print(ball + "볼 ");
        }
        if (strike > 0) {
            System.out.print(strike + "스트라이크 ");
        }
        if (strike == 3) {
            System.out.println();
            System.out.println("3개의 숫자를 모두 맞추셨습니다! 게임 종료");
            return;
        }
        System.out.println();
    }

    public boolean playBaseballGame() {
        resetComputerNumber();
        while(true) {
            // 1. 숫자 입력 및 확인
            System.out.println("숫자를 입력해주세요. : ");
            String inputNumber = Console.readLine();
            try{
                resetUserNumber(inputNumber);
            } catch (InputNumberException e) {
                return false;       // 프로그램 종료
            }

            // 2. 스트라이크, 볼 판단 및 결과 출력
            checkStrike();
            printResult();

            // 3. 다시 입력받을지 게임을 종료할지 판단.
            String exitGame = null;
            if(strike == 3) {
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
                exitGame = Console.readLine();
                if(exitGame.equals("1")) {
                    return true;
                }
                else if(exitGame.equals("2")) {
                    System.out.println("게임 종료");
                    return false;
                }
            }
        }
    }
}
