package baseball;
import java.util.Scanner;

public class Application {// 게임 구동이 가능해야한다. 최대한 간단하게 적어보자.

    public static void main(String[] args) {


    }

}

class arrayList { //배열적으로 받아서 처리할 수 있는 모든 함수들은 여기에 적었다.
    static boolean arrayContains(final int[] arr, final int number) {
        for (int value : arr) {
            if (value == number) {
                return true;
            }
        }
        return false;
    } //그 배열에 실제 그 단어가 있는지 확인하기 위해서

    static char[] getCharArrayFromString(String str) {
        char[] charArr = new char[str.length()];

        for (int i = 0; i < str.length(); i++) {
            charArr[i] = str.charAt(i);
        }
        return charArr;
    } //문자열로 되어있는 str을 문자 하나하나 쪼개서 charArr배열 안에 집어 넣어야 한다.

    static int getIndex(final int[]arr,final int value){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==value){
                return i;
            }
        }
        return -1;
    }
}


class Game{ //game을 시작할 떄 필요한 class들은 이곳에 적는다.




}

class Hint{
    int ball,strike;
    private static final String BALL = "볼";
    private static final String STRIKE= "스트라이크";
    private static final String NOTHING="낫싱";

    @Override
    public String toString() { //결과값 반환을 위해
        return "ball: "+this.ball+", strike: "+this.strike;
    }

    private void BALLCOUNT(){
        this.ball++;
    }
    private void STRIKECOUNT(){
        this.strike++;
    }

    void Compare(){

    }



}