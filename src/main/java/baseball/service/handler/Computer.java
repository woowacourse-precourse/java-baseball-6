package baseball.service.handler;

import camp.nextstep.edu.missionutils.Randoms;


public class Computer {
    String computerNumber; //컴퓨터의 random number

    /**
     * Computer Constructor
     * <p>
     * 랜덤 수 생성해 computerNumber에 할당하는 생성자
     * </p>
     *
     * @param startRange     : startRange
     * @param endRange       : endRange
     * @param numberOfDigits : 자리수
     */
    public Computer(int startRange, int endRange, int numberOfDigits) {
        this.computerNumber = getRandomNumber(startRange, endRange, numberOfDigits);
    }

    /**
     * Get random number
     * <p>
     * numberOfDigits자리수고 각 자리수가 startRange ~ endRange 사이이며, 각 자리수가 서로다른 수인 랜덤수를 리턴하는 함수
     * </p>
     *
     * @param startRange :시작 범위
     * @param endRange   : 끝나는 범위
     * @return String : random number
     */
    private String getRandomNumber(int startRange, int endRange, int numberOfDigits) {
        StringBuilder number = new StringBuilder();

        //number가 numberOfDigits자리수가 될때까지 반복
        while (number.length() < numberOfDigits) {
            //렌덤수 생성
            int randomNumber = Randoms.pickNumberInRange(startRange, endRange);

            //randomNumber이 number에 없을 경우 append
            if (!(number.toString()).contains(String.valueOf(randomNumber))) {
                number.append(randomNumber);
            }
        }
        return number.toString();
    }


    /**
     * computerNumber getter
     *
     * @return computerNumber
     */
    public String getComputerNumber() {
        return this.computerNumber;
    }
}
