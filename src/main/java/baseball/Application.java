package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static List<Integer> computer;
    static List<Integer> inputArr;
    static int strike = 0;
    static int ball = 0;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        init();
        checkNum();
        isEnd();
        checkNewGame();

    }

    public static void checkNum() {
        System.out.print("숫자를 입력해주세요 : ");
        inputArr = new ArrayList<>();
        String input = Console.readLine();
        if (input.length() != 3) {
            throw new IllegalArgumentException("잘못된 자릿수의 수 입력");
        }

        for (int i = 0; i < 3; i++) {
            String substring = input.substring(i, i + 1);
            inputArr.add(Integer.parseInt(substring));
        }

        while (strike != 3) {
            checkStrike();
            checkBall();
            checkAnswer();
        }
    }

    public static void checkNewGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String read = Console.readLine();
        if (!(read.equals("1") || read.equals("2"))) {
            throw new IllegalArgumentException("1,2가 아닌 수 입력.");
        }

        if (read.equals("1")) {
            strike = 0;
            ball = 0;
            init();
            checkNum();
            isEnd();
            checkNewGame();
        } else {
            return;
        }
    }

    public static void checkAnswer() {
        if (strike == 3) {
            System.out.println(strike + "스트라이크");
            return;
        }
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (strike == 0 && ball != 0) {
            System.out.println(ball + "볼");
        } else if (strike != 0 && ball == 0) {
            System.out.println(strike + "스트라이크");
        } else {
            System.out.println(ball + "볼" + " " + strike + "스트라이크");
        }

        strike = 0;
        ball = 0;
        System.out.print("숫자를 입력해주세요 : ");
        inputArr = new ArrayList<>();
        String input = Console.readLine();
        if (input.length() != 3) {
            throw new IllegalArgumentException("잘못된 자릿수의 수 입력");
        }

        for (int i = 0; i < 3; i++) {
            String substring = input.substring(i, i + 1);
            inputArr.add(Integer.parseInt(substring));
        }

    }

    public static void checkStrike(){
        for (int i = 0; i < 3; i++) {
            if (computer.get(i) == inputArr.get(i)) {
                strike++;
            }
        }
    }

    public static void checkBall() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    continue;
                }
                if (computer.get(i) == inputArr.get(j)) {
                    ball++;
                }
            }
        }
    }

    public static void isEnd(){
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return;
        }
    }

    public static void init() {
        computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }
}

