package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        while(true) {
            // 1. 숫자 랜덤 생성
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }

            boolean checkList = true;

            while (true) {
                Set<Character> uniqueNum = new HashSet<>();
                int strike = 0;
                int ball = 0;
                boolean nothing = false;
                // 2. 사용자 입력값 검사
                System.out.print("숫자를 입력해주세요 : ");
                String input = Console.readLine();

                if (input.trim().isEmpty() || input.length() != 3) {
                    checkList = false;
                } else {
                    for (char num : input.toCharArray()) {
                        if (num < '1' || num > '9' || !uniqueNum.add(num)) {
                            checkList = false;
                        }
                    }
                }

                if (!checkList) {
                    throw new IllegalArgumentException();
                }

                List<Integer> inputlist = new ArrayList<>();
                for (int i = 0; i < input.length(); i++) {
                    char c = input.charAt(i);
                    int digit = Character.getNumericValue(c);
                    inputlist.add(digit);
                }

                // 3. 사용자 입력 정답 검사
                for (int i = 0; i < 3; i++) {
                    for (int n = 0; n < 3; n++) {
                        if (computer.get(n) == inputlist.get(i) && n == i) {
                            strike++;
                            continue;
                        }
                        if (computer.get(n) == inputlist.get(i)) {
                            ball++;
                        }

                    }
                }

                if (strike == 0 && ball == 0) {
                    nothing = true;
                    System.out.println("낫싱");
                } else {
                    if (ball == 0 && strike != 0) {
                        System.out.println(strike + "스트라이크");
                    } else if (strike == 0 && ball != 0) {
                        System.out.println(ball + "볼");
                    } else {
                        System.out.println(ball + "볼 " + strike + "스트라이크");
                    }
                }

                if (strike == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    break;
                }
            } //두 번째 while문
            String input = Console.readLine();

            if(input.equals("1")){
                continue;
            } else if (input.equals("2")) {
                break;
            } else {
                throw new IllegalArgumentException();
            }

        } //첫 번째 while문
    }
}
