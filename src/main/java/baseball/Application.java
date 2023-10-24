package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    static final int MAX_COUNT = 3;

    public static void main(String[] args) {

        baseball.Application game = new baseball.Application();

        System.out.println("숫자 야구 게임을 시작합니다.");
        game.playGame();

    }

    public void playGame() {

        List<Integer> computerNumber = makeComputerNumber();

        while (true) {

            System.out.print("숫자를 입력해주세요 : ");
            String writeNumber = readLine();
            checkInputValue(writeNumber);

            String text = resultCount(writeNumber, computerNumber);
            System.out.println(text);

            if (text.equals(MAX_COUNT + "스트라이크")) {
                startNewGame();
                break;
            }
        }
    }

    private static List<Integer> makeComputerNumber() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < MAX_COUNT) {
            int computerNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(computerNumber)) {
                computer.add(computerNumber);
            }
        }

        return computer;
    }

    static void checkInputValue(String input) {
        if (!checkMaxLength(input)){
            throw new IllegalArgumentException();
        } else if (!checkInteger(input)) {
            throw new IllegalArgumentException();
        } else if (checkContinue(input)) {
            throw new IllegalArgumentException();
        }
    }

    static boolean checkMaxLength(String input){
        if (input.length() != MAX_COUNT){
            return false;
        }
        return true;

    }
    static boolean checkInteger(String input){
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    static boolean checkContinue(String input){
        String[] inputArr = input.split("");
        if (Integer.parseInt(inputArr[0]) - Integer.parseInt(inputArr[1]) == 0 ){
            return true;
        } else if (Integer.parseInt(inputArr[0]) - Integer.parseInt(inputArr[2]) == 0 ) {
            return true;
        }
        return false;
    }

    public static int countStrikes(List<Integer> number, List<Integer> computer) {
        int strike = 0;
        for (int i = 0; i < MAX_COUNT; i++) {
            if (number.get(i).equals(computer.get(i))) {
                strike++;
            }
        }
        return strike;
    }

}
