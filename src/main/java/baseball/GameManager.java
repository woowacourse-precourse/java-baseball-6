package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private final static GameManager Instance = new GameManager();
    ExceptionHandler exceptionHandler = ExceptionHandler.getInstance();
    private GameManager() {
    }

    public static GameManager getInstance() {
        return Instance;
    }

    public void gameStart() {

        //생성자를 통해 상대방(컴퓨터)의 수를 전달
        //게임 실행
        while(true) {

            //상대방(컴퓨터)의 수 생성
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }


            PlayGame playGame = new PlayGame(computer);

            boolean gameCheck = playGame.game();

            if(!gameCheck) {
                throw new IllegalArgumentException("Invalid");
            }

            //정상 게임 종료 시
            String input = Console.readLine();

            boolean inputCheck = exceptionHandler.afterValidation(input);

            if(!inputCheck) throw new IllegalArgumentException("Invalid");

            //정상 입력이 들어온 경우
            int flag = input.charAt(0) - '0';
            if(flag == 1) {
                //새로운 게임 실행
            } else {
                return;
            }

        }

    }
}
