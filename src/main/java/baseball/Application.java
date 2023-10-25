package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        while (true) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            Game();
            String gameState = new String();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            try {
                gameState = Console.readLine();
                if (Integer.parseInt(gameState) == 2) {
                    break;
                }
                else if (Integer.parseInt(gameState) != 1 && Integer.parseInt(gameState) != 2) {
                    throw new IllegalArgumentException();
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }


    }

    public static void Game() {
        // 1-9까지의 범위에서 랜덤의 서로 다른 수로 이루어진 3자리의 수 생성
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        // 게임 플레이어의 3자리 수 입력
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String playerNumber = Console.readLine();
            checkInputValue(playerNumber);
            int[] player = Stream.of(playerNumber.split("")).mapToInt(Integer::parseInt).toArray();
            int strike = 0, ball = 0;

            for (int i = 0; i < 3; i++) {
                if (player[i] == computer.get(i)) {
                    strike++;
                } else if (computer.contains(player[i])) {
                    ball++;
                }
            }
            if (strike == 0 && ball == 0) {
                System.out.print("낫싱");
            } else {
                if (ball > 0) {
                    System.out.print(ball + "볼 ");
                }
                if (strike > 0) {
                    System.out.print(strike + "스트라이크");
                }
            }
            System.out.println();

            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    static void checkInputValue(final String str) {
        if (!checkInputLength(str)) {
            throw new IllegalArgumentException();
        }
        if (!checkInputNumber(str)) {
            throw new IllegalArgumentException();
        }
        if (!checkEqualNumber(str)) {
            throw new IllegalArgumentException();
        }
    }

    static boolean checkInputLength(final String str) {
        return str.length() == 3;
    }

    static boolean checkInputNumber(String str) {
        try {
            int intValue = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return false;
        }
        char[] numberArray = str.toCharArray();
        return !checkArrayContains(numberArray, '0');
    }

    static boolean checkEqualNumber(String str) {
        int[] playerNumber = Stream.of(str.split("")).mapToInt(Integer::parseInt).toArray();
        List<Integer> player = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (!player.contains(playerNumber[i])) {
                player.add(playerNumber[i]);
            }
            else {
                return false;
            }
        }
        return true;
    }

    static boolean checkArrayContains(final char[] arr, final char number) {
        for (int value : arr) {
            if (value == number) {
                return true;
            }
        }
        return false;
    }
}