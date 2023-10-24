package baseball;

import java.lang.reflect.Array;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {// 게임 구동이 가능해야한다. 최대한 간단하게 적어보자.
    public static void main(String[] args) {

        System.out.println ("숫자 야구 게임을 시작합니다.");
        Game goodAnswer = new Game();
        Game.init(goodAnswer);
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

    static boolean arrayContains(final char[] arr, final char number) {
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
    private static final int NEW_GAME = 1;
    private static final int QUIT_GAME = 2;

    int[]number=new int[3]; //number는 내가 입력한 숫자.

    //게임 돌아가는 알고리즘(숫자 비교)
    Game(){
        int RandNum;
        int Numbidx=0;


        while (Numbidx<3){
            RandNum=this.getRandomNumber();

            if(!arrayList.arrayContains(number, RandNum)){
                number[Numbidx++]=RandNum;
            }
        }
    } //random numb 입력받기 (randnum이 이미 존재하지 않는 경우에만 값을 추가)

    //게임 시작 후 숫자 넣기 (문자열 변환까지)
    Game (String str){
        for(int i=0;i<3;i++){
            number[i]=Integer.parseInt(str.charAt(i)+"");
        }
    }

    //게임 랜덤숫자 뽑기 함수
    private int getRandomNumber(){

        return pickNumberInRange(1,9);
    }

    //게임 시작했을 때 안에 들어가는 값.
    public static void init(Game goodAnswer ){
        Game answer = Game.GamePlay();

        Hint hint = new Hint();
        hint.compare(answer,goodAnswer);
        hint.showResult();

        if(hint.strike!=3){
            Game.init(goodAnswer);
            return;
        }

        int newGameAnswer=Game.NewGame();
        if(newGameAnswer == Game.NEW_GAME){
            goodAnswer=new Game();
            Game.init(goodAnswer);
        }


    }


    //게임 시작했을때 돌아가는 것
    public static Game GamePlay() {
        System.out.println("숫자를 입력해주세요 : ");
        String userInput = readLine();
        Game.checkValue(userInput);

        return new Game(userInput);
    }

    //새 게임 스타트 알고리즘
    public static int NewGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 "+Game.NEW_GAME+", 게임을 종료하려면 "+Game.QUIT_GAME+"를 입력하세요.");

        String newanswer=readLine();
        int intValue;

        try{
            intValue=Integer.parseInt(newanswer);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException();
        }

        if(intValue !=1&&intValue!=2){
            throw new IllegalArgumentException();
        }

        return intValue;
    }

    public String toString(){
        return "number: "+this.number[0]+this.number[1]+this.number[2];
    }

    public static void checkValue(final String str){
        if(!Game.checkInputLength(str)){
            throw new IllegalArgumentException();
        }
        if(!Game.checkInputNumb(str)){
            throw new IllegalArgumentException();
        }
        if (!Game.checkEqualNumber(str)){
            throw new IllegalArgumentException();
        }

    }



    private static boolean checkEqualNumber(String str) {
        char[] checkEqual=new char[str.length()];
        char[] word = arrayList.getCharArrayFromString(str);

        for(int i=0;i<str.length();i++){
            if(arrayList.arrayContains(checkEqual,word[i])){
                return false;
            }
            checkEqual[i]=word[i];
        }
        return true;


    }

    private static boolean checkInputNumb(String str) {
        try{
            int numberValue = Integer.parseInt(str);
        }catch (NumberFormatException e){
            return false;
        }
        char[]numberArray= arrayList.getCharArrayFromString(str);
        return !arrayList.arrayContains(numberArray,'0');
    }

    private static boolean checkInputLength(String str) {
        return str.length()==3;
    }

}

class Hint {
    int ball,strike;

    private void BallCount(){
        this.ball++;
    }

    private void StrikeCount(){
        this.strike++;
    }

    void compare(Game answer, Game goodAnswer) {
        int nowNumb;

        for(int i=0;i<3;i++){
            nowNumb=answer.number[i];

            if(!arrayList.arrayContains(goodAnswer.number,nowNumb)){
                continue;

            }
            if(i==arrayList.getIndex(goodAnswer.number,nowNumb)){
                StrikeCount();
                continue;
            }
            BallCount();
        }


    }

    void showResult(){
        String rs="";
        if(this.ball !=0){
            rs+=this.ball+"볼";
        }

        if(this.strike != 0){
            if(this.ball!=0){
                rs+=" ";
            }
            rs+=this.strike + "스트라이크";

        }

        if(rs.equals("")){
            rs = "낫싱";
        }

        System.out.println(rs);

    }


}