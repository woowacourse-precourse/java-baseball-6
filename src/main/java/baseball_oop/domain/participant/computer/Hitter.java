package baseball_oop.domain.participant.computer;

import baseball_oop.vo.Answer;

public class Hitter implements Computer {

    @Override
    public Answer generateAnswer() {
        return new Answer();
    }
}
