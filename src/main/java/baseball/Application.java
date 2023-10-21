package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;
public class Application {
    public static void main(String[] args) {

    }
}

class Game {
    private  static final String InputNumberMessage = "숫자를 입력해주세요 : ";
    private  static final String CheckingRestart = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private int RandomNumber(){ // 1~9까지 랜덤 숫자 생성
        return pickNumberInRange(1,9);
    }

    int[] Answer = new int[3];
    Game(){
        int num;
        for (int i=0; i<3; i++){  // 컴퓨터가 임의의 숫자 3개 선택 (정답 숫자)
            num = this.RandomNumber();
            if (!Check.RepeatNumber(Answer,num)){
                Answer[i] = num;
            }
        }
    }

    Game(String str){
        for (int i=0; i<3; i++){
            Answer[i] = Integer.parseInt(str.charAt(i) + "");
        }
    }

    static char[] stringToChar(String str){
        char[] charArray = new char[str.length()];
        for (int i=0; i<str.length(); i++){
            charArray[i] = str.charAt(i);
        }
        return charArray;
    }

    private static Game UserNumber(){ // 사용자로부터 숫자 입력받기
        System.out.print(InputNumberMessage);
        String UserAnswer = readLine();
        Check.CheckInput(UserAnswer); // 입력 받은 숫자가 조건들을 만족하는지 체크
        return new Game(UserAnswer); // 문자열을 숫자로 변환
    }


}

class Check{
    static boolean RepeatNumber(int[] arr, int number){  // 각 자리 숫자가 중복되지 않도록 체크
        for (int num : arr) {
            if (num == number) { // 중복된 숫자가 있을 경우
                return true;
            }
        }
        return false;
    }
    static boolean RepeatNumber(char[] arr, char number){  // 각 자리 숫자가 중복되지 않도록 체크
        for (int num : arr) {
            if (num == number) { // 중복된 숫자가 있을 경우
                return true;
            }
        }
        return false;
    }

    static void CheckInput(final String ans){ // 사용자가 입력받은 답 체크
        if (ans.length() != 3){
            throw new IllegalArgumentException();
        }
        if (Check.checkRepeat(ans)){
            throw new IllegalArgumentException();
        }
        if (Check.checkNum(ans)){
            throw new IllegalArgumentException();
        }

    }

    static boolean checkRepeat(String str){
        char[] store = new char[str.length()];
        char[] word = Game.stringToChar(str);

        for (int i=0; i<str.length();i++){
            if (Check.RepeatNumber(store,word[i])){
                return false;
            }
            store[i] = word[i];
        }
        return true;
    }

    static boolean checkNum(String str){
        try{
            int Value = Integer.parseInt(str);
        } catch (NumberFormatException e){
            return false;
        }
        char[] NumArray = Game.stringToChar(str);
        return !Check.RepeatNumber(NumArray,'0');
    }
}

