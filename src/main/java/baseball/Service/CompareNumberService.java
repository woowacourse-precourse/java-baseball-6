package baseball.Service;
public class CompareNumberService {

    public String CompareNumbers(String userNumber, String computerNumber){
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < userNumber.length(); i++) {
            char userDigit = userNumber.charAt(i);
            char computerDigit = computerNumber.charAt(i);

            if (userDigit == computerDigit) {
                strike++;
            } else if (computerNumber.contains(String.valueOf(userDigit))) {
                ball++;
            }
        }

        if (strike > 0 && ball > 0) {
            return strike + "스트라이크 " + ball + "볼";
        } else if (strike > 0) {
            return strike + "스트라이크";
        } else if (ball > 0) {
            return ball + "볼";
        } else {
            return "낫싱";
        }
    }
}

