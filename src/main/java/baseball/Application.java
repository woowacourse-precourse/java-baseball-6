package baseball;

import camp.nextstep.edu.missionutils.*;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        int keepGoing = 1;
        int strike = 0;
        List<Integer> computer = new ArrayList<>();

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (keepGoing == 1) {
            // Get Computer Data
            computer = getCompGameData();

            // Start Baseball Game
            while (strike < 3) {
                strike = doBaseballGame(computer);
            }

            // Check Restart or Not
            printRestart();

            keepGoing = checkKeepGoing(isInt(Console.readLine()));
            strike = 0;
        }
        return;
    }

    public static void printBall(int ball) {
        if (ball > 0) {
            System.out.print(ball + "볼 ");
        }
    }

    public static int printStrike(int strike) {
        if (strike > 0) {
            System.out.println(strike + "스트라이크 ");
            return strike;
        } else {
            return -1;
        }
    }

    public static void printRestart() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static void printNothing(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        }
    }

    public static int checkKeepGoing(int keepGoing) {
        if (keepGoing == 1) {
            return 1;
        } else if (keepGoing == 2) {
            return 2;
        } else {
            System.out.println("값이 유효하지 않습니다. 프로그램을 종료합니다.");
            throw new IllegalArgumentException();
        }
    }

    public static int isInt(String toCheck) {
        int ret;
        try {
            ret = Integer.parseInt(toCheck);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }
        return ret;
    }

    public static void isUserDataValidate(int userData) {
        if (userData < 100) {
            throw new IllegalArgumentException();
        }
        if (userData > 1000) {
            throw new IllegalArgumentException();
        }
    }

    /*
     * @return Random Computer Data
     */
    public static List<Integer> getCompGameData() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    /*
     * @return User Input Data
     */
    public static List<Integer> getUserGameData() {
        int userInput;
        List<Integer> user = new ArrayList<Integer>();

        System.out.print("숫자를 입력해주세요 : ");

        // Check If Input Data has 3 Numbers, and Only Includes Integer
        userInput = isInt(Console.readLine());
        isUserDataValidate(userInput);

        user.add(userInput / 100);
        user.add(userInput % 100 / 10);
        user.add(userInput % 10);

        return user;
    }

    public static int countStrike(List<Integer> computer, List<Integer> user) {
        int ret = 0;
        for (int i = 0; i < 3; i++) {
            if (computer.get(i).equals(user.get(i))) {
                ret++;
            }
        }
        return ret;
    }

    public static int countBall(List<Integer> computer, List<Integer> user) {
        int ret = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != j) {
                    if (user.get(i).equals(computer.get(j))) {
                        ret++;
                    }
                }
            }
        }
        return ret;
    }

    /*
     * @return [number of Balls, number of Strikes]
     */
    public static List<Integer> compareData(List<Integer> computer, List<Integer> user) {
        List<Integer> ballStrike = new ArrayList<>();

        ballStrike.add(countBall(computer, user));
        ballStrike.add(countStrike(computer, user));

        return ballStrike;
    }

    public static int doBaseballGame(List<Integer> computer) {
        // Get user Data
        List<Integer> user = getUserGameData();
        List<Integer> result = new ArrayList<>();
        int numOfBall;
        int numOfStrike;

        result = compareData(computer, user);
        numOfBall = result.get(0);
        numOfStrike = result.get(1);

        // for no ball and no strike
        printNothing(numOfBall, numOfStrike);

        // for with strike
        printBall(numOfBall);
        return printStrike(numOfStrike);
    }
}