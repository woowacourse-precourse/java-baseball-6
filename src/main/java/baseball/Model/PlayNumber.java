package baseball.Model;


import java.util.List;

public class PlayNumber {
    private String inputNumberStr;
    private List<Integer> inputNumbers;
    private List<Integer> computerNumbers;

    public PlayNumber() {}

    public String getInputNumberStr() {
        return inputNumberStr;
    }

    public void setInputNumberStr(String inputNumberStr) {
        this.inputNumberStr = inputNumberStr.replace(" ","");
    }

    public List<Integer> getInputNumbers() {
        return inputNumbers;
    }

    public void setInputNumbers(List<Integer> inputNumbers) {
        this.inputNumbers = inputNumbers;
    }

    public List<Integer> getComputerNumbers() {
        return computerNumbers;
    }

    public void setComputerNumbers(List<Integer> computerNumbers) {
        this.computerNumbers = computerNumbers;
    }
}