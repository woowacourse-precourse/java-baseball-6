package baseball.service.handler;

import static baseball.service.Game.NUMBER_OF_DIGITS;

import camp.nextstep.edu.missionutils.Randoms;


public class Computer {
    String computer_number; //컴퓨터의 random number

    /**
     * Computer Constructor : Create computer number
     *
     * @param start_range : startRange
     * @param end_range   : endRange
     */
    public Computer(int start_range, int end_range) {
        this.computer_number = getRandomNumber(start_range, end_range);
    }

    /**
     * Get random number
     * <p>
     * 상대방(컴퓨터)의 랜덤수
     * </p>
     *
     * @param start_range :시작 범위
     * @param end_range   : 끝나는 범위
     * @return String : random number
     */
    private String getRandomNumber(int start_range, int end_range) {
        StringBuilder number = new StringBuilder();

        while (number.length() < NUMBER_OF_DIGITS) {
            int randomNumber = Randoms.pickNumberInRange(start_range, end_range);
            if (!(number.toString()).contains(String.valueOf(randomNumber))) {
                //randomNumber이 number에 없을 경우 append
                number.append(randomNumber);
            }
        }
        return number.toString();
    }


    public String getComputerNumber() {
        return this.computer_number;
    }
}
