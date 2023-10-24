package baseball.participant;

import baseball.GameMenu;
import baseball.slot.BaseballNumbersSlot;
import baseball.slot.PlayerBaseballNumbersSlot;
import camp.nextstep.edu.missionutils.Console;

public class Player extends Participant {

    public Player() {
        super(new PlayerBaseballNumbersSlot());
    }

    public void guessNumbers() {
        this.numbersSlot.updateNumbers();
    }

    public GameMenu getMenu() {
        String input = Console.readLine();
        return GameMenu.from(input);
    }
}
