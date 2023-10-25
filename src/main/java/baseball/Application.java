package baseball;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        try {
            while (true) {
                Game game = new Game();
                game.start();

                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                int restart = Integer.parseInt(Console.readLine());

                if (restart != 1) {
                    break;
                }
            }
        }
        catch (IllegalArgumentException e) {
            System.out.println("입력 값이 잘못되었습니다. 프로그램을 종료합니다.");
        }
    }
}

class Game {
    private static final int MAX_NUM = 3;

    public void start() throws IllegalArgumentException{
        System.out.println("숫자 야구 게임을 시작합니다.");

        List<Integer> randomNumbers = generateComputerNumbers();

        while (true) {
            System.out.println("숫자를 입력해주세요 : ");
            String inputNumber = Console.readLine();
            List<Integer> inputNumbers = convertInput(inputNumber);
            String result = checkNumbers(randomNumbers, inputNumbers);
            System.out.println(result);

            if (isGameWon(result)) {
                break;
            }
        }
    }

    private List<Integer> generateComputerNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < MAX_NUM) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    List<Integer> convertInput(String input) {
        if (input.length() != MAX_NUM || !input.matches("[1-9]+")) {
            throw new IllegalArgumentException("1에서 9까지 3자리 숫자를 입력하세요");
        }

        List<Integer> numbers = new ArrayList<>();
        Set<Integer> numberSet = new HashSet<>();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            int number = Character.getNumericValue(ch);

            if (numberSet.contains(number)) {
                throw new IllegalArgumentException("중복된 숫자가 있습니다. 서로 다른 숫자를 입력하세요.");
            }

            numbers.add(number);
            numberSet.add(number);
        }
        return numbers;
    }

    private String checkNumbers(List<Integer> computer, List<Integer> user) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < MAX_NUM; i++) {
            if (user.get(i).equals(computer.get(i))) {
                strikes++;
            } else if (computer.contains(user.get(i))) {
                balls++;
            }
        }

        if (strikes == 0 && balls == 0) {
            return "낫싱";
        }

        if (strikes == 0) {
            return balls + "볼";
        }

        if (balls == 0) {
            return strikes + "스트라이크";
        }
        return balls + "볼 " + strikes + "스트라이크";
    }

    private boolean isGameWon(String result) {
        if (result.endsWith("3스트라이크")) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }
}
