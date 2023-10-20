package baseball;

import java.util.List;

public class ComNumber {

    private final List<Integer> NUMBER;
    private final ComNumberService comNumberService = new ComNumberService();

    public ComNumber() {
        NUMBER = comNumberService.generateComNumber();
    }

    public List<Integer> getNumber() {
        return this.NUMBER;
    }

}