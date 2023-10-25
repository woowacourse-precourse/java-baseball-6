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
        this.computerNumber = getComputerNumber(startRange, endRange, numberOfDigits);
    }

    /**
     * 게임에서 사용되는 컴퓨터의 숫자(게임의 정답)을 리턴하는 함수
     * <p>
     * numberOfDigits자리수고 각 자리수가 startRange ~ endRange 사이이며,
     * <br>각 자리수가 서로다른 수인 랜덤수를 리턴하는 함수
     * </p>
     *
     * @param startRange :시작 범위
     * @param endRange   : 끝나는 범위
     * @return resultNumber(String Type)
     */
    private String getComputerNumber(int startRange, int endRange, int numberOfDigits) {
        StringBuilder resultNumber = new StringBuilder();

        //resultNumber numberOfDigits자리수가 될때까지 반복
        while (resultNumber.length() < numberOfDigits) {

            //렌덤수 생성
            String randomNum = getRandomNumByStr(startRange, endRange);

            //resultNumber에 randomNum 없을 경우 append
            if (resultNumber.indexOf(randomNum) == -1) {
                resultNumber.append(randomNum);
            }
        }
        return resultNumber.toString();
    }

    /**
     * Returns a number in the form of String
     * <p>
     * startRange ~ endRange 사이의 랜덤수(문자열 형식) 리턴 함수
     * </p>
     *
     * @param startRange :시작 범위
     * @param endRange   :끝나는 범위
     * @return random number(String Type)
     */
    private String getRandomNumByStr(int startRange, int endRange) {
        int randomNum = Randoms.pickNumberInRange(startRange, endRange);
        return String.valueOf(randomNum);
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
