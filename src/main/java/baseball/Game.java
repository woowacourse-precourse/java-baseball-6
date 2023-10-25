package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {
    final String MSG_START_GAME = "숫자 야구 게임을 시작합니다.";
    final String MSG_INPUT_NUMBER = "숫자를 입력해주세요 : ";
    final String MSG_GUESS_SUCCESSFUL = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    final String MSG_INPUT_REPLAY = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    final String MSG_END_GAME = "게임 종료";
    final String WORD_NOTHING = "낫싱";
    final String WORD_STRIKE = "스트라이크";
    final String WORD_BALL = "볼";

    final String REPLAY_CHOICE_YES = "1";
    final String REPLAY_CHOICE_NO = "2";

    final Integer COMPUTER_ANSWER_SIZE = 3;
    final Integer ANSWER_RANGE_START = 1;
    final Integer ANSWER_RANGE_END = 9;

    public Game() {

    }

    public void playGame() {
        System.out.println(MSG_START_GAME);
        boolean isReplay = true;
        while (isReplay) {
            List<Integer> answer = createComputerAnswer();
            boolean isCorrect = false;
            while (!isCorrect) {
                System.out.println(MSG_INPUT_NUMBER);
                List<Integer> guess = inputUserGuess();
                GuessResult guessResult = checkGuess(answer, guess);
                System.out.println(guessResult.toString());
                if (isSuccessGuess(guessResult)) {
                    isCorrect = true;
                    System.out.println(MSG_GUESS_SUCCESSFUL);
                }
            }
            System.out.println(MSG_INPUT_REPLAY);
            String replayChoice = Console.readLine().trim();
            if (replayChoice.equals(REPLAY_CHOICE_YES)) {
                isReplay = true;
            } else if (replayChoice.equals(REPLAY_CHOICE_NO)) {
                isReplay = false;
            } else {
                throw new IllegalArgumentException("1 또는 2 를 입력해주세요.");
            }
        }
        System.out.println(MSG_END_GAME);
    }

    private boolean isSuccessGuess(GuessResult guessResult) {
        return guessResult.getStrikeCount() == COMPUTER_ANSWER_SIZE;
    }

    private GuessResult checkGuess(List<Integer> answer, List<Integer> guess) {
        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0 ; i < COMPUTER_ANSWER_SIZE ; i++) {
            if (answer.get(i).equals(guess.get(i))) {
                strikeCount++;
            } else if (answer.contains(guess.get(i))) {
                ballCount++;
            }
        }

        return new GuessResult(strikeCount, ballCount);
    }

    private List<Integer> createComputerAnswer() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < COMPUTER_ANSWER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(ANSWER_RANGE_START, ANSWER_RANGE_END);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private List<Integer> inputUserGuess() {
        String userInputStr = Console.readLine().trim();
        if (userInputStr.length() == COMPUTER_ANSWER_SIZE) {
            try {
                return List.of(
                        Integer.parseInt(userInputStr.substring(0, 1)),
                        Integer.parseInt(userInputStr.substring(1, 2)),
                        Integer.parseInt(userInputStr.substring(2, 3)));
            } catch (Exception e) {
                throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
            }
        } else {
            throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
        }
    }

    private class GuessResult {
        private int strikeCount;
        private int ballCount;

        GuessResult(int strikeCount, int ballCount) {
            this.strikeCount = strikeCount;
            this.ballCount = ballCount;
        }

        public int getStrikeCount() {
            return strikeCount;
        }

        public int getBallCount() {
            return ballCount;
        }

        public String toString() {
            if (strikeCount == 0 && ballCount == 0) {
                return WORD_NOTHING;
            } else if (strikeCount > 0 && ballCount > 0) {
                return ballCount + WORD_BALL + " " + strikeCount + WORD_STRIKE;
            } else if (ballCount > 0 ) {
                return ballCount + WORD_BALL;
            } else if (strikeCount > 0) {
                return strikeCount + WORD_STRIKE;
            }
            return "";
        }
    };
}
