package baseball.service;
import baseball.domain.Game;
import baseball.utils.NumberGenerator;
import baseball.view.OutView;
import baseball.view.InputView;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class GameService {
    private final NumberGenerator numberGenerator = new NumberGenerator();
    private Game game;
    private final String INPUT_RETRY_GAME = "1";
    private final String INPUT_END_GAME = "2";

    public void initGame() {
        List<Integer> programNumbers = numberGenerator.generateProgramNumbers();
        this.game = new Game(programNumbers);
        OutView.printStartGame();
    }

    public void playGame() throws IllegalArgumentException {
        while(game.getStrikeCount() != 3) {
            InputView.requestInputNumbers();
            String input = Console.readLine();

            validateInput(input);
            List<Integer> userNumbers = parseInput(input);

            // 똑같은 입력 값이 들어오면 다시 입력 받도록 한다.
            if(game.checkDuplicatedInput(input)){
                OutView.printDuplicatedInput();
                continue;
            }

            countStrikeAndBall(userNumbers);
            giveHint();
        }
    }

    /**
     * 현재 진행중인 게임을 종료한다.
     */
    public void endGame() {
        game.end();
        OutView.printEndGame();
    }

    /**
     * 사용자가 게임을 다시 시작할지, 종료할지 입력받는다.
     * @return 게임을 다시 시작하면 true, 이대로 종료하면 false
     * @throws IllegalArgumentException - 입력이 1 또는 2가 아닌 경우
     */
    public boolean checkRetryGame() throws IllegalArgumentException{
        InputView.requestInputRestart();
        String input = Console.readLine();

        if(input.equals(INPUT_RETRY_GAME)) {
            return true;
        }
        if(input.equals(INPUT_END_GAME)) {
            return false;
        }

        throw new IllegalArgumentException("1 또는 2가 아닙니다.");
    }

    /**
     * 사용자 입력에 따른 스트라이크, 볼 개수를 계산하여 힌트를 출력한다.
     */
    private void giveHint() {
        if (game.getStrikeCount() == 0 && game.getBallCount() == 0) {
            OutView.printNothing();
        } else {
            OutView.printResult(game.getStrikeCount(), game.getBallCount());
        }
    }

    /**
     * 사용자 입력이 유효한지 검증한다.
     * @param input 사용자 입력
     * @throws IllegalArgumentException
     */
    private void validateInput(String input) throws IllegalArgumentException{
        // 입력이 안된 경우
        if(input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력이 없습니다.");
        }
        // 숫자가 아닌 경우
        if(!input.matches("\\d+")) {
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

    /**
     * 사용자 입력을 List<Integer>로 변환한다.
     * @param input 사용자 입력
     * @return List<Integer>
     */
    private List<Integer> parseInput(String input) {
        List<Integer> userNumbers = new ArrayList<>();
        for(int i = 0; i < input.length(); i++) {
            userNumbers.add(Integer.parseInt(String.valueOf(input.charAt(i))));
        }

        return userNumbers;
    }

    /**
     * 사용자 입력에 따른 스트라이크, 볼 개수를 계산한다.
     * @param userNumbers 사용자 입력
     */
    private void countStrikeAndBall(List<Integer> userNumbers) {
        game.resetCount();
        for(int i = 0; i < userNumbers.size(); i++) {
            if(game.getProgramNumbers().get(i).equals(userNumbers.get(i))) {
                game.increaseStrikeCount();
            } else if(game.getProgramNumbers().contains(userNumbers.get(i))) {
                game.increaseBallCount();
            }
        }
    }
}
