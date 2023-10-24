package baseball.service.handler;

import camp.nextstep.edu.missionutils.Randoms;


public class Computer {
    String computer_number; //컴퓨터의 random number

    /**
     * Computer Constructor
     * <p>
     * 랜덤 수 생성해 computer_number에 할당하는 생성자
     * </p>
     *
     * @param start_range      : startRange
     * @param end_range        : endRange
     * @param number_of_digits : 자리수
     */
    public Computer(int start_range, int end_range, int number_of_digits) {
        this.computer_number = getRandomNumber(start_range, end_range, number_of_digits);
    }

    /**
     * Get random number
     * <p>
     * number_of_digits자리수고 각 자리수가 start_range ~ end_range 사이이며, 각 자리수가 서로다른 수인 랜덤수를 리턴하는 함수
     * </p>
     *
     * @param start_range :시작 범위
     * @param end_range   : 끝나는 범위
     * @return String : random number
     */
    private String getRandomNumber(int start_range, int end_range, int number_of_digits) {
        StringBuilder number = new StringBuilder();

        //number가 number_of_digits자리수가 될때까지 반복
        while (number.length() < number_of_digits) {
            //렌덤수 생성
            int randomNumber = Randoms.pickNumberInRange(start_range, end_range);

            //randomNumber이 number에 없을 경우 append
            if (!(number.toString()).contains(String.valueOf(randomNumber))) {
                number.append(randomNumber);
            }
        }
        return number.toString();
    }


    /**
     * computer_number getter
     *
     * @return computer_number
     */
    public String getComputerNumber() {
        return this.computer_number;
    }
}
