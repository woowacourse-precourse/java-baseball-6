package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("숫자 야구 게임을 시작합니다.");
        numberBaseball();
    }


    private static void numberBaseball() {

        boolean continueGame = true;
        while (continueGame) {
            String computer = makeNum();
            System.out.println("computer = " + computer);

            while (true) {
                String number = predictNumber();

                // 정답을 맞힌 경우
                if (computer.equals(number)) {
                    String finishCheck = getFinishCheck();

                    if (finishCheck.equals("1")) {
                        break;
                    } else if (finishCheck.equals("2")) {
                        continueGame = false;
                        break;
                    }
                }
                // 틀린 경우 힌트 제공
                else {
                    printHint(computer, number);
                }
            }
        }
    }

    private static void printHint(String computer, String number) {
        int strike = 0;
        int ball = 0;

        List<String> computers = Arrays.asList(computer.split(""));
        List<String> numbers = Arrays.asList(number.split(""));

        for (int i = 0; i < 3; i++) {
            if (computer.contains(numbers.get(i))) {
                if (computers.get(i).equals(numbers.get(i))) {
                    strike++;
                } else {
                    ball++;
                }
            }
        }

        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (strike > 0 && ball == 0) {
            System.out.println(strike + "스트라이크");
        } else if (strike == 0 && ball > 0) {
            System.out.println(ball + "볼");
        } else if (strike > 0 && ball > 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }


    private static String getFinishCheck() throws IllegalArgumentException {
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String result = Console.readLine();

        basicCheck(result);

        if (result.length() != 1) {
            throw new IllegalArgumentException("1자리 숫자를 입력해주세요");
        }
        return result;
    }


    public static String predictNumber() throws IllegalArgumentException {
        System.out.print("숫자를 입력해주세요 : ");
        String result = Console.readLine();

        basicCheck(result);

        if (result.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자를 입력해주세요");
        }

        return result;
    }


    private static void basicCheck(String result) {
        if (result.isEmpty()) {
            throw new IllegalArgumentException("값을 입력해주세요");
        }

        if (!result.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }
    }


    private static String makeNum() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}
