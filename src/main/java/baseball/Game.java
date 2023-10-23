package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private ComputerNumber computerNumber;
    private boolean end;
    private int numberSize;

    public Game() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        gameInit();
    }

    public boolean isEnd() {
        return end;
    }

    private void gameInit() {
        this.end = false;
        this.numberSize = 3;
        this.computerNumber = new ComputerNumber(numberSize);
    }

    public void playGame() {
        String playerInput = playerTurn();
        int[] result = checkNumber(playerInput);
        printResult(result);
        this.end = isGaveEnd(result[1]);
        if (this.end) {
            checkRestart();
        }
    }

    private void checkRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String playerInput = Console.readLine();
        if (playerInput.equals("1")) {
            gameInit();
            return;
        }
        if (playerInput.equals("2")) {
            return;
        }
        throw new IllegalArgumentException();
    }

    private String playerTurn() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    private int[] checkNumber(String playerInput) {
        sizeCheck(playerInput.length());
        List<Integer> playerNumbers = duplicateCheck(playerInput);
        numberRangeCheck(playerNumbers);
        return computerNumber.compare(playerNumbers);
    }

    private void sizeCheck(int inputLength) {
        if (this.numberSize != inputLength) {
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> duplicateCheck(String playerInput) {
        List<Integer> playerNumbers = new ArrayList<>();
        for (int i = 0; i < numberSize; i++) {
            int number = playerInput.charAt(i) - '0';
            if (playerNumbers.contains(number)) {
                throw new IllegalArgumentException();
            }
            playerNumbers.add(number);
        }
        return playerNumbers;
    }

    private void numberRangeCheck(List<Integer> playerNumbers) {
        for (int number : playerNumbers) {
            if (number < 1 || number > 9) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void printResult(int[] result) {
        if (result[0] == 0 && result[1] == 0) {
            System.out.println("낫싱");
            return;
        }
        if (result[0] > 0) {
            System.out.print(result[0] + "볼 ");
        }
        if (result[1] > 0) {
            System.out.print(result[1] + "스트라이크");
        }
        System.out.println();
    }

    private boolean isGaveEnd(int strikeNum) {
        if (numberSize == strikeNum) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }
}
