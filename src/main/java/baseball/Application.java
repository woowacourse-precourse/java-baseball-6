package baseball;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while(true) {

            playGame();

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String input = Console.readLine();
            // 1, 2 외의 글자 입력시 예외 처리
            if (!input.matches("^[1-2]{1}$")) {
                throw new IllegalArgumentException();
            }

            if ("2".equals(input)) {
                break;
            }
        }
    }

    private static void playGame() {
        List<Integer> computer = generateRandomNumber();

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();

            if (!isValidInput(input)) {
                throw new IllegalArgumentException();
            }

            int[] result = getResult(computer, input);

            printResult(result);

            if (result[0] == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }

        }
    }

    private static List<Integer> generateRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private static boolean isValidInput(String input) {
        return input.matches("^[1-9]{3}$") && !checkDuplicate(input);
    }

    private static boolean checkDuplicate(String input) {
        Set<Character> set = new HashSet<>();
        for (char c : input.toCharArray()) {
            if (!set.add(c)) {
                return true;
            }
        }
        return false;
    }

    private static int[] getResult(List<Integer> computer, String input) {
        // TODO : 가독성을 위해 HASHMAP 사용하기
        int[] result = new int[2]; // [0] : strike, [1] : ball
        for (int i=0; i < input.length(); i++) {
            char numChar = input.charAt(i);
            int num = Character.getNumericValue(numChar);
            if (num == computer.get(i)) {
                result[0]++;
            } else if (computer.contains(num)) {
                result[1]++;
            }
        }
        return result;
    }

    private static void printResult(int[] result) {
        if (result[0] == 0 && result[1] == 0) {
            System.out.println("낫싱");
        } else {
            String resultMessage = new String("");
            if (result[1] > 0) {
                resultMessage = result[1] + "볼";
            }
            if (result[0] > 0) {
                resultMessage += (resultMessage.isEmpty() ? "" : " ") + result[0] + "스트라이크";
            }
            System.out.println(resultMessage);
        }
    }
}
