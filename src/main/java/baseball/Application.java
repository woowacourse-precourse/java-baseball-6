package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean continueGame = true;

        while (continueGame)
            continueGame = playGame();
    }

    public static boolean playGame() {
        List<Integer> computerNumbers = generateUniqueRandomNumbers();
        boolean gameFinished = false;

        while (!gameFinished) {
            List<Integer> userNumbers = inputAndValidateUserNumbers();
            gameFinished = evaluateAndDisplayGameResult(computerNumbers, userNumbers);
        }

        return askForNewGame();
    }

    public static List<Integer> generateUniqueRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    public static List<Integer> inputAndValidateUserNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }

        List<Integer> userNumbers = new ArrayList<>();
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException();
            }

            int num = Character.getNumericValue(c);
            if (num < 1 || num > 9 || userNumbers.contains(num)) {
                throw new IllegalArgumentException();
            }

            userNumbers.add(num);
        }
        return userNumbers;
    }

    public static boolean evaluateAndDisplayGameResult(List<Integer> computerNumbers, List<Integer> userNumbers){
        int balls = 0;
        int strikes = 0;

        for(int i = 0; i < 3; i++){
            if(computerNumbers.get(i).equals(userNumbers.get(i))){
                strikes++;
            } else if(computerNumbers.contains(userNumbers.get(i))){
                balls++;
            }
        }

        return displayGameResult(balls, strikes);
    }
}