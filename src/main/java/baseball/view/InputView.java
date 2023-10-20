package baseball.view;
import camp.nextstep.edu.missionutils.Console;

import javax.xml.crypto.dom.DOMCryptoContext;
import java.util.HashSet;

public class InputView {
    private static final String INPUT_NUM_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String GAME_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static String inputNum(){
        System.out.print(INPUT_NUM_MESSAGE);
        String inputNum = Console.readLine();
        judgeCorrectInputNum(inputNum);
        return inputNum;
    }
    public static int restart(){
        System.out.println(GAME_RESTART_MESSAGE);
        int num = Integer.parseInt(Console.readLine());
        return num;
    }

    public static void judgeCorrectInputNum(String num){

        // TODO: 길이가 3인지 검증
        if(num.length() !=3){
            throw new IllegalArgumentException("길이가 3이 아닙니다.");
        }
        // TODO: 0이 없는지 검증
        if (num.contains("0")) {
            throw new IllegalArgumentException("0은 입력할수 없습니다.");
        }
        // TODO: 3개의 숫자가 모두 다른지 검증
        HashSet<Character> inputNumSet = new HashSet<>();
        for(char x  :num.toCharArray()){
            inputNumSet.add(x);
        }
        if(inputNumSet.size()<3){
            throw new IllegalArgumentException("서로 다른 숫자를 입력해야합니다.");
        }



    }


}
