package baseball;

import java.util.List;

public class BaseballController {

    private BaseballService baseballService = new BaseballService();

    public void start() {
        System.out.println(NoticeType.GAME_START.getMessage());

        play();
        end();
    }

    public void play() {
        List<Integer> answer = baseballService.generateAnswer();
        while(true) {
            System.out.print(NoticeType.REQUEST_INPUT.getMessage());
            List<Integer> player = baseballService.userPlayInput();

            if(baseballService.getResult(player, answer)) {
                System.out.println(NoticeType.GAME_WIN.getMessage());
                break;
            }
        }
    }

    public void end() {
        System.out.println(NoticeType.RESTART_MESSAGE.getMessage());
        int restart = baseballService.userRestartInput();

        if(baseballService.isRestart(restart)) {
            play();
        }
    }
}
