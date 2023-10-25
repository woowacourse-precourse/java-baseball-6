package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        gameStart();
    }

    // 게임을 시작하고 실행하는 함수
    private static void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            List<Integer> answer = generateAnswer();

            while (true) {
                System.out.print("3자리 숫자를 입력하세요: ");
                String input = Console.readLine();

                if (isValidInput(input)) {
                    List<Integer> userGuess = parseInput(input);
                    Map<String, Integer> result = checkAnswer(answer, userGuess);
                    printResult(result);

                    if (result.get("strike") == 3) {
                        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                        break;
                    }

                }
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String choice = Console.readLine();
            if (!choice.equals("1")) {
                break;
            }
        }
    }

    // 무작위로 1부터 9까지의 서로 다른 3자리 숫자를 생성
    private static List<Integer> generateAnswer() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
        return answer;
    }

    // 입력값이 유효한지 확인하고, 유효하지 않으면 예외 발생
    private static boolean isValidInput(String input) {
        // 3자리 숫자로 입력하지 않은 경우 에러발생
        if (input.length() != 3 || !input.matches("\\d{3}")) {
            throw new IllegalArgumentException();
        }

        // 서로 다른 세가지의 숫자가 아닐 경우 에러발생
        char[] digits = input.toCharArray();
        if (digits[0] == digits[1] || digits[1] == digits[2] || digits[0] == digits[2]) {
            throw new IllegalArgumentException();
        }

        return true;
    }


    // 사용자 입력 문자열을 3자리 숫자 리스트로 변환하여 반환
    private static List<Integer> parseInput(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            numbers.add(Character.getNumericValue(input.charAt(i)));
        }
        return numbers;
    }

    // 정답과 입력된 값을 비교하여 스트라이크와 볼 개수를 맵 형태로 반환
    private static Map<String, Integer> checkAnswer(List<Integer> answer, List<Integer> guess) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            if (guess.get(i).equals(answer.get(i))) {
                strike++;
            } else if (answer.contains(guess.get(i))) {
                ball++;
            }
        }

        Map<String, Integer> result = new HashMap<>();

        result.put("strike", strike);
        result.put("ball", ball);

        if (result.isEmpty()) {
            result.put("strike", 0);
            result.put("ball", 0);
        }

        return result;
    }

    // 결과 메세지 출력
    private static void printResult(Map<String, Integer> result) {
        int strike = result.get("strike");
        int ball = result.get("ball");

        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (strike > 0 && ball == 0) {
            System.out.println(strike + "스트라이크");
        } else if (ball > 0 && strike == 0) {
            System.out.println(ball + "볼");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }
}
