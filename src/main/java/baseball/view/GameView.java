package baseball.view;

public interface GameView {

    void printStart();
    String getInputNumber();
    String getRestart();
    void printExit();
    void printBallScore(int score);
    void printStrikeScore(int score);
    void printBothScore(int ball, int strike);
    void printNoneScore();
}
