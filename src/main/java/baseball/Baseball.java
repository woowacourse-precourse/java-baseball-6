package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Baseball {

    //랜덤값 생성 ex. 외부참조 하는가? private or 그 외
    //변수명을 명확하게, 변수명을 고민했는가? -> 디테일


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


    //메서드명이 중위적, 명확한 기능
    //이름을 고치든, 함수를 쪼개든
    //하나의 기능만 구현
    public static void playBaseball() {
        List<Integer> computer = generateRandom();
        compareNumber(computer);
    }

    private static void compareNumber(List<Integer> computer) {
        int strikeCount = 0;
        int ballCount = 0;
        while (strikeCount != 3) {
            String user = getUserNum();
            handleException(user); //여기서 catch 처리, logger로 처리
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
        Application.LOG.info("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    private static boolean countingBall(int strike, int ball) {
        if (strike == 3) {
            Application.LOG.info("3스트라이크");
            Application.LOG.info("3개의 숫자를 모두 맞추셨습니다! 게임 종료");
            return true;
        }
        if (strike == 0 && ball == 0) {
            Application.LOG.info("낫싱");
        }
        if (strike != 0 && ball != 0) {
            Application.LOG.info(ball + "볼 " + strike + "스트라이크");
        }
        return false;
    }

    //try-catch, catch를 했는지, 에러 처리 handleException에서 처리
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


