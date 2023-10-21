package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Application {

    public static void startPhrase() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void inputPhrase() {
        System.out.print("숫자를 입력해 주세요 : ");
    }

    public static void answerPhrase() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void endPhrase() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static boolean isStrike(int a, int b) {
        return a == b;
    }

    public static boolean isBall(int a, int[] b) {
        for (int i = 0; i < 3; i++) {
            if (b[i] == a) {
                return true;
            }
        }
        return false;
    }

    public static void strikePhrase(int a) {
        System.out.println(a + "스트라이크");
    }

    public static void ballPhrase(int a) {
        System.out.println(a + "볼");
    }

    public static void ballAndStrikePhrase(int a, int b) {
        System.out.println(a + "볼 " + b + "스트라이크");
    }

    public static void outPhrase() {
        System.out.println("낫싱");
    }

    public static List<Integer> newNumber() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        List<Integer> answer = newNumber();

        startPhrase();

        while (true) {
            System.out.println(answer);
            inputPhrase();

            String userInput = Console.readLine();

            int[] userInputArray = Stream.of(userInput.split("")).mapToInt(Integer::parseInt).toArray();

            int ball = 0;
            int strike = 0;

            for (int i = 0; i < answer.size(); i++) {
                if (isStrike(answer.get(i), userInputArray[i])) {
                    strike++;
                } else if (isBall(answer.get(i), userInputArray)) {
                    ball++;
                }
            }

            if (ball + strike == 0) {
                outPhrase();
            } else if (strike == 3) {
                answerPhrase();
                endPhrase();
                userInput = Console.readLine();

                if (userInput.equals("1")) {
                    answer = newNumber();
                } else if (userInput.equals("2")) {
                    break;
                } else {
                    break;
                }
            } else if (ball != 0 && strike != 0) {
                ballAndStrikePhrase(ball, strike);
            } else if (strike != 0) {
                strikePhrase(strike);
            } else if (ball != 0) {
                ballPhrase(ball);
            }
        }
    }
}
