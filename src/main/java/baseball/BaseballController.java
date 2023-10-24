package baseball;

import java.util.List;

public class BaseballController {

    private BaseballService baseballService = new BaseballService();

    public void start() {
        System.out.println(NoticeType.GAME_START.getMessage());
        System.out.print(NoticeType.REQUEST_INPUT.getMessage());

        List<Integer> answer = baseballService.generateAnswer();
        List<Integer> player = baseballService.userInput();

        while(!play(player, answer)) {
            System.out.print(NoticeType.REQUEST_INPUT.getMessage());
            player = baseballService.userInput();
        }
    }

    public boolean play(List<Integer> player, List<Integer> answer) {
        if(baseballService.getResult(player, answer)) {
            System.out.println(NoticeType.GAME_WIN.getMessage());
            return true;
        }
        return false;
    }
}
