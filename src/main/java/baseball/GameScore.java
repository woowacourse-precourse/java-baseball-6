package baseball;

import java.util.List;


public class GameScore {
    private final Person person;
    private final Computer computer;

    public GameScore(Person person, Computer computer) {
        this.person = person;
        this.computer = computer;
    }

    public BallStrikeCount calculateScore() {
        BallStrikeCount ballStrikeCount = new BallStrikeCount();
        List<Integer> personList = person.getInputList();
        List<Integer> computerList = computer.getRandomList();

        for (int i = 0; i < GameConstants.LIST_SIZE; i++) {
            int personNum = personList.get(i);

            if (computerList.contains(personNum)) {
                if (computerList.indexOf(personNum) == i) {
                    ballStrikeCount.increaseStrike();
                    continue;
                }
                ballStrikeCount.increaseBall();
            }
        }
        return ballStrikeCount;
    }
}
