package baseball;

import static baseball.GameConstants.LIST_SIZE;

import java.util.List;


public class GameScore {
    private final Person person;
    private final Computer computer;

    public GameScore(Person person, Computer computer) {
        this.person = person;
        this.computer = computer;
    }

    public Count calculateScore() {
        Count count = new Count();
        List<Integer> personList = person.getInputList();
        List<Integer> computerList = computer.getRandomList();

        for (int i = 0; i < LIST_SIZE; i++) {
            int personNum = personList.get(i);

            if (computerList.contains(personNum)) {
                if (computerList.indexOf(personNum) == i) {
                    count.increaseStrike();
                    continue;
                }
                count.increaseBall();
            }
        }
        return count;
    }
}
