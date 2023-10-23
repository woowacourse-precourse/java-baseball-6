package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean game = true;
        while(game) {
            List<Integer> computer = createNumber();
            System.out.println(computer);
            List<Integer> userInputList = new ArrayList<>();

            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                String userInput = camp.nextstep.edu.missionutils.Console.readLine();
                userInputList = makeGuess(userInput);

                Judge judge = new Judge(computer, userInputList);
                judge.calcResult();
                judge.printResult();

                if(judge.isCorrect()) {
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    String restart = camp.nextstep.edu.missionutils.Console.readLine();
                    if (restart.equals("1")) {
                        break;
                    } else if (restart.equals("2")) {
                        game = false;
                        break;
                    } else {
                        throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
                    }
                }
            }
        }
    }

    public static boolean isValid(char c) {
        return c >= '1' && c <= '9';
    }

    public static List<Integer> createNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static List<Integer> makeGuess(String userInput) {
        if (userInput.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
        }
        for (int i = 0; i < userInput.length(); i++) {
            if (!isValid(userInput.charAt(i))) {
                throw new IllegalArgumentException("1~9 사이의 숫자만 입력해주세요.");
            }
        }
        List<Integer> userInputList = new ArrayList<>();
        for (int i = 0; i < userInput.length(); i++) {
            if (userInputList.contains(userInput.charAt(i) - '0')) {
                throw new IllegalArgumentException("중복되지 않은 숫자를 입력해주세요.");
            }
            userInputList.add(userInput.charAt(i) - '0');
        }
        return userInputList;
    }
}
