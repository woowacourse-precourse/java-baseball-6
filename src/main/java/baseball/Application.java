package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    static class Result {
        private int strike;
        private int ball;

        public Result(int strike, int ball) {
            this.strike = strike;
            this.ball = ball;
        }

        public int getStrike() {
            return strike;
        }

        public int getBall() {
            return ball;
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            List<Integer> computerNumbers = selectComputerNumbers();
//            System.out.println(computerNumbers);

            while (true) {
                List<Integer> userNumbers = inputUserNumbers();
                Result result = getResultForUserNumbers(computerNumbers, userNumbers);
                printResult(result);

                if (correctAllNumbers(result)){
                    break;
                }
            }

            if (selectUserExit()) {
                break;
            }
        }
    }

    private static List<Integer> selectComputerNumbers() {
        List<Integer> computerNumbers = new ArrayList<>();

        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
        return computerNumbers;
    }

    private static List<Integer> inputUserNumbers() {
        List<Integer> userNumbers = new ArrayList<>();
        String userInput;

        System.out.print("숫자를 입력해주세요 : ");
        userInput = Console.readLine();

        for (int i = 0; i < userInput.length(); i++) {
            int number = userInput.charAt(i) - '0';
            userNumbers.add(number);
        }
        return userNumbers;
    }

    private static Result getResultForUserNumbers(List<Integer> computerNumbers, List<Integer> userNumbers) {
        int strike = 0;
        int ball = 0;

        for (int k = 0; k < userNumbers.size(); k++) {
            int userNumber = userNumbers.get(k);

            if (computerNumbers.get(k) == userNumber) {
                strike++;
            }
            else if (computerNumbers.contains(userNumber)) {
                ball++;
            }
        }
        return new Result(strike, ball);
    }

    private static void printResult(Result result) {
        int strikeCnt = result.getStrike();
        int ballCnt = result.getBall();

        if (strikeCnt == 0 && ballCnt == 0) {
            System.out.println("낫싱");
        }
        else {
            if (ballCnt > 0) {
                System.out.print(ballCnt + "볼 ");
            }

            if (strikeCnt > 0) {
                System.out.print(strikeCnt + "스트라이크");
            }
            System.out.println();
        }
        return;
    }

    private static boolean correctAllNumbers(Result result) {
        if (result.getStrike() == 3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }

    private static boolean selectUserExit() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = Console.readLine();

        if (userInput.equals("2")) {
            return true;
        }
        else {
            return false;
        }
    }
}
