package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("숫자 야구 게임을 시작합니다.");
        playNumberBaseball();
    }


    private static void playNumberBaseball() {

        boolean continueGame = true;
        while (continueGame) {
            String computer = makeNum(); // 컴퓨터 3자리 수 생성
            System.out.println("computer = " + computer);

            while (true) {
                String number = predictNumber(); // 사용자 3자리 수 예측

                // 정답을 맞힌 경우
                if (computer.equals(number)) {

                    // 1 - 게임 계속 진행,  2 - 게임 종료
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
        Count result = checkStrikeAndBall(computer, number);

        if (result.strike() == 0 && result.ball() == 0) {
            System.out.println("낫싱");
        } else if (result.strike() > 0 && result.ball() == 0) {
            System.out.println(result.strike() + "스트라이크");
        } else if (result.strike() == 0 && result.ball() > 0) {
            System.out.println(result.ball() + "볼");
        } else if (result.strike() > 0 && result.ball() > 0) {
            System.out.println(result.ball() + "볼 " + result.strike() + "스트라이크");
        }
    }


    private static Count checkStrikeAndBall(String computer, String number) {
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
        Count result = new Count(strike, ball);
        return result;
    }
    private record Count(int strike, int ball) {
    }


    private static String getFinishCheck() throws IllegalArgumentException {
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String line = Console.readLine();

        checkException(line, 1);

        if (!line.equals("1") && !line.equals("2")) {
            throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
        }

        return line;
    }


    public static String predictNumber() throws IllegalArgumentException {
        System.out.print("숫자를 입력해주세요 : ");
        String line = Console.readLine();

        checkException(line, 3);

        if (duplicatedLine(line)) {
            throw new IllegalArgumentException("겹치는 않는 숫자를 입력해주세요.");
        }

        return line;
    }


    private static boolean duplicatedLine(String line) {
        List<String> list = new ArrayList<>(Arrays.asList(line.split("")));
        Set<String> set = new HashSet<>(list);

        if (list.size() > set.size()) {
            return true;
        }
        return false;
    }


    private static void checkException(String line, int numDigit) {
        if (line.isEmpty()) {
            throw new IllegalArgumentException("값을 입력해주세요.");
        }

        if (!line.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }

        if (line.length() != numDigit) {
            throw new IllegalArgumentException(numDigit + "자리 숫자를 입력해주세요.");
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