package baseball.controller;

import baseball.entity.Player;
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

    private void game(Player computerPlayer) {

        Referee referee = new Referee();
        Player player;
        while (!referee.isTreeStrike()) {
            player = new Player(viewer.pleaseInputNumberView());
            referee = new Referee(player, computerPlayer);
            System.out.println(referee.result());
        }
        viewer.threeStrikeView();
    }

    private Player getComputerPlayer() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        System.out.println(computer);

        return new Player(computer.stream().map(String::valueOf).collect(Collectors.joining("")));
    }
}
