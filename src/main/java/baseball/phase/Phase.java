package baseball.phase;

public interface Phase {
    void display();

    void validateInput(String input);

    PhaseID action(String input);
}
