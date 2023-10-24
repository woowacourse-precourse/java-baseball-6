package baseball.service;

public class MessageService {
    
    public void gameStart(){
        System.out.println("숫자 야구게임을 시작합니다.");
    }
    
    public void numberInput(){
        System.out.print("숫자를 입력 해주세요: ");
    }


    public void gameOver(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
