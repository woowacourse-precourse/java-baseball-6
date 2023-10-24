package baseball.user;

import baseball.dto.GameRequest;
import baseball.dto.GameResponse;
import baseball.game.GameDispatcher;
import baseball.game.GameDispatcherImpl;
import baseball.game.PredictGamePlay;
import baseball.game.StartGamePlay;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class ConsoleUser implements User {
    @Override
    public void doGame(String cmd, int nargs) {

        // input to console
        List<String> args = new ArrayList<>();
        GameDispatcher dispatcher;
        for (int i = 0; i < nargs; ++i) {
            System.out.print("숫자를 입력해주세요 : ");
            args.add(Console.readLine());
        }

        if (cmd == "start") {
            dispatcher = new GameDispatcherImpl(new StartGamePlay());
        } else if (cmd == "predict") {
            dispatcher = new GameDispatcherImpl(new PredictGamePlay());
        } else {
            throw new IllegalArgumentException();
        }

        GameResponse response = dispatcher.dispatch(new GameRequest(cmd, args));

        if (response.result().equals("SUCCESS")) {
            System.out.println(response.msg());

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
        } else {
            throw new IllegalArgumentException(response.msg());
        }

    }
}
