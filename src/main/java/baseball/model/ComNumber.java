package baseball.model;

import baseball.service.ComNumberGenerateService;

import java.util.List;

public class ComNumber {

    private final List<Integer> NUMBER;

    public ComNumber(List<Integer> number) {
        this.NUMBER = number;
    }

    public List<Integer> getNumber() {
        return this.NUMBER;
    }

}