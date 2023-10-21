package baseball.Model;

import java.util.ArrayList;
import java.util.List;

public class BaseBallGame {
    /**
     * Model은 Controller와 View에 관련된 코드가 있으면 안된다!!!!!!
     * <p>
     * 본 클래스는 게임의 전체적인데이터와  로직을 관리합니다.
     */
    private List<Integer> computerNumber;
    private NumberGenerator numberGenerator;
    private boolean isGameOver;
    private static final int BASEBALL_NUM_SIZE = 3;

    public BaseBallGame(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
        computerNumber = numberGenerator.generatorComputerNumber(BASEBALL_NUM_SIZE);
        isGameOver = false;
    }

    /**
     * 유저의 입력을 받아 볼과 스트라이크를 알려주는 메소드
     */
    public List<Integer> checkBallCount(List<Integer> userInput) {
        List<Integer> listBallStrike = new ArrayList<>();
        int totalCount = 0;
        int strikeCount = 0;
        int ballCount = 0;

        if (userInput.size() != BASEBALL_NUM_SIZE) {
            throw new IllegalArgumentException("입력 자릿 수 오류");
        }

        for (int i = 0; i < BASEBALL_NUM_SIZE; i++) {
            if (userInput.contains(computerNumber.get(i))) {
                totalCount++;
            }
            if (userInput.get(i) == computerNumber.get(i)) {
                strikeCount++;
            }
        }
        ballCount = totalCount - strikeCount;
        listBallStrike.add(ballCount);
        listBallStrike.add(strikeCount);
        return listBallStrike;
    }

    /**
     * 게임을 다시 시작할때 셋팅해주는 메소드
     */
    public void restartGame() {
        computerNumber = numberGenerator.generatorComputerNumber(BASEBALL_NUM_SIZE);
        isGameOver = false;
    }

    /**
     * 게임이 현재 끝난 상태인지 반환함
     */
    public boolean isGameOver() {
        return isGameOver;
    }

    /**
     * 유저가 입력한 String형식의 Input을 List형식으로 파씽함
     */
    public List<Integer> parseUserInput(String input) {
        List<Integer> parsedInput = new ArrayList<>();

        if (input.length() != BASEBALL_NUM_SIZE) {
            throw new IllegalArgumentException("입력 자릿 수 오류");
        }

        for (int i = 0; i < BASEBALL_NUM_SIZE; i++) {
            char c = input.charAt(i);
            if (Character.isDigit(c)) {
                int digit = Character.getNumericValue(c);
                parsedInput.add(digit);
            }
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("허가되지 않은 문자열");
            }

        }

        return parsedInput;
    }
}
