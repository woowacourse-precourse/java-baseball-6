package baseball.domain;

public class Baseball {

    private int number;

    public int getNumber() {
        return  number;
    }

    public void setNumber(int newNumber) { this.number = newNumber; }

    public Baseball(int number) {
        this.number = number;
    }

    /**
     * 정답인 경우
     * @param input
     * @return
     */
    public boolean equals(int input) {
        return number == input;
    }

    /**
     * 스트라이크 - 자리, 숫자도 같은 경우
     * @param input
     * @return
     */
    public int getStrikeNumber(int input) {
        int result = 0;
        String numberStr = String.valueOf(number);
        String inputStr = String.valueOf(input);
        for (int i = 0; i < numberStr.length(); i++) {
            if (numberStr.charAt(i) == inputStr.charAt(i)) result++;
        }
        return result;
    }

    /**
     * 볼 - 숫자는 같은데 자리가 다른 경우
     * @param input
     * @return
     */
    public int getBallNumber(int input) {
        int result = 0;
        String numberStr = String.valueOf(number);
        String inputStr = String.valueOf(input);
        for (int i = 0; i < numberStr.length(); i++) {
            for (int j = 0; j < inputStr.length(); j++) {
                if (i == j) continue;
                if (numberStr.charAt(i) == inputStr.charAt(j)) result++;
            }
         }
        return result;
    }

    /**
     * 낫싱
     * @param input
     * @return
     */
    public boolean checkNothing(int input) {
        boolean result = true;
        String numberStr = String.valueOf(number);
        String inputStr = String.valueOf(input);
        for (int i = 0; i < inputStr.length(); i++) {
            if (numberStr.contains(String.valueOf(inputStr.charAt(i)))) {
                result = false;
            }
        }
        return result;
    }
}
