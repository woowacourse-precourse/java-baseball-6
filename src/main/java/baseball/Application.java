package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

class GameNumber {
    private final List<Integer> numbers;

    public GameNumber(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        List<Integer> compare = new ArrayList<>();
        for (Integer number: numbers) {
            if (compare.contains(number)) {
                throw new IllegalArgumentException();
            }
            compare.add(number);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}


public class Application {

    static GameNumber pickComputerNumber() {
        List<Integer> computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
        return new GameNumber(computerNumbers);
    }

    static int parseInt(String target) {
        try {
            return Integer.parseInt(target);
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    static List<Integer> convertUserInput(String input) {
        List<Integer> user = new ArrayList<>();
        String[] numbers = input.split("");
        for (String element: numbers) {
            int number = parseInt(element);
            user.add(number);
        }
        return user;
    }

    static GameNumber readUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        List<Integer> userNumbers = convertUserInput(input);
        return new GameNumber(userNumbers);
    }

    static void play() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        GameNumber computer = pickComputerNumber();
        GameNumber user = readUserNumber();
    }


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        play();
    }
}
