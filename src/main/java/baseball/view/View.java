package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class View {
    public void printStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public String getStringOfNum() {
        System.out.print("숫자를 입력해주세요 : ");
        String StringOfNum = Console.readLine();

        if(StringOfNum.length() != 3 || isInt(StringOfNum) == false){
            throw new IllegalArgumentException("3자리 숫자가 아닙니다.");
        }

        return StringOfNum;
    }

    public boolean isInt(String gameInput){
        for(int i=0 ; i<gameInput.length() ; i++){
            char currentChar = gameInput.charAt(i);

            if(Character.isDigit(currentChar) == false)
                return false;
        }

        return true;
    }

    public static Boolean getBooleanOfFinish(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String finishInput = Console.readLine();

        if(finishInput.equals("1")){
            return true;
        }
        else if (finishInput.equals("2")){
            return false;
        }
        else {
            throw new IllegalArgumentException("1과 2중에 선택하세요.");
        }
    }
}
