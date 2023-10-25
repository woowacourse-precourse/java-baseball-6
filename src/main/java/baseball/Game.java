package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {

    final int SIZE = 3;
    List<Integer> answerList = new ArrayList<>();

    public Game() {
        while (answerList.size() < SIZE) {
            int randNum = Randoms.pickNumberInRange(1, 9);
            if (!answerList.contains(randNum)) {
                answerList.add(randNum);
            }
        }
    }

    public static void run() {
        Game game;
        do {
            game = new Game();
            game.play();
        } while (game.isRestart());
    }

    private void play() {
        String inputStr;
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            System.out.print("숫자를 입력해주세요 : ");
            inputStr = Console.readLine();
        } while (checkInput(inputStr) != true);
    }

    private boolean checkInput(String inputStr) {
        int[] inputArr = convertStrToArr(inputStr);
        int strikeNum = countStrike(inputArr);
        int ballNum = countBall(inputArr) - strikeNum;
        printResult(strikeNum, ballNum);

        if (strikeNum == 3) {
            return true;
        }
        return false;

    }

    private void printResult(int strikeNum, int ballNum) {
        int ballAndStrike = strikeNum + ballNum;
        if (ballAndStrike == 0) {
            System.out.println("낫싱");
            return;
        }
        if (strikeNum == 3) {
            System.out.println(String.format("%d스트라이크", strikeNum));
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return;
        }
        if (strikeNum > 0 && ballNum > 0) {
            System.out.println(String.format("%d볼 %d스트라이크", ballNum, strikeNum));
            return;
        }
        if (strikeNum > 0) {
            System.out.println(String.format("%d스트라이크", strikeNum));
        }
        if (ballNum > 0) {
            System.out.println(String.format("%d볼", ballNum));
        }
    }

    private int[] convertStrToArr(String inputStr) { //
        int[] intArr = new int[3];
        checkStrSize(inputStr, 3);
        for (int i = 0; i < inputStr.length(); i++) {
            if (inputStr.charAt(i) < '0' || inputStr.charAt(i) > '9') {
                throw new IllegalArgumentException();
            }
            intArr[i] = Integer.parseInt(inputStr.substring(i, i + 1));
        }
        return intArr;
    }

    private void checkStrSize(String inputStr, int correctLength) {
        if (inputStr.length() != correctLength) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String inputString = Console.readLine();
        if (inputString.equals("1")) {
            return true;
        }
        if (inputString.equals("2")) {
            return false;
        }

        throw new IllegalArgumentException();

    }

    private int countStrike(int[] inputNum) {
        int strikeNum = 0;
        for (int i = 0; i < answerList.size(); i++) {
            if (inputNum[i] == answerList.get(i)) {
                strikeNum++;
            }
        }
        return strikeNum;
    }

    private int countBall(int[] inputNum) {
        int ballNum = 0;
        for (int i : inputNum) {
            if (answerList.contains(i)) {
                ballNum++;
            }
        }
        return ballNum;
    }
}