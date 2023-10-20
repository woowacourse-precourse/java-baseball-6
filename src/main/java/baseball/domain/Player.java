package baseball.domain;

import baseball.domain.number.Numbers;

public interface Player {

    public Numbers getNumbers();

    public void changeNumbers(Numbers numbers);
    public void reset();

}
