package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Baseball implements Game<String> {
    public static final int BASEBALL_DIGIT = 3;
    private String answer;
    private boolean isGameEnded = true;

    @Override
    public void init() {
        this.isGameEnded = true;
        this.answer = generateNumber();
    }

    @Override
    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    @Override
    public void play() {
        this.isGameEnded = false;

        while (!this.isGameEnded) {
            System.out.print("숫자를 입력해주세요 : ");
            String userInput = readLine();
            if (this.checkAnswer(userInput)) {
                this.end();
            }
        }
    }

    private void end() {
        System.out.printf("%d개의 숫자를 모두 맞히셨습니다! 게임 종료\n", Baseball.BASEBALL_DIGIT);
        this.isGameEnded = true;
    }

    private boolean checkAnswer(String guess) {
        boolean isAnswer = false;
        int ballCount = getBallCount(guess);
        int strikeCount = getStrikeCount(guess);

        StringBuilder countMessage = new StringBuilder();
        if (ballCount == 0 && strikeCount == 0) {
            System.out.print("낫싱");
        }

        if (ballCount != 0) {
            countMessage.append(String.format("%d볼", ballCount));
            if (strikeCount != 0) countMessage.append(" ");
        }
        if (strikeCount != 0) {
            countMessage.append(String.format("%d스트라이크", strikeCount));
        }

        System.out.println(countMessage);
        if (strikeCount == Baseball.BASEBALL_DIGIT) {
            isAnswer = true;
        }

        return isAnswer;
    }

    private String generateNumber() {
        StringBuilder number = new StringBuilder();
        while (number.length() < BASEBALL_DIGIT) {
            String randomNumber = Integer.toString(Randoms.pickNumberInRange(1, 9));
            if (!number.toString().contains(randomNumber)) {
                number.append(randomNumber);
            }
        }
        return number.toString();
    }


    private int getBallCount(String userInput) throws IllegalArgumentException {
        if (userInput.length() != BASEBALL_DIGIT) {
            throw new IllegalArgumentException(String.format("숫자는 %d자리입니다.", BASEBALL_DIGIT));
        }

        int ballCount = 0;
        for (int i = 0; i < BASEBALL_DIGIT; i++) {
            for (int j = 0; j < BASEBALL_DIGIT; j++) {
                if (i != j && userInput.charAt(j) == this.answer.charAt(i)) {
                    ballCount++;
                }
            }
        }
        return ballCount;
    }

    private int getStrikeCount(String userInput) throws IllegalArgumentException {
        if (userInput.length() != BASEBALL_DIGIT) {
            throw new IllegalArgumentException(String.format("숫자는 %d자리입니다.", BASEBALL_DIGIT));
        }

        int strikeCount = 0;
        for (int i = 0; i < BASEBALL_DIGIT; i++) {
            if (userInput.charAt(i) == this.answer.charAt(i)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }
}
