package baseball.Controller;

import baseball.dto.RandomNumGenerator;
import baseball.view.InputView;

import java.util.List;

import static baseball.Application.*;

public class GameManager {

    private final InputView inputView = new InputView();

    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public void playGame() {
        System.out.println(GAME_START_MESSAGE);
        doGameUntilUserQuit();
    }

    private void doGameUntilUserQuit() {
        boolean reGame=false;
        do {
            List<Integer> computer = RandomNumGenerator.generateComputerRandomThreeDigitNumber();
            doGameLoopUntilGameOver(computer);
            reGame = inputView.readGameControlInput(); //true이면, 재시작
        } while (reGame == true) ; //

    }

    private void doGameLoopUntilGameOver(List<Integer> computer) {//true이면, 게임 종료하기 위한 단계로 간다.
        boolean gameLoopOver=false;
        do {
            List<Integer> user = inputView.readGameInput();
            gameLoopOver = playSingleGameRound(user, computer);
        } while (gameLoopOver != true);
    }

    public boolean playSingleGameRound(List<Integer> user,List<Integer> computer){//true이면, 게임 종료하기 위한 단계로 간다.

        int numStrikes=0;
        int numBalls =0;
        for(int i=0;i<NUM_DIGITS;i++){
            if(user.get(i)==computer.get(i)){
                numStrikes++;
            } else if(user.get(i)!=computer.get(i) && computer.contains(user.get(i))){
                numBalls++;
            }
        }
        printGuessResult(numStrikes,numBalls);
        return numStrikes == NUM_DIGITS;
    }
}
