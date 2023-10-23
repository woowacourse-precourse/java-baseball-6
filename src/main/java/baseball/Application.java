package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

class Pair<T, U> {
    private final T first;
    private final U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }
}

class User {
    private String userInput;
    private boolean winning;

    public User() {
        this.userInput = "";
        this.winning = false;
    }

    public void userWins() {
        winning = true;
    }

    public void userLoses() {
        winning = false;
    }

    public boolean didUserWin() {
        return winning;
    }

    public void readUserInput() {
        userInput = Console.readLine();
    }

    public String getUserInput() {
        return userInput;
    }

    public boolean isUserInputValidInGame() {
        // 인게임에서 사용자 입력값의 길이가 3이 아니면 false
        if (userInput.length() != 3) {
            return false;
        }

        try {
            int userNumber = Integer.parseInt(userInput);
            // userNumber가 -99와 같이 음의 정수이면 false
            if (userNumber < 0) {
                return false;
            }
            // userNumber 자릿수 중에 하나라도 0이면 false
            while (userNumber > 0) {
                if (userNumber % 10 == 0) {
                    return false;
                }
                userNumber /= 10;
            }

        } catch (NumberFormatException error) {
            // 인게임에서 사용자 입력값의 파싱 결과가 숫자가 아니면 false
            return false;
        }
        return true;
    }

    public boolean isUserInputValidAfterGame() {
        if (userInput.equals("1")) {
            return true;
        }
        if (userInput.equals("2")) {
            return true;
        }
        return false;
    }
}

class Computer {
    private final List<Integer> numbers;

    public Computer() {
        this.numbers = new ArrayList<>();
        // 1~9까지 서로 다른 임의의 수 3개를 생성하여 저장
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
    }

    public Pair<Integer, Integer> getUserGuessResult(String userGuess) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < userGuess.length(); i++) {
            int userGuessNumber = userGuess.charAt(i) - '0';
            if (numbers.get(i) == userGuessNumber) {
                strike++;
            } else if (numbers.contains(userGuessNumber)) {
                ball++;
            }
        }
        return new Pair<Integer, Integer>(strike, ball);
    }

    public void printUserGuessResult(Pair<Integer, Integer> userGuessResult) {
        if (userGuessResult.getFirst() == 0 && userGuessResult.getSecond() == 0) {
            System.out.printf("낫싱\n");
        } else if (userGuessResult.getFirst() == 0) {
            System.out.printf("%d볼\n", userGuessResult.getSecond());
        } else if (userGuessResult.getSecond() == 0) {
            System.out.printf("%d스트라이크\n", userGuessResult.getFirst());
        } else {
            System.out.printf("%d스트라이크 %d볼\n", userGuessResult.getFirst(), userGuessResult.getSecond());
        }
    }

}

public class Application {


    public static void main(String[] args) {
        User user = new User();
        Computer computer = new Computer();
        System.out.printf("숫자 야구 게임을 시작합니다.\n");
        while (!user.didUserWin()) {
            try {
                System.out.printf("숫자를 입력해주세요 : ");
                user.readUserInput();
                if (!user.isUserInputValidInGame()) {
                    throw new IllegalArgumentException();
                }
                Pair<Integer, Integer> guessResult = computer.getUserGuessResult(user.getUserInput());
                computer.printUserGuessResult(guessResult);
                if (guessResult.getFirst() == 3) {
                    user.userWins();
                    System.out.printf("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
                    System.out.printf("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
                    user.readUserInput();
                    if (!user.isUserInputValidAfterGame()) {
                        throw new IllegalArgumentException();
                    }
                    switch (user.getUserInput()) {
                        case "1":
                            user.userLoses();
                            continue;
                        case "2":
                            continue;
                        default:
                            throw new IllegalArgumentException();
                    }
                }

            } catch (IllegalArgumentException error) {
                user.userWins();
                continue;
            }
        }
    }
}
