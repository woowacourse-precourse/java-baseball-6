package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static List<Integer> getRandomNum() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
        return answer;
    }
    public static boolean isValid(char[] num) {
        // 1. 3자리 char
        if (num.length != 3) {
            return false;
        }
        // 2. 모두 다른 숫자
        if (num[0] == num[1] || num[1] == num[2] || num[0] == num[2]) {
            return false;
        }
        // 3. 3자리가 모두 1~9 정수
        for (int i = 0; i < 3; i++) {
            if (!(Character.isDigit(num[i]) && Character.getNumericValue(num[i]) != 0)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Scanner scanner = new Scanner(System.in);

        // 랜덤 숫자 결정 (정답)
        List<Integer> answer = getRandomNum();

        // 게임 시작
        Boolean runGame = true;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (runGame) {
            System.out.print("숫자를 입력해주세요 : ");
            String userInput = scanner.nextLine();
            char[] userInputArray = userInput.toCharArray();

            // 입력값 유효성 검사
            if (!isValid(userInputArray)) {
                throw new IllegalArgumentException();
            }

            // 스트라이크/볼 개수 검사
            int strike = 0;
            int ball = 0;
            for (int i = 0; i < 3; i++) {
                int num = Character.getNumericValue(userInputArray[i]);
                if (num == answer.get(i)) {
                    strike++;
                } else if (num == answer.get((i + 1) % 3) || num == answer.get((i + 2) % 3)) {
                    ball++;
                }
            }

            // 결과 출력
            if (strike == 0 && ball == 0) {
                System.out.println("낫싱");
            } else if (strike == 0) {
                System.out.println(ball + "볼");
            } else if (ball == 0) {
                System.out.println(strike + "스트라이크");
                // case 정답인 경우
                if (strike == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    while (runGame) {
                        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                        String continueCode = scanner.nextLine();
                        if (continueCode.equals("1")) {
                            answer = getRandomNum();
                            break;
                        }
                        else if (continueCode.equals("2")) {
                            runGame = false;
                            break;
                        }
                    }
                }
            } else {
                System.out.println(ball + "볼 " + strike + "스트라이크");
            }
        }
    }
}
