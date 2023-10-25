package baseball.domain;

public class NumberCompare {
    private static final int SIZE = 3;
    private final Computer computer;
    public NumberCompare(Computer computer) {
        this.computer = computer;
    }
    public int getStrikes(UserNumbers userNumbers) {
        int strikes = 0;
        for (int i = 0; i < SIZE; i++) {
            if (computer.computerNumber.get(i).equals(userNumbers.userNumber.get(i))) {
                strikes++;
            }
        }
        return strikes;
    }
    public int getBalls(UserNumbers userNumbers) {
        int balls = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (i != j && computer.computerNumber.get(i).equals(userNumbers.userNumber.get(j))) {
                    balls++;
                }
            }
        }
        return balls;
    }
    public String getResult(UserNumbers inputUserNumber) {
        String result;
        int strikes = getStrikes(inputUserNumber);
        int balls = getBalls(inputUserNumber);
        if (strikes != 0 && balls != 0){
            result = balls + "볼 " + strikes + "스트라이크";
            return result;
        }
        if (strikes == 0 && balls != 0){
            result = balls + "볼";
            return result;
        }
        if (strikes != 0){
            result = strikes + "스트라이크";
            return result;
        }
        result = "낫싱";
        return result;
    }
}
