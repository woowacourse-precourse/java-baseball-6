package baseball;


public class GameEntities {
    private final Computer computer;
    private final Challenger challenger;

    private GameEntities(Computer computer, Challenger challenger) {
        this.computer = computer;
        this.challenger = challenger;
    }

    public static GameEntities createEntities() {
        Computer computer = new Computer();
        Challenger challenger = new Challenger();
        return new GameEntities(computer, challenger);
    }

    public Computer getComputer() {
        return computer;
    }

    public Challenger getChallenger() {
        return challenger;
    }
}