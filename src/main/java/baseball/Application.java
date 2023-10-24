package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            List<Integer> computerNumbers = generateRandomNumbers();
            System.out.println("컴퓨터가 숫자를 정했습니다.");

            int attempts = 0;
            while (true) {
                System.out.print("세 자리 숫자를 입력하세요: ");
                String input = Console.readLine();
                if (!isValidInput(input)) {
                    System.out.println("잘못된 입력입니다. 1부터 9까지의 서로 다른 숫자를 입력하세요.");
                    continue;
                }

                List<Integer> userNumbers = parseInput(input);
                Result result = calculateResult(computerNumbers, userNumbers);
                System.out.println(result.toString());

                if (result.is3Strikes()) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }

                attempts++;
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String choice = Console.readLine();
            if (!choice.equals("1")) {
                break;
            }
        }

        System.out.println("게임을 종료합니다.");
        Console.close();
    }

    private static List<Integer> generateRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int num = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(num)) {
                numbers.add(num);
            }
        }
        return numbers;
    }

    private static boolean isValidInput(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("입력 길이는 3이어야 합니다.");
        }
        for (char digit : input.toCharArray()) {
            if (digit < '1' || digit > '9') {
                throw new IllegalArgumentException("1부터 9까지의 숫자를 입력해야 합니다.");
            }
        }
        if (!areDigitsUnique(input)) {
            throw new IllegalArgumentException("서로 다른 숫자를 입력해야 합니다.");
        }
        return true;
    }


    private static boolean areDigitsUnique(String input) {
        return input.chars().distinct().count() == 3;
    }

    private static List<Integer> parseInput(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (char digit : input.toCharArray()) {
            numbers.add(Character.getNumericValue(digit));
        }
        return numbers;
    }

    private static Result calculateResult(List<Integer> computerNumbers, List<Integer> userNumbers) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < 3; i++) {
            int computerDigit = computerNumbers.get(i);
            int userDigit = userNumbers.get(i);

            if (computerDigit == userDigit) {
                strikes++;
            } else if (computerNumbers.contains(userDigit)) {
                balls++;
            }
        }

        return new Result(strikes, balls);
    }
}


class Result {
    private int strikes;
    private int balls;

    public Result(int strikes, int balls) {
        this.strikes = strikes;
        this.balls = balls;
    }

    public boolean is3Strikes() {
        return strikes == 3;
    }

    @Override
    public String toString() {
        if (strikes > 0 && balls > 0) {
            return balls + "볼 " + strikes + "스트라이크";
        } else if (strikes > 0) {
            return strikes + "스트라이크";
        } else if (balls > 0) {
            return balls + "볼";
        } else {
            return "낫싱";
        }
    }
}

