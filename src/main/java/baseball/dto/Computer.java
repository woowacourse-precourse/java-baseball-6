package baseball.dto;

public class Computer {
    private String input = "";
    private int[] computerNumberBall;

    public Computer() {
    }

    public Computer(String input, int[] computerNumberBall) {
        this.input = input;
        this.computerNumberBall = computerNumberBall;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public int[] getComputerNumberBall() {
        return computerNumberBall;
    }

    public void setComputerNumberBall(int[] computerNumberBall) {
        this.computerNumberBall = computerNumberBall;
    }
}
