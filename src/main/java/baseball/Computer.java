package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Computer {
    private static final int defaultDigitalCount = 3;
    private static final int minimumCanCreatedValue = 1;
    private static final int maximumCanCreatedValue = 9;
    private final ArrayList<Integer> numberList;
    private final int digitCount;
    public ArrayList<Integer> getNumberList(){
        return this.numberList;
    }

    public Computer() {
        this.numberList = generateRandomNumberListWithNotRepeating();
        this.digitCount = defaultDigitalCount;
    }
    public Computer(int digitCount) {
        this.numberList = generateRandomNumberListWithNotRepeating(digitCount);
        this.digitCount = digitCount;
    }
    private ArrayList<Integer> generateRandomNumberListWithNotRepeating(){
        return generateRandomNumberListWithNotRepeating(defaultDigitalCount);
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
    public Boolean checkUserNumberAndResponse(int playerNumber){

        int ballCount = 0;
        int strikeCount = 0;

        var compareNumberList = parsingNumberToNumberList(playerNumber);
        for (int i =0 ; i< digitCount;i++){
            if (compareNumberList[i]==numberList.get(i)){
                strikeCount++;
                compareNumberList[i]=-1;
            }
        }
        for (int i =0; i<digitCount;i++){
            if (compareNumberList[i]==-1){
                continue;
            }
            if (numberList.contains(compareNumberList[i])){
                ballCount++;
                compareNumberList[i] = -1;
            }
        }

        printResultWithCount(ballCount,strikeCount);

        if (strikeCount==3){
            return true;
        }
        return false;
    }
    private int[] parsingNumberToNumberList(int parsingNumber) {
        int sliceUnit = (int) Math.pow(10, digitCount - 1);
        var numberList = new int[digitCount];
        for (int i = 0; i < digitCount; i++) {
            int number = parsingNumber / sliceUnit;
            numberList[i]=number;
            parsingNumber %= sliceUnit;
            sliceUnit /= 10;
        }
        return numberList;
    }

    protected void printResultWithCount(int strikeCount,int ballCount){
        StringBuilder resultBuilder = new StringBuilder();
        if (strikeCount==0 && ballCount == 0){
            resultBuilder.append("낫싱");
        }
        if (ballCount!=0) {
            resultBuilder.append(ballCount);
            resultBuilder.append("볼");
        }
        if (strikeCount!=0){
            resultBuilder.append(" ");
            resultBuilder.append(strikeCount);
            resultBuilder.append("스트라이크");
        }
        String result = resultBuilder.toString();
        System.out.println(result);
        return;
    }

}
