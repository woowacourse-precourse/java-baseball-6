package baseball;

import static baseball.Application.LIST_SIZE;

import java.util.List;



public class BaseballScore {
    private final Person person;
    private final Computer computer;
    private final Count count;

    public BaseballScore(Person person, Computer computer) {
        this.person = person;
        this.computer = computer;
        count = new Count();
    }

    public Count count() {
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
