package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        String input = "1";
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (input.equals("1")) {
            startGame();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            input = Console.readLine();
        }
        System.out.println("게임을 종료합니다.");
    }

    public static void startGame() { //게임 시작
        List<Integer> computerNum = makeRandomNum();
        playGame(computerNum);
    }

    public static List<Integer> makeRandomNum() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static void playGame(List<Integer> computerNum) {
        while (true) {
            List<Integer> userNum = inputNum();
            int[] result = calculate(computerNum, userNum);
            printResult(result);
            if (result[0] == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    public static List<Integer> inputNum() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        if (input == null || input.length() != 3) {
            throw new IllegalArgumentException("3자리 수를 입력해 주세요.");
        }
        List<Integer> inputList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            char num = input.charAt(i);
            if (num < '1' || num > '9') {
                throw new IllegalArgumentException("1에서 9 사이의 숫자를 입력해 주세요.");
            }
            inputList.add(Character.getNumericValue(num));
        }

        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 3; j++) {
                if (inputList.get(i).equals(inputList.get(j))) {
                    throw new IllegalArgumentException("중복되지 않는 숫자를 입력해 주세요.");
                }
            }
        }
        return inputList;
    }


    public static int[] calculate(List<Integer> computerNum, List<Integer> playerNum) {
        int[] result = {0, 0};
        for (int i = 0; i < 3; i++) {
            int player = playerNum.get(i);
            for (int j = 0; j < 3; j++) {
                int computer = computerNum.get(j);
                if (player == computer) {
                    if (i == j) {
                        result[0]++;
                    } else {
                        result[1]++;
                    }
                }
            }
        }
        return result;
    }

    public static void printResult(int[] result) {
        if (result[0] == 0 && result[1] == 0) {
            System.out.print("낫싱");
        } else {
            if (result[1] > 0) {
                System.out.print(result[1] + "볼 ");
            }
            if (result[0] > 0) {
                System.out.print(result[0] + "스트라이크 ");
            }
        }
        System.out.println();
    }

}

