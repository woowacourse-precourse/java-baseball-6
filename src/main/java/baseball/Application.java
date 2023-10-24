package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
//        [] 게임 시작 문구 출력
//        [] 서로 다른 세 자리의 수 생성
//        [] 세 자리 수 입력받기
//        [] 잘못된 값이 입력됐는지 확인하기
//        [] 결과(스트라이크, 볼, 낫싱) 계산
//        [] 계산 결과 출력
//        [] (게임 종료시) 게임 종료 문구 출력
//        [] (게임 종료시) 재시작/종료를 구분하는 수(1또는 2) 입력받기

        BaseballGame game = new BaseballGame(new Computer(), new User());
        game.start();
    }
}

class BaseballGame {

    private Computer computer;
    private User user;
    private boolean isGameover = false;

    public BaseballGame(Computer computer, User user) {

        this.computer = computer;
        this.user = user;
    }

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (!isGameover) {
            try {
                List<Integer> computerNumber = computer.getNumber();
                int userGuess = user.userInput();

                if (!User.isValidGuess(userGuess)) {
                    throw new IllegalAccessException();
                }

                GameResult result = calculateResult(computerNumber, userGuess);
                result.printResult();

                if (result.isGameDone()) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

                    if (askNewGame()) { // 게임 재시작 o
                        startNewGame();
                    } else { // 재시작 x
                        isGameover = true;
                        break;
                    }
                }

            } catch (IllegalAccessException e) {
                break;
            }
        }
    }

    public void startNewGame() {
        isGameover = false;
        computer.reset();
    }

    private boolean askNewGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int userChoice = Integer.parseInt(Console.readLine());
        return userChoice == 1;
    }

    private GameResult calculateResult(List<Integer> computerNumber, int userGuess) {
        int strikes = 0;
        int balls = 0;

        List<Integer> userGuessDigits = getDigits(userGuess);

        for (int i = 0; i < 3; i++) {
            if (userGuessDigits.get(i).equals(computerNumber.get(i))) {
                strikes++;
            } else if (computerNumber.contains(userGuessDigits.get(i))) {
                balls++;
            }
        }

        return new GameResult(strikes, balls);

    }

    private List<Integer> getDigits(int number) {
        List<Integer> digits = new ArrayList<>();
        digits.add(number / 100);
        digits.add((number % 100) / 10);
        digits.add(number % 10);
        return digits;
    }

}

class GameResult {

    private int strikes;
    private int balls;

    public GameResult(int strikes, int balls) {
        this.strikes = strikes;
        this.balls = balls;
    }

    public void printResult() {
        if (balls > 0) {
            System.out.print(balls + "볼 ");
        }
        if (strikes > 0) {
            System.out.print(strikes + "스트라이크");
        }
        if (strikes == 0 && balls == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
    }

    public boolean isGameDone() {
        return strikes == 3;
    }
}

class Computer {

    private List<Integer> number;

    public Computer() {
        this.number = generateRandomNumber();
    }

    private List<Integer> generateRandomNumber() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        return computerNumber;
    }

    public List<Integer> getNumber() {
        return number;
    }

    public void reset() {
        this.number = generateRandomNumber();
    }
}

class User {

    public int userInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInputStr = Console.readLine().trim();

        if (userInputStr.isEmpty()) {
            throw new IllegalArgumentException();
        }

        int userInput;
        try {
            userInput = Integer.parseInt(userInputStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        if (!isValidGuess(userInput)) {
            throw new IllegalArgumentException();
        }

        return userInput;
    }

    public static boolean isValidGuess(int input) {

        List<Integer> digits = new ArrayList<>();
        int length = (int) (Math.log10(input) + 1);

        digits.add(input / 100); 
        digits.add((input % 100) / 10);
        digits.add(input % 10);

        return (length == 3) && (digits.stream().distinct().count() == 3);
    }
}