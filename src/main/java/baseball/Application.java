package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        playBaseBallGame();
    }
    public static void playBaseBallGame() {
        List<Integer> resultNumbers = generateRandomNumbers();

        int ball = 0;
        int strike = 0;

        while (strike != 3) {
            List<Integer> userNumbers = getUserNumbers();

            for (int i = 0; i < 3; i++) {
                if (resultNumbers.get(i).equals(userNumbers.get(i))) {
                    strike++;
                } else if (resultNumbers.contains(userNumbers.get(i))) {
                    ball++;
                }
            }

            if (ball > 0 && strike > 0) {
                System.out.println(ball + "볼 " + strike + "스트라이크");
            } else if (ball > 0) {
                System.out.println(ball + "볼");
            } else if (strike > 0) {
                System.out.println(strike + "스트라이크");
            } else {
                System.out.println("낫싱");
            }

            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                String restart = Console.readLine();
                if (restart.equals("1")){
                    playBaseBallGame();
                    return;
                }
                if (restart.equals("2")) {
                    Console.close();
                    return;
                }
                throw new IllegalArgumentException("종료에러");
            }

            ball = 0;
            strike = 0;
        }

    }

    public static List<Integer> generateRandomNumbers() {
        List<Integer> results = new ArrayList<>();

        while (results.size() < 3) {
            int tempNumber = Randoms.pickNumberInRange(1, 9);
            if (!results.contains(tempNumber)) {
                results.add(tempNumber);
            }
        }

        return results;
    }

    public static List<Integer> getUserNumbers() {
        List<Integer> results = new ArrayList<>();

        System.out.print("숫자를 입력해주세요 : ");
        String userInputValue = Console.readLine();

        // 입력값 숫자 3개인지 체크
        int userInputLength = userInputValue.length();
        if (userInputLength != 3) {
            throw new IllegalArgumentException("숫자 3개만 입력 필요");
        }

        for (int i = 0; i < userInputLength; i++) {
            char temp = userInputValue.charAt(i);
            int parsedTemp = Character.getNumericValue(temp);

            // 입력값 중복되는지 체크
            if (results.contains(parsedTemp)) {
                throw new IllegalArgumentException("숫자 중복 에러");
            }
            results.add(parsedTemp);
        }

        return results;
    }
}
