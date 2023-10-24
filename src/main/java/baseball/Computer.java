package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Computer {
    private final int minimumCanCreatedValue;
    private final int maximumCanCreatedValue;
    private ArrayList<Integer> numberList;
    private final int digitCount;

    private static int NOT_EXISTED_NUMBER = -1;
    public ArrayList<Integer> getNumberList(){
        return this.numberList;
    }

    public Computer() {
        this.minimumCanCreatedValue = Config.DEFAULT_CAN_CREATED_MINIMUM_VALUE;
        this.maximumCanCreatedValue = Config.DEFAULT_CAN_CREATED_MAXIMUM_VALUE;
        this.digitCount = Config.DEFAULT_DIGIT_COUNT;
        this.numberList = generateRandomNumberListWithNotRepeating();
    }
    public Computer(int digitCount,int minimumCanCreatedValue,int maximumCanCreatedValue) {
        this.minimumCanCreatedValue = minimumCanCreatedValue;
        this.maximumCanCreatedValue = maximumCanCreatedValue;
        this.digitCount = digitCount;
        this.numberList = generateRandomNumberListWithNotRepeating(digitCount);

    }
    private ArrayList<Integer> generateRandomNumberListWithNotRepeating(){
        return generateRandomNumberListWithNotRepeating(digitCount);
    }

    /**
     * 입력한 자리수 만큼 중복되지 않는 숫자 리스트를 생성한다
     *
     * 최소값 ( minimumCanCreatedValue ) 과 최대값 ( maximumCanCreatedValue ) 사이 값을 가진다.
     * 기존 값에 포함되지 않은 값들만 추가한다.
     *
     * @param digitCount 생성하는 숫자의 자리수
     * @return
     */
    private ArrayList<Integer> generateRandomNumberListWithNotRepeating(int digitCount){

        var randomNumberList = new ArrayList<Integer>();

        while (randomNumberList.size()<digitCount){
            int randomNumber = Randoms.pickNumberInRange(minimumCanCreatedValue,maximumCanCreatedValue);
            if (!randomNumberList.contains(randomNumber)){
                randomNumberList.add(randomNumber);
            }
        }

        return randomNumberList;
    }

    /**
     * 사용자의 숫자를 비교한 후 , 결과를 반환한다
     *
     * 사용자의 숫자와 컴퓨터의 숫자가 모두 일치하면 true 를 반환한다.
     * 그렇지 않으면,  false 를 반환한다.
     * @param playerNumber 사용자가 입력하는 숫자
     * @return boolean
     */
    public boolean checkUserNumberAndResponse(int playerNumber){

        var compareNumberList = Util.parsingNumberToNumberList(playerNumber,digitCount);

        int strikeCount = calculateStrikeCount(compareNumberList);
        int ballCount = calculateBallCount(compareNumberList);

        printResult(strikeCount,ballCount);

        return strikeCount==digitCount;
    }
    private int calculateStrikeCount(int[] compareNumberList){
        int strikeCount=0;
        for (int i =0 ; i< digitCount;i++){
            if (compareNumberList[i]==numberList.get(i)){
                strikeCount++;
                compareNumberList[i]=NOT_EXISTED_NUMBER;
            }
        }
        return strikeCount;
    }
    private int calculateBallCount(int[] compareNumberList){
        int ballCount = 0;
        for (int i =0; i<digitCount;i++){
            if (compareNumberList[i]==NOT_EXISTED_NUMBER){
                continue;
            }
            if (numberList.contains(compareNumberList[i])){
                ballCount++;
                compareNumberList[i] = -1;
            }
        }
        return ballCount;
    }

    protected void printResult(int strikeCount,int ballCount){
        StringBuilder resultBuilder = new StringBuilder();
        if (strikeCount==0 && ballCount == 0){
            resultBuilder.append("낫싱");
        }
        if (ballCount!=0) {
            resultBuilder.append(ballCount).append("볼 ");
        }
        if (strikeCount!=0){
            resultBuilder.append(strikeCount).append("스트라이크");
        }
        String result = resultBuilder.toString();
        System.out.println(result);
    }
    public void reGenerateNumberList(){
        this.numberList = generateRandomNumberListWithNotRepeating(digitCount);
    }
}
