package baseball;

import java.util.ArrayList;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        BaseballGame.start();
    }
}

class Array {
    static int inArray(int[] arr, int number) {
        int count = 0;
        for (int value : arr) {
            boolean isSame = (value == number);
            count += Boolean.compare(isSame, false);
        }
        return count;
    }

    static int[] stringToIntegerArray(String ans) {
        int[] arr = new int[ans.length()];
        for (int i = 0; i < ans.length(); i++) {
            arr[i] = ans.charAt(i) - '0';
        }
        return arr;
    }

    static int inArray(ArrayList<Integer> computer, int number) {
        int count = 0;
        for (int value : computer) {
            boolean isSame = (value == number);
            count += Boolean.compare(isSame, false);
        }
        return count;
    }

    static int isStrike(ArrayList<Integer> computer, int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            boolean isSame = (computer.get(i) == arr[i]);
            count += Boolean.compare(isSame, false);
        }
        return count;
    }
}

class BaseballGame {
    final static int minNumber = 1;
    final static int maxNumber = 9;
    final static int answerLength = 3;
    static ArrayList<Integer> computer = new ArrayList<>();

    private BaseballGame() {
        throw new IllegalArgumentException();
    }

    static void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        makeAnswer();
    }

    static void makeAnswer() {
        computer.clear();
        while (computer.size() < answerLength) {
            int randomNumber = pickNumberInRange(minNumber, maxNumber);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        inputAnswer();
    }

    static void inputAnswer() {
        System.out.print("숫자를 입력해주세요 : ");
        String answer = readLine();
        inputCheck(answer);
        ReturnAnswer.matchAnswer(answer);
    }

    static void inputCheck(String ans) {
        inputLengthCheck(ans);
        inputNumberCheck(ans);
        inputEqualCheck(ans);
    }

    static void inputLengthCheck(String ans) {
        if (ans.length() != answerLength){
            throw new IllegalArgumentException();
        }
    }

    static void inputNumberCheck(String ans) {
        try {
            Integer.parseInt(ans);
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    static void inputEqualCheck(String ans) {
        int[] arr = Array.stringToIntegerArray(ans);
        for (int value : arr) {
            if (Array.inArray(arr, value)>1) {
                throw new IllegalArgumentException();
            }
        }
    }
}

class ReturnAnswer {
    static int strike = 0;
    static int ball = 0;

    static void matchAnswer(String ans) {
        checkBall(ans);
        checkStrike(ans);
        printResult();
        if (strike != ans.length()) {
            BaseballGame.inputAnswer();
            return;
        }
        restart();
    }

    static void checkBall(String ans) {
        ball = 0;
        int[] arr = Array.stringToIntegerArray(ans);
        for (int value : arr) {
            boolean isBall = (Array.inArray(BaseballGame.computer, value) == 1);
            ball += Boolean.compare(isBall, false);
        }
    }

    static void checkStrike(String ans) {
        int[] arr = Array.stringToIntegerArray(ans);
        strike = Array.isStrike(BaseballGame.computer, arr);
        ball = ball - strike;
    }

    static void printResult() {
        String result = "";
        if (ball != 0) {
            result += ball + "볼 ";
        }
        if (strike!=0) {
            result += strike + "스트라이크";
        }
        if (result.isEmpty()) {
            result = "낫싱";
        }
        System.out.println(result);
    }

    static void restart() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String answer = readLine();
        if (!answer.equals("1") && !answer.equals("2")) {
            throw new IllegalArgumentException();
        }
        if (answer.equals("1")) {
            BaseballGame.makeAnswer();
        }
    }
}