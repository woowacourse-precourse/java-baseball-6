package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class Baseball {
    private ArrayList<Integer> computerNumbers;
    private ArrayList<Integer> userNumbers;
    private int ball;
    private int strike;

    Baseball() {
        computerNumbers = new ArrayList<Integer>();
        userNumbers = new ArrayList<Integer>();
    }
    public boolean playBaseballGame() {
        resetComputerNumber();
        do {
            inputUserNumbers();
            playGame();
            printResult();
        } while (strike < 3);

        boolean result;
        try {
            result = isGameExit();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            throw e;
        }
        return result;
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

    private void resetComputerNumber() {
        computerNumbers.clear();
        while(computerNumbers.size() < 3) {
            addComputerNumber();
        }
    }

    private void addComputerNumber() {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        if(!computerNumbers.contains(randomNumber))
            computerNumbers.add(randomNumber);
    }

    private void resetUserNumber(String inputNumber) throws IllegalArgumentException {
        if(inputNumber.length() != 3) {
            throw new IllegalArgumentException("문자 없이 숫자를 3개만 입력해주세요");
        }
        userNumbers.clear();
        String[] inputNumberArray = inputNumber.split("");
        for(String str : inputNumberArray) {
            addUserNumber(str);
        }
    }

    private void addUserNumber(String str) throws IllegalArgumentException {
        if(!(str.matches("[0-9]+"))) {
            throw new IllegalArgumentException("숫자 외의 문자가 들어있습니다.");
        }
        int addNumber = Integer.valueOf(str).intValue();
        if(userNumbers.contains(addNumber)) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
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

    private boolean isGameExit() throws IllegalArgumentException {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        String exitGame = Console.readLine();
        if(exitGame.equals("1")) {
            return true;
        }
        if(exitGame.equals("2")) {
            System.out.println("게임 종료");
            return false;
        }
        throw new IllegalArgumentException("1이나 2로만 입력해야 합니다.");
    }
}
