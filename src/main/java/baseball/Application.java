package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        boolean restartGame = true;

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (restartGame) {
            List<Integer> computerPlaceValue = getComputerPlaceValue();
            while (true) {
                System.out.println("숫자를 입력해주세요 : ");
                List<Integer> userPlaceValue = getUserPlaceValue(readLine());
                int strikeCnt = 0;
                int ball = 0;
                int i = 0;
                for (int computer : computerPlaceValue) {
                    int user = userPlaceValue.get(i);
                    if (computer == user) {
                        strikeCnt += 1;
                    } else if (userPlaceValue.contains(computer)) {
                        ball += 1;
                    }
                    i += 1;
                }
                if (strikeCnt == 0 && ball == 0) {
                    System.out.println("낫싱");
                } else if (strikeCnt == 0 && ball > 0) {
                    System.out.println(ball + "볼");
                } else if (strikeCnt < 3 && ball == 0) {
                    System.out.println(strikeCnt + "스트라이크");
                } else if (strikeCnt == 3) {
                    System.out.println(strikeCnt + "스트라이크");
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    String userChoice = readLine();
                    if (userChoice.equals("2")) {
                        restartGame = false;
                    }
                    break;
                } else {
                    System.out.println(ball + "볼 " + strikeCnt + "스트라이크");
                }

            }
        }

    }

    public static List<Integer> getUserPlaceValue(String userNumber) throws IllegalArgumentException {
        String regExp = "^[1-9]{3}$";
        List<Integer> placeValue = new ArrayList<>();
        List<Integer> prevNumber = new ArrayList<>();
        if (userNumber.matches(regExp)) {
            for (int i = 0; i < 3; i++) {
                char parseNumber = userNumber.charAt(i);
                int num = Character.getNumericValue(parseNumber);
                if (!prevNumber.contains(num)) {
                    placeValue.add(num);
                    prevNumber.add(num);
                } else {
                    throw new IllegalArgumentException();
                }
            }
        } else {
            throw new IllegalArgumentException();
        }
        return placeValue;
    }

    public static List<Integer> getComputerPlaceValue() {
        List<Integer> placeValue = new ArrayList<>();
        while (placeValue.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!placeValue.contains(randomNumber)) {
                placeValue.add(randomNumber);
            }
        }
        return placeValue;
    }
}