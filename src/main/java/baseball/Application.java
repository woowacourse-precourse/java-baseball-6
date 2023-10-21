package baseball;

import static baseball.Application.InputClass.extractRandomNumber;
import static baseball.Application.InputClass.inputUserNumber;
import static baseball.Application.PrintPackage.printRequestNumber;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        gameStart();
    }

    public static void gameStart() {
        PrintPackage.printGameStartMessage();
        Boolean gameStatus = Boolean.TRUE;
        List<Integer> computer = InputClass.extractRandomNumber();
        System.out.println("computer = " + computer);
        while (gameStatus) {
            Boolean compare = compare(computer, inputUserNumber());
            if (compare) {
                System.out.println("retry");
                System.out.println("regame?");
                String re = Console.readLine();

                if (re.equals("1")) {
                    gameStatus = Boolean.TRUE;
                    computer = extractRandomNumber();
                    System.out.println("computer = " + computer);
                } else if (re.equals("2")) {
                    System.out.println("2222");
                    gameStatus = Boolean.FALSE;
                } else {
                    System.out.println("error");
                }
            }
        }
    }

    private static Boolean compare(List<Integer> computer, List<Integer> user) {
        Integer strikes = 0;
        Integer balls = 0;

        for (Integer i = 0; i < computer.size(); i++) {
            Integer computerNumber = computer.get(i);
            Integer userNumber = user.get(i);

            if (Objects.equals(computerNumber, userNumber)) {
                strikes++;
            } else if (computer.contains(userNumber)) {
                balls++;
            }
        }

        Status status = Status.getStatus(strikes, balls);
        System.out.println(status.getResult());
        if (status.equals(Status.CORRECT)) {
            System.out.println("correct");
        }
        return status == Status.CORRECT;
    }

    public enum Status {
        NOTHING(0, 0, "낫싱"),
        BALL1(0, 1, "1볼"),
        BALL2(0, 2, "2볼"),
        BALL3(0, 3, "3볼"),
        STRIKE1(1, 0, "1스트라이크"),
        STRIKE2(2, 0, "2스트라이크"),
        BALL1_STRIKE1(1, 1, "1볼 1스트라이크"),
        BALL2_STRIKE1(1, 2, "2볼 1스트라이크"),
        CORRECT(3, 0, "3스트라이크");

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
            return null;
        }

        public String getResult() {
            return result;
        }
    }

    public class PrintPackage {
        public static void printGameStartMessage() {
            System.out.println("숫자 야구 게임을 시작합니다.");
        }

        public static void printRequestNumber() {
            System.out.print("숫자를 입력해주세요 : ");
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
            printRequestNumber();
            String readLine = Console.readLine();
            List<Integer> user = new ArrayList<>();
            for (int i = 0; i < readLine.length(); i++) {
                user.add(Character.getNumericValue(readLine.charAt(i)));
            }
            return user;
        }
    }
}
