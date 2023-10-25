package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Application {
    public static void main(String[] args) {
        int continueNum = 1;
        int offset = 1;
        int limit = 9;

        List<Integer> player = new ArrayList<>();
        List<Integer> computer = new ArrayList<>();

        while (continueNum == 1) {
            System.out.println("숫자 야구 게임을 시작합니다.");

            getComputerNum(offset, limit, computer);
            startGame(player, computer);

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            continueNum = getContinueNum();
            if (continueNum == 2) {
                break;
            }
        }
    }

    private static void startGame(List<Integer> player, List<Integer> computer) {
        while (true) {
            getPlayNum(player);

            int total, strike, ball = 0;

            total = getTotal(player, computer);
            strike = getStrike(player, computer);
            ball = total - strike;

            printScore(strike, ball);

            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    private static void getComputerNum(int offset, int limit, List<Integer> computer) {
        computer.clear();

        while (computer.size() < 3) {
            int randomNum = Randoms.pickNumberInRange(offset, limit);
            if (!computer.contains(randomNum)) {
                computer.add(randomNum);
            }
        }
    }

    private static void getPlayNum(List<Integer> player) {
        player.clear();

        System.out.print("숫자를 입력해 주세요 : ");
        String inputString = Console.readLine();

        if (inputString.length() != 3 || !isValidInteger(inputString)) {
            throw new IllegalArgumentException("잘못된 값 입니다");
        }

        for (int i = 0; i < inputString.length(); i++) {
            player.add(inputString.charAt(i) - '0');
        }
    }

    private static boolean isValidInteger(String inputString) {
        try {
            Integer.parseInt(inputString);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static int getTotal(List<Integer> player, List<Integer> computer) {
        return (int) IntStream.range(0, player.size())
                .filter(i -> computer.contains(player.get(i)))
                .count();
    }

    private static int getStrike(List<Integer> player, List<Integer> computer) {
        return (int) IntStream.range(0, player.size())
                .filter(i -> player.get(i).equals(computer.get(i)))
                .count();
    }

    private static void printScore(int strike, int ball) {
        if (strike > 0 && ball > 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
        if (strike > 0 && ball == 0) {
            System.out.println(strike + "스트라이크");
        }
        if (strike == 0 && ball > 0) {
            System.out.println(ball + "볼");
        }
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        }
    }

    private static int getContinueNum() {
        int inputNum = Console.readLine().charAt(0) - '0';
        if (inputNum != 1 && inputNum != 2) {
            throw new IllegalArgumentException("잘못된 값 입니다");
        }
        return inputNum;
    }
}