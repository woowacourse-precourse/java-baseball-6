package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private int strike = 0, ball = 0, exit = 0;
    private String input;
    private List<Integer> computer, user;
    private boolean gameExit;

    public void initVariable() {
        strike = 0;
        ball = 0;
        exit = 0;
        input = "";
        gameExit = false;
    }

    public void makeComputerNumber() {
        computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    public void inputUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        input = Console.readLine();
    }

    public void convertStringToIntegerList() {
        user = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            checkIsNumber(i);
            checkDuplicateNumber(i);
            user.add(input.charAt(i) - '0');
        }
    }

    public void checkLengthUserNumber() {
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }
    }
    public void checkIsNumber(int index)
    {
        if (input.charAt(index) < '0' || input.charAt(index) > '9') {
            throw new IllegalArgumentException();
        }
    }
    public void checkDuplicateNumber(int index) {
        if (user.contains(input.charAt(index) - '0')) {
            throw new IllegalArgumentException();
        }
    }

    public void checkStrikeOrBall() {
        for (int i = 0; i < computer.size(); i++) {
            countStrikeOrBall(i);
        }
    }

    public void countStrikeOrBall(int index) {
        if (user.contains(computer.get(index))) {
            if (index == user.indexOf(computer.get(index))) {
                strike++;
            } else {
                ball++;
            }
        }
    }

    public void printBall() {
        if (ball > 0) {
            System.out.print(ball + "볼");
        }
    }

    public void printResultSpace() {
        if (ball > 0 && strike > 0) {
            System.out.print(" ");
        }
    }

    public void printStrike() {
        if (strike > 0) {
            System.out.print(strike + "스트라이크");
        }
        System.out.println();
    }

    public void checkExit() {
        exit = Integer.parseInt(Console.readLine());
        if (exit == 1) {
            makeComputerNumber();
        } else if (exit == 2) {
            gameExit = true;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void gameSet() {
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            checkExit();
        }
    }

    public void printResult() {
        if (ball > 0 || strike > 0) {
            printBall();
            printResultSpace();
            printStrike();
            gameSet();
        } else {
            System.out.println("낫싱");
        }
    }

    public void initGame() {
        System.out.println("숫자 야구 시작합니다.");
        makeComputerNumber();
        while (!gameExit) {
            initVariable();
            inputUserNumber();
            checkLengthUserNumber();
            convertStringToIntegerList();
            checkStrikeOrBall();
            printResult();
        }
    }

    public void run() {
        initGame();
    }
}
