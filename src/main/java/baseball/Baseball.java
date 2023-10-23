package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Baseball {
    private static List<Integer> generateRandom() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static void playBaseball() {
        List<Integer> computer = generateRandom();
        compareNumber(computer);
    }

    private static void compareNumber(List<Integer> computer) {
        int strikeCount = 0;
        int ballCount = 0;
        while (strikeCount != 3) {
            String user = getUserNum();
            handleException(user);
            strikeCount = 0;
            ballCount = 0;
            for (int computerNum = 0; computerNum < 3; computerNum++) {
                for (int userNum = 0; userNum < 3; userNum++) {
                    if (computer.get(computerNum) == Integer.parseInt(String.valueOf(user.charAt(userNum)))) {
                        if (computerNum == userNum) {
                            strikeCount++;
                        } else {
                            ballCount++;
                        }
                    }
                }
            }
            if (countingBall(strikeCount, ballCount)) {
                break;
            }
        }
    }

    private static String getUserNum() {
        System.out.println("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    private static boolean countingBall(int strike, int ball) {
        if (strike == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞추셨습니다! 게임 종료");
            return true;
        }
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        }
        if (strike != 0 || ball != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
        return false;
    }
    
    private static void handleException(String user) {
        if (user.length() != 3) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < 3; i++) {
            if (!Character.isDigit(user.charAt(i))) {
                throw new IllegalArgumentException();
            }
        }
        for (int j = 0; j < 2; j++) {
            if (user.charAt(j) == user.charAt(2)) {
                throw new IllegalArgumentException();
            }
            if (j == 1 && user.charAt(j) == user.charAt(0)) {
                throw new IllegalArgumentException();
            }
        }
    }
}


