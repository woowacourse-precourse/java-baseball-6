package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        Game game = new Game();
        game.startGame();
    }
}

class Game {
    private List<Integer> answer;
    public void startGame() {
        setNewAnswer();
        System.out.println(this.answer);

        List<Integer> input = getNewInput();
        System.out.println(input);
    }

    private void setNewAnswer() {
        this.answer = new ArrayList<>();
        while (this.answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!this.answer.contains(randomNumber)) {
                this.answer.add(randomNumber);
            }
        }
    }

    private List<Integer> getNewInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputString = Console.readLine();
        validInput(inputString);

        List<Integer> input = new ArrayList<>();

        for (int i = 0; i < inputString.length(); i++) {
            char digitChar = inputString.charAt(i);
            int digitInt = Character.getNumericValue(digitChar);
            input.add(digitInt);
        }

        return input;
    }

    private void validInput(String inputString) {
        if (inputString.length() != 3) {
            throw new IllegalArgumentException();
        }

        try {
            int inputInt = Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        Set<Character> charSet = new HashSet<>();
        for (int i = 0; i < inputString.length(); i++) {
            char currentChar = inputString.charAt(i);
            if (charSet.contains(currentChar)) {
                throw new IllegalArgumentException();
            }
            charSet.add(currentChar);
        }
    }
}