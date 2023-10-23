package baseball;

import baseball.Service.GameService;
import baseball.Service.UserService;
import camp.nextstep.edu.missionutils.Console;

public class GameController {
    UserService userService = new UserService();
    public void game(){
        GameService gameService = new GameService(userService);

        boolean keepPlaying = true;

        while(keepPlaying) {
            gameService.gameStart();
            gameService.gameInitialize();
            gameService.gameOn();

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            String strType = Console.readLine();
            int type = Integer.parseInt(strType);

            if (type == 2) keepPlaying = false;
        }

    }
}
