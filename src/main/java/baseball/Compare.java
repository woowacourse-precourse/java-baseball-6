package baseball;

public class Compare {

        public static String compare(String randomNumber, String input) {
                int strike = 0;
                int ball = 0;

                for (int i = 0; i < randomNumber.length(); i++) {
                        if (randomNumber.charAt(i) == input.charAt(i)) {
                                strike++;
                        } else if (randomNumber.contains(String.valueOf(input.charAt(i)))) {
                                ball++;
                        }
                }

                return getResult(strike, ball);
        }

        private static String getResult(int strike, int ball) {
                if (strike == 0 && ball == 0) {
                        return "낫싱";
                }

                if (strike == 3) {
                        return "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
                }

                if (strike == 0) {
                        return ball + "볼";
                }

                if (ball == 0) {
                        return strike + "스트라이크";
                }

                return ball + "볼 " + strike + "스트라이크";
        }


}
