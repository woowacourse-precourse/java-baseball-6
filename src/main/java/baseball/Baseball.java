package baseball;

import baseball.Opponent.GuessResult;
import camp.nextstep.edu.missionutils.Console;
import java.util.LinkedList;
import java.util.List;

public class Baseball implements Game {
    private Opponent opponent;

    public Baseball() {
        opponent = new Opponent();
    }

    @Override
    public void play() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String question = Console.readLine();
            List<Integer> filteredQuestion = filterQuestion(question);

            GuessResult guessResult = opponent.guess(filteredQuestion);
            System.out.println(guessResult.toHangul());

            if (guessResult.isCorrect()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String endInput = Console.readLine();
                if ("1".equals(endInput)) {
                    opponent = new Opponent();
                } else if ("2".equals(endInput)) {
                    break;
                } else {
                    throw new IllegalArgumentException("Invalid end input");
                }
            }
        }
    }


    private List<Integer> filterQuestion(String userInput) throws IllegalArgumentException {
        if (userInput == null) {
            throw new IllegalArgumentException("Null input");
        }
        if (userInput.length() != 3) {
            throw new IllegalArgumentException("Wrong length");
        }

        LinkedList<Integer> userGuess = new LinkedList<>();
        try {
            int parsedInput = Integer.parseInt(userInput);
            while (userGuess.size() < 3) {
                int i = parsedInput % 10;
                parsedInput = parsedInput / 10;
                if (userGuess.contains(i)) {
                    throw new IllegalArgumentException("Duplicated");
                }
                userGuess.push(i);
            }
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("NaN");
        }

        return userGuess;
    }
}
