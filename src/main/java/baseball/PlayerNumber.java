package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class PlayerNumber {

    public List<Integer> getPlayer() {
        String inputNumber = Console.readLine();
        List<Integer> player = new ArrayList<>();

        for(int i=0;i<3;i++) {
            player.add(Integer.parseInt(inputNumber.substring(i,i+1)));
        }
        return player;
    }

    public void exception_ExceedLength(String inputNumber) {
        if (inputNumber.length() != 3) {
            throw new IllegalArgumentException("세자리 수보다 크거나 작음");
        }
    }

}
