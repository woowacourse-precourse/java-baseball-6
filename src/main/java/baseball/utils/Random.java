package baseball.utils;
import camp.nextstep.edu.missionutils.Randoms;

//3자리 난수 생성을 위한 클래스
public class Random {

    public static int[] getRandom(){
        int[] numbers = new int[3];
        for(int i = 0; i <3; i++){
            numbers[i] = getUniqueNum(numbers, i);
        }

        return numbers;
    }

    private static int getUniqueNum(int[] nums, int i) {
        int newNum;
        while (true) {
            newNum = Randoms.pickNumberInRange(1, 9);
            if (isUnique(nums, i, newNum)) {
                break;
            }
        }
        //debug
/*        System.out.println(newNum);*/
        return newNum;
    }
    private static Boolean isUnique(int[] nums, int i, int newNum){
        for(int k = 0; k<i; k++){
            if (nums[k] == newNum){
                return false;
            }
        }
        return true;
    }


}
