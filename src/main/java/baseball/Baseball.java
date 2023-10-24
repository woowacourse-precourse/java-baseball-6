package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class Baseball {
    ArrayList<Integer> computerNumbers;
    ArrayList<Integer> userNumbers;
    int ball;
    int strike;

    private void resetComputerNumber() {
        computerNumbers = new ArrayList<Integer>();
        while(computerNumbers.size() < 3) {
            addComputerNumber();
        }
    }

    private void addComputerNumber() {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        if(!computerNumbers.contains(randomNumber))
            computerNumbers.add(randomNumber);
    }

    private void resetUserNumber(String inputNumber) {
        userNumbers = new ArrayList<Integer>();
        String[] inputNumberArray = inputNumber.split("");
        for(String str : inputNumberArray) {
            addUserNumber(str);
        }
    }

    private void addUserNumber(String str) throws IllegalArgumentException {
        int addNumber = Integer.valueOf(str).intValue();
        if(userNumbers.contains(addNumber) || userNumbers.size() + 1 > 3) {
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
        }
        userNumbers.add(addNumber);
    }

    private void playGame() {
        strike = 0;
        ball = 0;
        for(int i = 0; i < computerNumbers.size(); i++) {
            checkStrike(i);
            checkBall(i);
        }
    }
    private void checkStrike(int idx) {
        if(computerNumbers.get(idx) == userNumbers.get(idx)) {
            strike++;
        }
    }
    private void checkBall(int idx) {
        int userNum = userNumbers.get(idx);
        int computerNum = computerNumbers.get(idx);
        if(computerNumbers.contains(userNum) && userNum != computerNum) {
            ball++;
        }
    }

    private void printResult() {
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

    private void inputUserNumbers() {
        System.out.println("숫자를 입력해주세요. : ");
        String inputNumber = Console.readLine();
        try{
            resetUserNumber(inputNumber);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            throw e;
        }
    }

    private boolean isGameExit() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        String exitGame = Console.readLine();
        if(exitGame.equals("1")) {
            return true;
        }
        else if(exitGame.equals("2")) {
            System.out.println("게임 종료");
            return false;
        }
        return true;
    }
    public boolean playBaseballGame() {
        resetComputerNumber();
        do {
            inputUserNumbers();
            playGame();
            printResult();
        } while(strike < 3);

        boolean result = isGameExit();
        return result;
    }
}
