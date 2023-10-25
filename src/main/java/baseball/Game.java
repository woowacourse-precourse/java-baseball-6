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

    static int strike = 0;
    static int ball = 0;

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

    }

    private void examineNewGameOrNot() {

    }


    private void startGame() {
        generateRandomNumber();

        while (gameRunning) {
            getUserInput();
            printResult();
        }
    }

    private void resetData() {
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