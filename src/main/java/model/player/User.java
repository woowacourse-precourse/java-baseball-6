package model.player;

import java.util.List;

public class User extends Player {

    private User(List<Integer> numbers) {
        super(numbers);
    }

    public static User create(List<Integer> numbers) {
        return new User(numbers);
    }
}
