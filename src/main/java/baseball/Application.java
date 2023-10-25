package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Application NumberBaseball = new Application();
        NumberBaseball.start();
    }

    private void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean isGameRunning = true;
        while (isGameRunning) {
            List<Integer> computer = generateRandomNumber();
            play(computer);
            isGameRunning = getRestartOrExit();
        }
        Console.close();
    }

    private List<Integer> generateRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private void play(List<Integer> computer) {
        int strike = 0;
        while (strike < 3) {
            List<Integer> player = getPlayerNumber();
            int[] result = calculateResult(computer, player);
            printResult(result);
            strike = result[0];
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private List<Integer> getPlayerNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        return validatePlayerNumber(input);
    }

    private List<Integer> validatePlayerNumber(String input) {
        isThreeDigits(input);
        isInRangeOneToNine(input);
        return hasUniqueNumber(input);
    }

    private void isThreeDigits(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("3자리가 아닙니다.");
        }
    }

    private void isInRangeOneToNine(String input) {
        if (!input.matches("[1-9]+")) {
            throw new IllegalArgumentException("1에서 9 사이의 숫자가 아닙니다.");
        }
    }

    private List<Integer> hasUniqueNumber(String input) {
        List<Integer> player = new ArrayList<>();
        for (char c : input.toCharArray()) {
            int playerNumber = Character.getNumericValue(c);
            if (player.contains(playerNumber)) {
                throw new IllegalArgumentException("서로 다르지 않습니다.");
            }
            player.add(playerNumber);
        }
        return player;
    }

    private int[] calculateResult(List<Integer> computer, List<Integer> player) {
        int[] result = new int[2]; //[strike, ball]
        for (int i = 0; i < player.size(); i++) {
            if (player.get(i).equals(computer.get(i))) {
                result[0]++;
            } else if (computer.contains(player.get(i))) {
                result[1]++;
            }
        }
        return result;
    }

    private void printResult(int[] result) {
        int strike = result[0];
        int ball = result[1];
        if (strike == 0 && ball == 0) {
            System.out.print("낫싱");
        }
        if (ball != 0) {
            System.out.print(ball + "볼 ");
        }
        if (strike != 0) {
            System.out.print(strike + "스트라이크");
        }
        System.out.println();
    }

    private boolean getRestartOrExit() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if (!input.equals("1") && !input.equals("2")) {
            throw new IllegalArgumentException("1과 2 중 하나의 수여야 합니다.");
        }
        return input.equals("1");
    }
}
