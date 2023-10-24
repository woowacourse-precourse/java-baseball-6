package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        boolean playGame = true;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (playGame) {
            List<Integer> computer = generateRandomNumber();
            List<Integer> player = getPlayerInput();
            int strikeCount = countStrikes(computer, player);
            while (strikeCount < 3) {
                String output = generateOutput(computer, player);
                System.out.println(output);
                player = getPlayerInput();
                strikeCount = countStrikes(computer, player);
            }
            if (strikeCount == 3) {
                System.out.println("3스트라이크");
                playGame = restartGame();
            }
        }
    }

    public static List<Integer> generateRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static List<Integer> getPlayerInput() {
        List<Integer> player = new ArrayList<>();
        System.out.println("숫자를 입력해주세요:");
        String input = Console.readLine();
        if (input.length() != 3) {
            throw new IllegalArgumentException("3개의 숫자를 입력해야 합니다.");
        }
        for (String my : input.split("")) {
            int num = Integer.parseInt(my);
            if (num < 1 || num > 9) {
                throw new IllegalArgumentException("입력 범위를 벗어난 숫자입니다.");
            }
            if (player.contains(num)) {
                throw new IllegalArgumentException("중복된 숫자를 입력했습니다.");
            }
            player.add(num);
        }
        return player;
    }

    public static int countStrikes(List<Integer> computer, List<Integer> player) {
        int strike = 0;
        for (int i = 0; i < player.size(); i++) {
            if (computer.get(i).equals(player.get(i))){
                strike++;
            }
        }
        return strike;
    }

    public static String generateOutput(List<Integer> computer, List<Integer> player) {
        int total = 0;
        int strike = countStrikes(computer, player);
        for (Integer my : player) {
            if (computer.contains(my)) {
                total++;
            }
        }
        int ball = total - strike;
        if (total == 0) {
            return "낫싱";
        } else if (strike == 0) {
            return ball + "볼";
        } else if (ball == 0) {
            return strike + "스트라이크";
        }
        return ball + "볼 " + strike + "스트라이크";
    }

    private static boolean restartGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        char reset = input.charAt(0);
        if (reset == '1') {
            return true;
        } else if (reset == '2') {
            return false;
        } else {
            throw new IllegalArgumentException("유효하지 않은 입력입니다. 1 또는 2 만 입력해야 합니다.");
        }
    }
}
