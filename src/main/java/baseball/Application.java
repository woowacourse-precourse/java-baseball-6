package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Application {
    private static final int NUMBER_LENGTH = 3;

    public static void main(String[] args) {
        ArrayList<Integer> computer = new ArrayList<>();
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            computer = ranNumber();
            boolean gameEndFlag = false;

            while (!gameEndFlag) {
                ArrayList<Integer> playerNumbers = userInput();
                playGame(computer, playerNumbers);

                if (isGameEnd(playerNumbers, computer)) {
                    gameEndFlag = true;
                }
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String choice = Console.readLine();
            if (choice.equals("1")) {
                System.out.println("숫자 야구 게임을 다시 시작합니다.");
                continue;
            } else if (choice.equals("2")) {
                break;
            } else {
                System.out.println("잘못된 입력입니다. 1 혹은 2를 입력하세요.");
            }
        }
    }

    public static ArrayList<Integer> ranNumber() {
        ArrayList<Integer> randomNumArray = new ArrayList<>();

        while (randomNumArray.size() != 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!randomNumArray.contains(randomNumber)) {
                randomNumArray.add(randomNumber);
            }
        }

        return randomNumArray;
    }

    public static ArrayList<Integer> userInput() {
        System.out.print("숫자를 입력해주세요 : ");

        String playerInputString = Console.readLine();
        ArrayList<Integer> playerInputArray = new ArrayList<>();
        char[] playerInputCharArray = playerInputString.toCharArray();

        int[] dupTestArr = new int[10];
        boolean errorFlag = false;

        for (char playerInputChar : playerInputCharArray) {
            int inputDigit = Character.getNumericValue(playerInputChar);

            if (dupTestArr[inputDigit] != 0) {
                errorFlag = true;
                break;
            }
            dupTestArr[inputDigit]++;

            playerInputArray.add(inputDigit);
        }

        if (playerInputString.length() != 3) {
            errorFlag = true;
        }

        if (errorFlag) {
            throw new IllegalArgumentException("유효하지 않은 입력입니다. " +
                    "서로 다른 수로 이루어진 3자리의 수를 입력하세요.");
        }

        return playerInputArray;
    }

    private static void playGame(ArrayList<Integer> computerNumbers, ArrayList<Integer> playerNumbers) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (computerNumbers.get(i).equals(playerNumbers.get(i))) {
                strikes++;
            } else if (playerNumbers.contains(computerNumbers.get(i))) {
                balls++;
            }
        }

        if (strikes == 0 && balls == 0) {
            System.out.println("낫싱");
        } else {
            System.out.println(balls + "볼 " + strikes + "스트라이크");
        }
    }

    private static boolean isGameEnd(ArrayList<Integer> playerNumbers, ArrayList<Integer> computerNumbers) {
        int strikes = 0;

        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (computerNumbers.get(i).equals(playerNumbers.get(i))) {
                strikes++;
            }
        }

        if (strikes == NUMBER_LENGTH) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }
}
