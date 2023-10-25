package util;

import player.Computer;
import player.Player;
import player.User;

public class PlayerFactory {

    public static Player getUser(int ballNumberLength) {
        return new User(ballNumberLength);
    }

    public static Player getComputer() {
        return new Computer();
    }
}
