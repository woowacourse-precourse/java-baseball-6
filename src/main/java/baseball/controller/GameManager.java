package baseball.controller;

import baseball.entity.UserPlayer;
import baseball.entity.Referee;
import baseball.view.Viewer;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameManager {

    Viewer viewer = new Viewer();

    public void run() {
        String coin = "1";

        viewer.startGameView();
        while (coin.equals("1")) {
            game(getComputerPlayer());

            coin = viewer.restartGameView();
        }

    }

    private void game(UserPlayer computerUserPlayer) {

        Referee referee = new Referee();
        UserPlayer userPlayer;
        while (!referee.isThreeStrike()) {
            userPlayer = new UserPlayer(viewer.pleaseInputNumberView());
            referee = new Referee(userPlayer, computerUserPlayer);
            viewer.resultView(referee.result());
        }
        viewer.threeStrikeView();
    }

    private UserPlayer getComputerPlayer() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        System.out.println(computer);

        return new UserPlayer(computer.stream().map(String::valueOf).collect(Collectors.joining("")));
    }
}
