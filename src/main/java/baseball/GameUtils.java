package baseball;


public class GameUtils {

    private final Person person;
    private final Computer computer;

    public GameUtils(Person person, Computer computer) {
        this.person = person;
        this.computer = computer;
    }

    public void restartRound(Count count) {
        count.clean();
        person.clean();
    }

    public void restartGame(Count count) {
        count.clean();
        person.clean();
        computer.clearAndInitialize();
    }
}
