package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        //(게임 시작 문구 출력)
        System.out.println("숫자 야구 게임을 시작합니다");
        //random number generation for computer
        List<Integer> computerNumber = generateComputerNumber();
        while (true) { //running game
            List<Integer> userGuess = getUserInput();
            int[] result = checkResult(computerNumber, userGuess);
            printResult(result);

            if (checkWinCondition(result[1])) {
                if (restartOrnot() == 1) { //restart 1, end 2
                    computerNumber = generateComputerNumber();
                } else
                    break;
            }
        }

    }

    private static int restartOrnot() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        return Integer.parseInt(input);
    }

    private static boolean checkWinCondition(int strike) {
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
        return strike == 3;
    }

    private static void printResult(int[] result) {
        if (result[0] == 0 && result[1] == 0) {
            System.out.println("낫싱");
            return;
        }
        if (result[0] > 0)
            System.out.print(result[0] + "볼 ");
        if (result[1] > 0)
            System.out.print(result[1] + "스트라이크");

        System.out.println();
        return;
    }

    //check&return the number of strike and ball
    private static int[] checkResult (List<Integer> computerNumber, List<Integer> userGuess){
        int ball = 0, strike = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (computerNumber.get(i).equals(userGuess.get(j))) {//same number exist
                    if (i != j) {
                        ball++;
                        break;
                    } else {
                        strike++;
                        break;
                    }
                }
            }
        }

        return new int[]{ball, strike};
    }


    private static List<Integer> generateComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber))
                computer.add(randomNumber);
        }
        return computer;
    }

    //user input
    private static List<Integer> getUserInput() {
        System.out.print("숫자를 입력해주세요: ");
        String input = Console.readLine();
        List<Integer> parseInput = new ArrayList<>();
        for (char ch : input.toCharArray()) {
            parseInput.add(ch - '0'); //char to integer
        }
        return parseInput;
    }
}

