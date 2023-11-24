package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Check{
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
        if (!Check.checkRepeat(ans)){
            throw new IllegalArgumentException();
        }
        if (!Check.checkNum(ans)){
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

    static int CheckRestart(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String GameRestart = readLine();
        int Restart;
        try{
            Restart = Integer.parseInt(GameRestart);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
        if (Restart != 1 && Restart != 2){
            throw new IllegalArgumentException();
        }
        return Restart;
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
