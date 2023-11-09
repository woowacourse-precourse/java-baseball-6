package baseball_oop.domain.participant.player;

import baseball_oop.vo.Answer;
import static camp.nextstep.edu.missionutils.Console.readLine;
public class Pitcher implements Player {
    @Override
    public Answer generateAnswer() {
        return new Answer(readLine());
    }
}
