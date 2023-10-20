package baseball.util;

import baseball.view.InputView;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;

public class NumGenerator {
    InputView inputview = new InputView();
    public ArrayList<Integer> computerNumGenerator() {
        ArrayList<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public ArrayList<Integer> playerNumGenerator() {
        ArrayList<Integer> player = new ArrayList<>();
        int num = inputview.readPlayerNum();
        while (num>0){
            player.add(num%10);
            num/=10;
        }
        Collections.reverse(player);
        return player;
    }
}
