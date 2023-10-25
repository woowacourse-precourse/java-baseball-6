package baseball.user;

import baseball.dto.GameRequest;
import baseball.dto.GameResponse;
import baseball.game.GameDispatcher;
import baseball.game.GameDispatcherFactory;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class ConsoleUser implements User {
    @Override
    public void doGame(String cmd, int nargs) {

        // input to console
        List<String> args = new ArrayList<>();
        GameDispatcher dispatcher = GameDispatcherFactory.create(cmd);

        for (int i = 0; i < nargs; ++i) {
            System.out.print("숫자를 입력해주세요 : ");
            args.add(Console.readLine());
        }

        GameResponse response = dispatcher.dispatch(new GameRequest(cmd, args));

        if (response.result().equals("FAIL")) {
            throw new IllegalArgumentException(response.msg());
        }

        System.out.println(response.msg());
        doNextGame(response);
    }

    private void doNextGame(GameResponse response) {
        if (response.msg().equals("3스트라이크")) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String s = Console.readLine();

            if (s.equals("1")) {
                doGame("start", 0);
            } else {
                return;
            }

        } else {
            doGame("predict", 1);
        }
    }
}
