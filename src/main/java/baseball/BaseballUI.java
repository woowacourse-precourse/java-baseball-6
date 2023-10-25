package baseball;

//게임의 시작, 입력, 재시작 메시지를 출력하는 단순한 출력 메서드
public class BaseballUI {
    public void printStart(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public void printInput(){
        System.out.println("숫자를 입력해주세요 : ");
    }
    public void printEndGame() { System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료"); }
    public void printReStart(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
