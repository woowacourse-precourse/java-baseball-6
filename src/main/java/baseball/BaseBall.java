package baseball;

/***
 * 야구 게임 숫자
 */
public class BaseBall {
    private int firstNumber;
    private int secondNumber;
    private int thirdNumber;

    public BaseBall(final int first, final int second, final int third){
        this.firstNumber=first;
        this.secondNumber=second;
        this.thirdNumber=third;
    }

    /***
     * BaseBall이 소유하고있는 숫자를 3칸짜리 인덱스를 가진 배열로 반환해준다.
     * @return {소유숫자 1, 소유숫자 2, 소유숫자 3}
     */
    public int[] getNumbers(){
        return new int[]{firstNumber, secondNumber, thirdNumber};
    }
}
