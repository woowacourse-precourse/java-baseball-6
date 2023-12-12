package baseball.domain.entity.player;

import baseball.domain.entity.Numbers;

public class User implements Player{
    private Numbers numbers;

    public User(Numbers numbers) {
        this.numbers = numbers;
    }

    public static User of(Numbers numbers){
        return new User(numbers);
    }

    @Override
    public Numbers getNumbers() {
        return numbers;
    }
}
