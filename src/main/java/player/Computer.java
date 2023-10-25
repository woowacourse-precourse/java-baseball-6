package player;

import model.NumberGenerator;

public class Computer {
    private NumberGenerator computer;
    private boolean isThreeStrike;
    public Computer() {
        computer = new NumberGenerator();
        isThreeStrike = false;
    }

    public int ballCount(String generatedNumber, String inputNumber) {
        int ball = 0;
        for (int i = 0; i < inputNumber.length(); i++) {
            if (inputNumber.contains(String.valueOf(generatedNumber.charAt(i)))) {
                ball++;
            }
        }

        return ball;
    }

    public int strikeCount(String generatedNumber, String inputNumber) {
        int strike = 0;
        for (int i = 0; i < inputNumber.length(); i++) {
            if (generatedNumber.charAt(i) == inputNumber.charAt(i)) {
                strike++;
            }
        }

        if(strike == 3) {
            isThreeStrike = true;
        }

        return strike;
    }

    public int[] getHint(String inputNumber) {
        int ball = ballCount(computer.getGeneratedNumber(), inputNumber);
        int strike = strikeCount(computer.getGeneratedNumber(), inputNumber);

        return new int[] {ball - strike, strike};
    }

    public boolean getIsThreeStrike() {
        return isThreeStrike;
    }

}
