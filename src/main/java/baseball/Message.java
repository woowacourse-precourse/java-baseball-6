package baseball;

public class Message {
    public void hintMessage(int strike, int ball){
        if(ball>0 && strike>0){
            System.out.println(String.format("%d볼 %d스트라이크", ball, strike));
        }
        if(ball>0 && strike==0){
            System.out.println(String.format("%d볼", ball));
        }
        if(ball==0 && strike>0){
            System.out.println(String.format("%d스트라이크", strike));
            if(strike==3){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            }
        }
        if(ball==0 && strike==0){
            System.out.println("낫싱");
        }
    }
}
