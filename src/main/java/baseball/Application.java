package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.lang.IllegalArgumentException;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean startFlag = true;
        ArrayList<Integer> computer = new ArrayList<>();

        while (true) {
            if (startFlag) {
                //랜덤 세 자리 수를 생성하는 함수
                computer = ranNumber();
            }

            //player의 입력을 받는 함수
            ArrayList<Integer> player = userInput();

            //computer와 player의 입력을 비교하여 야구 시작
            int ball = judgeBall(computer, player);
            int strike = judgeStrike(computer, player);

            //형식에 맞춰 출력하는 함수
            printBaseball(ball, strike);

            String restartFlagString = "default";

            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                restartFlagString = Console.readLine();
            }

            if (restartFlagString.equals("default")) {
                startFlag = false;
            } else if (restartFlagString.equals("1")) {
                startFlag = true;
            } else if (restartFlagString.equals("2")) {
                break; //반복문 탈출 후 종료
            } else {
                throw new IllegalArgumentException("유효하지 않은 입력입니다. 1 혹은 2만 입력하십시오.");
            }
        }
    }

    public static void printBaseball(int ball, int strike) {
        String message = "";

        if (ball != 0) {
            message += ball + "볼";
        }

        if (strike != 0) {
            if (!message.isEmpty()) {
                message += " ";
            }
            message += strike + "스트라이크";
        }

        if (message.isEmpty()) {
            System.out.print("낫싱");
        }

        System.out.println(message);
    }

    public static int judgeStrike(ArrayList<Integer> computer, ArrayList<Integer> player) {
        int strike = 0;

        for (int i = 0; i < 3; i++) {
            if (computer.get(i).equals(player.get(i))) {
                strike++;
            }
        }
        return strike;
    }

    public static int judgeBall(ArrayList<Integer> computer, ArrayList<Integer> player) {
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            if (player.contains(computer.get(i)) && (!computer.get(i).equals(player.get(i)))) {
                ball++;
            }
        }
        return ball;
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
}
