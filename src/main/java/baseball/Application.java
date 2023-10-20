package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

class ComputerNumbers {
    private final List<Integer> numbers;

    public ComputerNumbers() {
        this.numbers = generateNumbers();
    }

    private List<Integer> generateNumbers() {
        List<Integer> nums = new ArrayList<>();
        while (nums.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!nums.contains(randomNumber)) {
                nums.add(randomNumber);
            }
        }
        return nums;
    }

    public int[] compare(List<Integer> userNumbers) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < 3; i++) {
            int number = userNumbers.get(i);
            if (numbers.contains(number)) {
                if (numbers.get(i) == number) {
                    strikes++;
                } else {
                    balls++;
                }
            }
        }
        return new int[]{strikes, balls};
    }
}

class UserInput {
    private final List<Integer> numbers;

    public UserInput() {
        this.numbers = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        if (input.length() != 3) {
            throw new IllegalArgumentException("세 자리의 숫자를 입력해주세요.");
        }

        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c) || c == '0') {
                throw new IllegalArgumentException("1-9 사이의 숫자만 입력해주세요.");
            }

            int number = Character.getNumericValue(c);
            if (numbers.contains(number)) {
                throw new IllegalArgumentException("서로 다른 숫자를 입력해주세요.");
            }
            numbers.add(number);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}

public class Application {
    public static void main(String[] args) {
        while (true) {
            ComputerNumbers computerNumbers = new ComputerNumbers();
            System.out.println("숫자 야구 게임을 시작합니다.");
            while (true) {
                UserInput userInput = new UserInput();
                int[] result = computerNumbers.compare(userInput.getNumbers());

                int strikeCount = result[0];
                int ballCount = result[1];

                if (strikeCount == 0 && ballCount == 0) {
                    System.out.println("낫싱");
                } else if (strikeCount == 3) {
                    System.out.println("3스트라이크");
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                } else if (strikeCount == 0) {
                    System.out.println(ballCount + "볼");
                } else if (ballCount == 0) {
                    System.out.println(strikeCount + "스트라이크");
                } else {
                    System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
                }
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int restart = Integer.parseInt(Console.readLine());
            if (restart != 1 && restart != 2) {
                throw new IllegalArgumentException("1 또는 2만 입력해주세요.");
            }
            if (restart == 2) {
                break;
            }
        }
    }
}
