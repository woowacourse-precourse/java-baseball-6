package baseball;
import java.util.*;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class Application{

    private List<Integer> computerNumber;
    public static void main(String[] args) {
        Application game = new Application();
        game.startGame();
    }

    public void startGame() {
        boolean playAgain = true;
        while (playAgain) {
            generateRandomNumber();
            playAgain = playGame();
            if(playAgain) {
                playAgain = askForRestart();
            }
        }
        System.out.println("게임 종료");
    }

    private void generateRandomNumber() {
        // 난수 생성
        computerNumber = new ArrayList<>();
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
    }

    private boolean playGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String userGuess = Console.readLine();  // 입력 기능
            try {
                validateInput(userGuess);  // 검증 기능 수정
                int[] result = compareNumbers(userGuess);  // 비교 기능
                if (checkWin(result[0])) {
                    System.out.println("3스트라이크");
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                } else {
                    displayResult(result);
                }
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException();
            }
        }
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return true;
    }

    private void validateInput(String input) {  // 검증 메소드 수정
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < 3; i++) {
            char ch = input.charAt(i);
            if (!Character.isDigit(ch)) {
                throw new NumberFormatException("숫자만 입력해주세요.");
            }
            if (input.indexOf(ch) != input.lastIndexOf(ch)) {
                throw new IllegalArgumentException("중복되지 않는 숫자를 입력해주세요.");
            }
        }
    }

    private int[] compareNumbers(String userGuess) {
        int strikes = 0;
        int balls = 0;
        for (int i = 0; i < 3; i++) {
            int userDigit = Character.getNumericValue(userGuess.charAt(i));
            if (userDigit == computerNumber.get(i)) {
                strikes++;
            } else if (computerNumber.contains(userDigit)) {
                balls++;
            }
        }
        return new int[]{strikes, balls};
    }

    private void displayResult(int[] result) {
        int strikes = result[0];
        int balls = result[1];

        if(strikes==0 && balls==0) {
            System.out.println("낫싱");
            return;
        }
        if(balls>0) {
            System.out.print(balls + "볼 ");
        }
        if(strikes>0) {
            System.out.print(strikes + "스트라이크");
        }
        System.out.println();
    }
    private boolean checkWin(int strikes) {
        return strikes == 3;
    }
    private boolean askForRestart() {
        String response = Console.readLine();
        return response.equals("1");
    }
}