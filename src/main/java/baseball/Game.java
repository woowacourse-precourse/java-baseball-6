package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static java.lang.Integer.parseInt;

public class Game {
    static List<Integer> computer = new ArrayList<>();
    static List<Integer> user = new ArrayList<>();
    static boolean programRunning = true;
    static boolean gameRunning = true;

    private void printGameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private void generateRandomNumber() {
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        System.out.print("답:");
        for (int e: computer) {
            System.out.print(e);
        }
        System.out.println("");
    }

    private void getUserInput() {
        user = new ArrayList<>();

        System.out.print("숫자를 입력해주세요 : ");
        String userInputString = readLine();
        while (userInputString.length() != 3) {
            System.out.println("잘못된 입력입니다. 세 자리 수로 다시 입력해주세요.");
            userInputString = readLine();
        }

        int userInputInt = parseInt(userInputString);
//        System.out.println(userInputInt);

        for (int i = 0; i < 3; i++) {
            user.add(userInputInt % 10);
            userInputInt = userInputInt / 10;
        }
//        System.out.println("getUserInput 끝");
    }

    private void printResult() {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            if (user.get(i) == computer.get(i)) {
                strike++;
            } else if (computer.contains(user.get(i))) {
                ball++;
            }
        }

        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            gameRunning = false;
        } else if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else {
            if (ball != 0) System.out.print(ball + "볼 ");
            if (strike != 0) System.out.print(strike + "스트라이크");
            System.out.println("");
        }
    }

    private void examineNewGameOrNot() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = readLine();
        while (!userInput.equals("1") && !userInput.equals("2")) {
            System.out.println("잘못된 입력입니다.");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            userInput = readLine();
        }
        if (userInput.equals("1")) {
            programRunning = true;
        } else if (userInput.equals("2")) {
            programRunning = false;
        }
    }


    private void startGame() {
        generateRandomNumber();

        while (gameRunning) {
            getUserInput();
            printResult();
        }
    }

    private void resetData() {
        computer = new ArrayList<>();
        programRunning = true;
        gameRunning = true;
    }

    public void startProgram() {
        printGameStartMessage();
        while (programRunning) {
            startGame();
            resetData();
            examineNewGameOrNot();
        }
    }
}