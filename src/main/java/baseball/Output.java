package baseball;


public class Output {
    public void printStartGame(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public void askUserToInsertNumbers(){
        System.out.print("숫자를 입력해주세요 : ");
    }
    public void askUserToResumeOrNot(){
        System.out.println("3개의 숫자를 모두 맞추셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
