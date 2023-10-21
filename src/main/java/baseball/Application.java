package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        gameStart();
    }

    public static void gameStart() {
        Boolean gameStatus = Boolean.TRUE;
        PrintPackage.printGameStartMessage();
        while (gameStatus) {
            List<Integer> computer = InputClass.extractRandomNumber();
            System.out.println("computer = " + computer);
            compare(computer);
            gameStatus = gameRetry();
        }
    }

    private static Boolean gameRetry() {
        PrintPackage.printRegameMessage();
        String retry = Console.readLine();
        return checkRetry(retry);
    }

    private static Boolean checkRetry(String retry) {
        if (retry.equals("1")) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    private static void compare(List<Integer> computer) {
        Boolean correct = Boolean.FALSE;
        while (correct == Boolean.FALSE) {
            List<Integer> user = InputClass.inputUserNumber();
            Integer strikes = 0;
            Integer balls = 0;

            for (int i = 0; i < computer.size(); i++) {
                Integer computerNumber = computer.get(i);
                Integer userNumber = user.get(i);

                if (computerNumber.equals(userNumber)) {
                    strikes++;
                } else if (computer.contains(userNumber)) {
                    balls++;
                }
            }
            Status status = Status.getStatus(strikes, balls);
            PrintPackage.printResult(status.result);
            correct = (status == Status.CORRECT);
        }
    }

    public enum Status {
        NOTHING(0, 0, "낫싱"), BALL1(0, 1, "1볼"), BALL2(0, 2, "2볼"), BALL3(0, 3, "3볼"), STRIKE1(1, 0, "1스트라이크"), STRIKE2(
                2, 0, "2스트라이크"), BALL1_STRIKE1(1, 1, "1볼 1스트라이크"), BALL2_STRIKE1(1, 2, "2볼 1스트라이크"), CORRECT(3, 0,
                "3스트라이크");

        private Integer strike;
        private Integer ball;
        private String result;

        Status(Integer strike, Integer ball, String result) {
            this.strike = strike;
            this.ball = ball;
            this.result = result;
        }

        public static Status getStatus(Integer strike, Integer ball) {
            for (Status status : Status.values()) {
                if (status.strike.equals(strike) && status.ball.equals(ball)) {
                    return status;
                }
            }
            throw new RuntimeException();
        }
    }

    public class InputClass {

        static List<Integer> extractRandomNumber() {
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }
            return computer;
        }

        public static List<Integer> inputUserNumber() {
            PrintPackage.printRequestNumber();
            String readLine = Console.readLine();
            List<Integer> user = new ArrayList<>();
            for (int i = 0; i < readLine.length(); i++) {
                user.add(Character.getNumericValue(readLine.charAt(i)));
            }
            return user;
        }

    }

    public class PrintPackage {
        public static void printGameStartMessage() {
            System.out.println("숫자 야구 게임을 시작합니다.");
        }

        public static void printRequestNumber() {
            System.out.print("숫자를 입력해주세요 : ");
        }

        public static void printRegameMessage() {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        }

        public static void printResult(String results) {
            System.out.println(results);
        }
    }
}
