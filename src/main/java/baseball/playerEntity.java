package baseball;

import java.util.List;

public class playerEntity {
    private List<Integer> humanNumber;

    public playerEntity() {
        this.humanNumber = null;
    }

    public void setHumanNumber(List<Integer> humanNumber) {
        this.humanNumber = humanNumber;
    }

    public List<Integer> getHumanNumber() {
        return this.humanNumber;
    }

}
