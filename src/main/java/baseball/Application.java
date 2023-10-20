package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Application {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static List<Integer> computer;
    private static List<Integer> user;
    private static int strike = 0;
    private static int ball = 0;

    public static void main(String[] args) {
        try {
            boolean successFlag;
            boolean continueFlag = true;
            startBaseballGame();
            while (continueFlag) {
                successFlag = false;
                createComputerNumber();
                while (!successFlag) {
                    inputUserNumber();
                    compareNumbers();
                    successFlag = printResult();
                }
                continueFlag = inputContinueOrExit();
            }
            bw.close();
        } catch (IOException e1) {
            System.err.println("입출력 오류: " + e1.getMessage());
        } catch (IllegalArgumentException e2) {
            System.err.println("잘못된 입력: " + e2.getMessage());
        }
    }

    public static void startBaseballGame() throws IOException{
        bw.write("숫자 야구 게임을 시작합니다.\n");
        bw.flush();
    }

    public static void createComputerNumber() {
        computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    public static void inputUserNumber() throws IOException {
        bw.write("숫자를 입력해주세요 : ");
        bw.flush();
        String inputNumber = br.readLine();
        if (inputNumber.length() != 3) {
            throw new IllegalArgumentException("세 자리가 아닙니다.");
        }

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if (i == j) continue;
                if (inputNumber.charAt(i) == inputNumber.charAt(j)) {
                    throw new IllegalArgumentException("서로 다른 세 자리의 수가 아닙니다.");
                }
            }
        }

        user = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            char digit = inputNumber.charAt(i);
            if (!(digit >= '0' && digit <= '9')) {
                throw new IllegalArgumentException("숫자가 아닙니다.");
            }
            int number = digit - '0';
            user.add(number);
        }
    }

    public static void compareNumbers() {
        strike = 0;
        ball = 0;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if (computer.get(i) != user.get(j)) continue;
                if (i == j) {
                    strike += 1;
                } else if (i != j) {
                    ball += 1;
                }
            }
        }
    }

    public static boolean printResult() throws IOException {
        boolean successFlag = false;
        String message;
        if (strike == 3) {
            successFlag = true;
            message = String.format("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
        } else if (strike == 0 && ball == 0) {
            message = String.format("낫싱\n");
        } else if (strike == 0) {
            message = String.format("%d볼\n", ball);
        } else if (ball == 0) {
            message = String.format("%d스트라이크\n", strike);
        } else {
            message = String.format("%d볼 %d스트라이크\n", ball, strike);
        }
        bw.write(message);
        bw.flush();
        return successFlag;
    }

    public static boolean inputContinueOrExit() throws IOException {
        bw.write("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
        bw.flush();
        String inputNumber = br.readLine();
        if (!inputNumber.equals("1") && !inputNumber.equals("2")) {
            throw new IllegalArgumentException("1 또는 2가 아닙니다.");
        }
        if (inputNumber.equals("1")) {
            return true;
        }
        return false;
    }
}
