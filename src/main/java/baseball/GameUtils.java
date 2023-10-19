package baseball;


public class GameUtils {

    private final Person person;
    private final Computer computer;
    private final Count count;

    public GameUtils(Person person, Computer computer, Count count) {
        this.person = person;
        this.computer = computer;
        this.count = count;
    }

    public void restartRound() {
        count.clean();
        person.clean();
    }

    public void restartGame() {
        count.clean();
        person.clean();
        computer.clearAndInitialize();
    }
}
