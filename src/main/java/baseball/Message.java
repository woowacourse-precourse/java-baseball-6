package baseball;

public class Message {
    //TODO
    // - `printScore()` : 몇개를 맞췄는지 출력하는 함수
    // - `printAskMessage()` : "숫자를 입력하세요 :"
    // - `printStartMessage()` : 시작 메세지 출력
    // - `printEndMessage()` : 종료 메세지 출력
    // - `printRetryMessage()` : 재시작 메세지 출력
    public void printStartMessage(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printAskMessage(String num){
        System.out.println("숫자를 입력해주세요 : "+num);
    }
    public void printScore(int strikeCount, int ballCount){
        if(strikeCount == 0 && ballCount == 0) {
            System.out.println("낫싱");
        }
        else if(strikeCount == 0) {
            System.out.println(ballCount+"볼");
        }
        else if(ballCount == 0){
            System.out.println(strikeCount+"스트라이크");
        }
        else{
            System.out.println(ballCount+"볼 "+strikeCount+"스트라이크");
        }
    }

    public void printEndMessage(int size){
        System.out.println(size+"스트라이크\n"+size+"개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void printRetryMessage(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

}
