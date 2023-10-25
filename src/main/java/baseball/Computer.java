package baseball;


import java.util.Set;

public class Computer {
    private final NumberGenerator numGenerator;

    public Computer() {
        this.numGenerator = new NumberGenerator();
    }

    public void pickRandomNum() {
        numGenerator.generateRandomNum();
    }

    public Set<Integer> getNumGenerator() {
        return numGenerator.getNumbers();
    }
    public void reset() {
        numGenerator.reset();
    }
}

