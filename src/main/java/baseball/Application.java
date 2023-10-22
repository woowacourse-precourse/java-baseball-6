package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {

            // 서로 다른 수로 이루어진 3자리의 수
            int number1 = Randoms.pickNumberInRange(1, 9);
            int number2 = 0;
            int number3 = 0;

            while (true) {
                number2 = Randoms.pickNumberInRange(1, 9);
                if (number1 != number2) {
                    break;
                }
            }
            while (true) {
                number3 = Randoms.pickNumberInRange(1, 9);
                if (number1 != number3 && number2 != number3) {
                    break;
                }
            }

            Map<Integer, Integer> answerMap = new HashMap<>();
            answerMap.put(number1, 1);
            answerMap.put(number2, 2);
            answerMap.put(number3, 3);

            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                String input = Console.readLine();
                Map<Integer, Integer> inputMap = new HashMap<>();
                if (input.length() != 3) {
                    throw new IllegalArgumentException();
                } else {
                    for (int i = 0; i < 3; i++) {
                        if (!Character.isDigit(input.charAt(i)) || input.charAt(i) == '0') {
                            throw new IllegalArgumentException();
                        } else {
                            inputMap.put(Character.getNumericValue(input.charAt(i)), i + 1);
                        }
                    }
                }
                //입력, 정답 비교
                int strike = 0;
                int ball = 0;
                for (int i : inputMap.keySet()) {
                    if (answerMap.containsKey(i)) {
                        if (answerMap.get(i) == inputMap.get(i)) {
                            strike++;
                        } else {
                            ball++;
                        }
                    }
                }
                if (strike == 0 && ball == 0) {
                    System.out.println("낫싱");
                } else if (strike != 0 && ball == 0) {
                    System.out.println(strike + "스트라이크");
                } else if (strike == 0 && ball != 0) {
                    System.out.println(ball + "볼");
                } else {
                    System.out.println(ball + "볼" + " " + strike + "스트라이크");
                }
                if (strike == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String newGameYN = Console.readLine();
            if (newGameYN.length() != 1) {
                throw new IllegalArgumentException();
            } else {
                try {
                    if (Integer.parseInt(newGameYN) != 1 && Integer.parseInt(newGameYN) != 2) {
                        throw new IllegalArgumentException();
                    } else if (Integer.parseInt(newGameYN) == 2) {
                        return;
                    }
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException();
                }
            }
        }
    }
}
