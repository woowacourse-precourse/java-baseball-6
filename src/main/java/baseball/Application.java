package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

class Model{

}

class View{
    final static String inputNumberSpeak = "숫자를 입력해주세요 : ";
    final static String startGameSpeak = "숫자 야구 게임을 시작합니다.";
    final static String startOrEndSpeak = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    final static String gameEndSpeak = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    final static String notThingSpeak = "낫싱";
    final static String ballSpeak = "볼";
    final static String strikeSpeak = "스트라이크";
    final static String inputIsUnvalid = "잘못된 값을 입력하였습니다.";
    static List<Integer> inputNumber(){
        String inputString = Console.readLine();
        if(inputString.length()!=3){
            throws new IllegalArgumentException(inputIsUnvalid);
        }
        List<Integer> inputList = new ArrayList<>();
        for(int i=0;i<3;i++){
            inputList.add(inputString.charAt(i));
        }
        return inputList;
    }
    static boolean startOrEnd(){
        System.out.println(startOrEndSpeak);
        int choice = Integer.pareseInt(Console.readLine());

        if(choice ==1)
            return true;
        else
            return false;
    }
}


class Controller{

}


public class Application {
    public static void main(String[] args) {
        start();
    }
}
