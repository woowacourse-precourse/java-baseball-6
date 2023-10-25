package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private InputManager inputManager;
    private JudgementManager judgementManager;
    private Game game;

    public GameManager(InputManager inputManager, JudgementManager judgementManager) {
        this.inputManager = inputManager;
        this.judgementManager = judgementManager;
    }

    public void playGame(){
        setGame();
        runGame();
        restartGame();
    }

    private void setGame() {
        this.game = makeGame();
    }

    private void runGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (!game.isGameOver()){
            inputManager.input(game);
            judgementManager.judge(game);
            judgementManager.printResult(game);
        }
    }

    private void restartGame() {
        String restart = inputManager.inputRestart();
        if (restart.equals("1")) {
            playGame();
        }
    }

    private Game makeGame(){
        List<String> computer = new ArrayList<>();
        while (computer.size() < 3) {
            String randomNumber = String.valueOf(Randoms.pickNumberInRange(1, 9));
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        String answer = String.join("", computer);

        return new Game(answer);
    }
}
