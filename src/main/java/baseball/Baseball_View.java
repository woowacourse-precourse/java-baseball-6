package baseball;
import camp.nextstep.edu.missionutils.Console;

public class Baseball_View {

    public void Start_Message(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public String User_Input(){
        System.out.println("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public void Show_Result(String result){
        System.out.println(result);
    }

    public String ReStart_Meg(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }
}
