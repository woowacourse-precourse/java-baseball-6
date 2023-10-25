package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private static String regameMent = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private final static GameManager Instance = new GameManager();
    ExceptionHandler exceptionHandler = ExceptionHandler.getInstance();

    private GameManager() {
        //Singleton 구현
    }

    public static GameManager getInstance() {
        return Instance;
    }

    public void gameStart() {

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

            //생성자를 통해 상대방(컴퓨터)의 수를 전달
            PlayGame playGame = new PlayGame(computer);

            //게임 실행
            playGame.game();


            //정상 게임 종료 시
            System.out.println(regameMent);
            String input = Console.readLine();

            //0 또는 1의 플래그값에 대한 유효성 검사
            exceptionHandler.afterValidation(input);

            //정상 입력이 들어온 경우
            int flag = input.charAt(0) - '0';

            //종료 Case
            if(flag == 2) return;

        }




    }
}
