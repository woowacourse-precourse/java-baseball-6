package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class GameProcess {
    private static List<Integer> input;
    private static Implementation implementation = new Implementation();
    public List<Integer> getInput() {
        return input;
    }

    Computer computer1 = new Computer();
    public static void process() {

        input = new ArrayList<>();
        String num;
        int start_or_exit;
        Implementation implementation1 = new Implementation();
        Computer computer1 = new Computer();
        List<Integer> computerNumbers = computer1.generateRandomNumbers();
        while (true) {
            try {
                System.out.print("숫자를 입력해주세요 : ");
                num = Console.readLine();
                System.out.println(num.length());
                if (num.length() != 3) {
                    throw new IllegalArgumentException("입력된 숫자는 3자리가 아닙니다.");
                }
                input.clear();

                for (int i = 0; i < 3; i++) {
                    char digitChar = num.charAt(i); // 문자열 num에서 인덱스 i에 있는 문자를 가져와 digitChar 변수에 저장
                    String digitStr = String.valueOf(digitChar); // 문자 digitChar를 문자열로 반환하여 digitStr 변수에 저장
                    try {
                        int digit = Integer.parseInt(digitStr); // 문자열 digitStr을 정수로 변환하여 digit 변수에 저장
                        if (!(1<=digit && digit <= 9)) {
                            throw new IllegalAccessException("입력된 숫자는 1부터 9사이의 정수가 아닙니다");
                        }
                        input.add(digit); // 변환된 숫자 digit를 리스트 input에 추가
                    } catch (NumberFormatException e) {
                        System.out.println("숫자로 변환할 수 없는 값이 입력되었습니다");
                    }
                }

                Set<Integer> inputset = new HashSet<>(input);
                if (inputset.size() != input.size()) {
                    throw new IllegalAccessException("입력된 숫자에는 중복된 숫자가 포함되어 있습니다.");
                }

                if (input.get(0) == input.get(1) || input.get(1) == input.get(2) || input.get(0) == input.get(2)) {
                    throw new IllegalAccessException("입력된 숫자는 서로 다른 3자리 수가 아닙니다.");
                }
                int strike = implementation.countStrike(computerNumbers, input);
                int ball = implementation.countBall(computerNumbers, input);

                if (strike == 3) { // Implementation 함수로 들어가서 3개 다 맞췄다면
                    System.out.println("3스트라이크");
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    start_or_exit = Integer.parseInt(Console.readLine()); // 재시작과 종료를 구분하는 수를 입력 받고
                        if (start_or_exit == 2) { // 2일경우 게임 종료
                            break;
                        } else if (start_or_exit == 1) { // 1일 경우 게임 다시 시작
                            computerNumbers = computer1.generateRandomNumbers(); //2
                            continue;
                        }
                } else {
                    if (ball != 0) {
                        System.out.print(ball + "볼 ");
                    }
                    if (strike != 0) {
                        System.out.print(strike + "스트라이크");
                    }
                    if (ball == 0 && strike == 0) {
                        System.out.print("낫싱");
                    }
                    System.out.println();
                }

            } catch(IllegalAccessException e) {
                System.out.println(e.getMessage());
                break;
            }
        }
    }
}