package baseball.view;

public class Output {
    public boolean start(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        return true;
    }
    public void InputNumber(){
        System.out.print("숫자를 입력해주세요 : ");
    }
    public void end(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
    public boolean gameOver(){
        System.out.println("게임 종료");
        return false;
    }
    public void score(String answer){
        System.out.println(answer);
    }
}
