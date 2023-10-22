package baseball.service;

import baseball.utils.NumberGenerator;
import baseball.view.OutView;
import baseball.view.InputView;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class GameService {
    private List<Integer> programNumbers;
    private int strikeCount;
    private int ballCount;
    private final NumberGenerator numberGenerator = new NumberGenerator();

    public void initGame() {
        resetCount();
        programNumbers = numberGenerator.generateNumbers();
        OutView.printStartGame();
    }

    public void playGame() throws IllegalArgumentException {
        while(true){
            InputView.requestInputNumbers();
            String input = Console.readLine();

            validateInput(input);
            List<Integer> userNumbers = parseInput(input);
            // TODO : 이전에 입력한 숫자와 비교하여 중복된 숫자가 있는지 확인하는 로직 구현

            countStrikeAndBall(userNumbers);

            if(this.strikeCount == 3) {
                break;
            }
        }
    }

    private void validateInput(String input) throws IllegalArgumentException{
        // 입력이 안된 경우
        if(input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력이 없습니다.");
        }
        // 숫자가 아닌 경우
        if(!input.matches("[0-9]+")) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
        // 3자리가 아닌 경우
        if(input.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자가 아닙니다.");
        }
        // 중복된 숫자가 있는 경우
        if(input.charAt(0) == input.charAt(1) || input.charAt(1) == input.charAt(2) || input.charAt(0) == input.charAt(2)) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
    }

    private List<Integer> parseInput(String input) {
        List<Integer> userNumbers = new ArrayList<>();
        for(int i = 0; i < input.length(); i++) {
            userNumbers.add(Integer.parseInt(String.valueOf(input.charAt(i))));
        }

        return userNumbers;
    }

    private void countStrikeAndBall(List<Integer> userNumbers) {
        resetCount();
        for(int i = 0; i < userNumbers.size(); i++) {
            if(programNumbers.get(i).equals(userNumbers.get(i))) {
                this.strikeCount++;
            } else if(programNumbers.contains(userNumbers.get(i))) {
                this.ballCount++;
            }
        }
    }

    private void resetCount(){
        this.strikeCount = 0;
        this.ballCount = 0;
    }
}
