package baseball.Controller;

import java.util.List;

import static baseball.Application.*;

public class GameManager {

    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.\n";
    public void playGame() {
        System.out.println(GAME_START_MESSAGE);
        doGameUntilUserQuit();
    }

    private void doGameUntilUserQuit() {
        boolean reGame=false;
        do {
            List<Integer> computer = generateComputerRandomThreeDigitNumber();
            doGameLoopUntilGameOver(computer);
            reGame = shouldRestartGame(); //true이면, 재시작
        } while (reGame == true) ; //

    }

    private void doGameLoopUntilGameOver(List<Integer> computer) {//true이면, 게임 종료하기 위한 단계로 간다.
        boolean gameLoopOver=false;
        do {
            List<Integer> user = getUserGuessThreeDigitNumber();
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
