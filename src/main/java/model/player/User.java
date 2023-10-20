package model.player;

import java.util.List;
import model.system.ValidNumberChecker;

public class User implements Player {

    private User(List<Integer> OtherNumbers) {
    }

    public static User create(List<Integer> OtherNumbers, ValidNumberChecker validNumberChecker) {
        return new User(OtherNumbers);
    }
}
