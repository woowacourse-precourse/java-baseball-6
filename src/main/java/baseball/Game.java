package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Game {
    private int RandomNumber(){ // 1~9까지 랜덤 숫자 생성
        return pickNumberInRange(1,9);
    }

    int[] Answer = new int[3];
    Game(){
        int index= 0;
        while (index<3){  // 컴퓨터가 임의의 숫자 3개 선택 (정답 숫자)
            int num = this.RandomNumber();
            if (!Check.RepeatNumber(Answer,num)){
                Answer[index++] = num;
            }
        }
    }

    Game(String str){
        for (int i=0; i<3; i++){
            Answer[i] = Integer.parseInt(str.charAt(i) + "");
        }
    }

    public static void init(Game target){
        Game Useranswer = Game.UserNumber();

        Hint hint = new Hint();
        hint.Compare(Useranswer, target);
        hint.PrintResult();

        if (hint.strike != 3){
            Game.init(target);
            return;
        }

        int Restart = Check.CheckRestart();
        if (Restart == 1){
            target = new Game();
            Game.init(target);
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
        System.out.print("숫자를 입력해주세요 : ");
        String UserAnswer = readLine();
        Check.CheckInput(UserAnswer); // 입력 받은 숫자가 조건들을 만족하는지 체크
        return new Game(UserAnswer); // 문자열을 숫자로 변환
    }

}
