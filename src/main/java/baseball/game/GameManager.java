package baseball.game;

import baseball.computer.Computer;
import baseball.player.Player;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    Computer computer = new Computer();
    Player player = new Player();
    BaseballGame baseballGame = new BaseballGame();

    /**
     * 숫자 야구 게임을 시작한다.
     */
    public void gameStart() {
        List<Integer> randoms = new ArrayList<>();
        List<Integer> inputs = new ArrayList<>();
        int success = 3;

        System.out.println("숫자 야구 게임을 시작합니다.");

        do {
            int isSuccess = 0;
            randoms = computer.generateRandomDigits();

            while (isSuccess != success){
                inputs = player.getInput();

                isSuccess = baseballGame.compare(randoms, inputs);
            }

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        } while (playAgain() == true);
    }

    /**
     * 게임을 다시 시작할지 물어본다.
     * @return 게임을 다시 시작할건지, 아닌지 반환
     */
    public boolean playAgain(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int isRestart = Integer.parseInt(Console.readLine());
        if(isRestart == 1){
            return true;
        }

        System.out.println("숫자 야구 게임을 종료합니다.");
        return false;
    }
}
