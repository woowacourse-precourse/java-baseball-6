package baseball.model.dto;

import java.util.List;

public class PlayerDto {

    private final List<Integer> inputList;

    public PlayerDto(List<Integer> inputList) {
        this.inputList = inputList;
    }

    public List<Integer> getInputList() {
        return inputList;
    }
}