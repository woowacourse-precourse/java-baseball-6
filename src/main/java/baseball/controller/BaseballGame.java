package baseball.controller;

public class BaseballGame {
    private String exitNumber = "1";
    Illegal check = new Illegal();


    public void baseballGameStart() {
        System.out.println(exitGame(exitNumber));
        run();
        while (exitGame(exitNumber)) {
            run();
        }
    }

    public void run() {
        GenerateNumber number = new GenerateNumber();
        number.createRandomNumber();
    }

    public boolean exitGame(String num) {
        int exitNumber = check.parseIntNumber(num);
        CompareLogic compareLogic = new CompareLogic();
        return compareLogic.checkExitGame(exitNumber);
    }
}
