package baseball.domain;

public class Referee {
    int[] result;

    Referee(int[] computerNumber, Pitching pitching, Judge judge) {
        this.result = judge.getResult(computerNumber, pitching.inputNumber);
    }
}
