package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Application {
    private static final int NUMBER_LENGTH = 3;

    public static void main(String[] args) {
        ArrayList<Integer> computer = new ArrayList<>();
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            // 컴퓨터가 정한 랜덤한 3자리 숫자를 정합니다.
            computer = ranNumber();
            //게임 다시 시작하기 위한 코드
            boolean gameEndFlag = false;

            // 플레이어의 입력을 받고 게임을 진행합니다.
            while (!gameEndFlag) {
                ArrayList<Integer> playerNumbers = userInput();
                playGame(computer, playerNumbers);

                // 게임이 종료되었는지 여부를 확인합니다.
                if (isGameEnd(playerNumbers, computer)) {
                    gameEndFlag = true;
                }
            }

            // 게임을 다시 시작할지 종료할지 결정합니다.
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

    // 1부터 9까지 서로 다른 랜덤한 3자리 숫자를 정합니다.
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

    // 플레이어로부터 3자리 숫자를 입력받습니다.
    public static ArrayList<Integer> userInput() {
        System.out.print("숫자를 입력해주세요 : ");

        String playerInputString = Console.readLine();
        ArrayList<Integer> playerInputArray = new ArrayList<>();
        char[] playerInputCharArray = playerInputString.toCharArray();

        int[] dupTestArr = new int[10];
        boolean errorFlag = false;

        // 입력받은 숫자가 유효한지 확인하고 유효하지않으면 프로그램을 종료시킵니다.
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

    // 볼과 스트라이크를 판정하여 출력합니다.
    private static void playGame(ArrayList<Integer> computerNumbers, ArrayList<Integer> playerNumbers) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < NUMBER_LENGTH; i++) {
            // 스트라이크인지 판별합니다.
            if (computerNumbers.get(i).equals(playerNumbers.get(i))) {
                strikes++;
            } else if (playerNumbers.contains(computerNumbers.get(i))) {
                // 볼인지 판별합니다.
                balls++;
            }
        }

        // 낫싱 또는 볼과 스트라이크의 갯수를 출력합니다.
        if (strikes == 0 && balls == 0) {
            System.out.println("낫싱");
        } else {
            System.out.println(balls + "볼 " + strikes + "스트라이크");
        }
    }

    // 게임이 종료되었는지 여부를 판단합니다.
    private static boolean isGameEnd(ArrayList<Integer> playerNumbers, ArrayList<Integer> computerNumbers) {
        int strikes = 0;

        // 스트라이크의 개수를 계산합니다.
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (computerNumbers.get(i).equals(playerNumbers.get(i))) {
                strikes++;
            }
        }

        // 스트라이크가 3개면 게임 종료를 알립니다.
        if (strikes == NUMBER_LENGTH) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }
}
