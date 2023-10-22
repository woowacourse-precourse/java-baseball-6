package baseball.view;

public interface GameView {
    String getInputNumber();
    String getRestart();
    void printStart();
    void printExit();
    void printBallScore(int score);
    void printStrikeScore(int score);
    void printBothScore(int ball, int strike);
    void printNoneScore();
}
