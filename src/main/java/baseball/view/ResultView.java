package baseball.view;

public class ResultView {

    public void doneView(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void ballView(int BALL){
        System.out.print(BALL + "볼 ");
    }

    public void strikeView(int STRIKE){
        System.out.println(STRIKE + "스트라이크");
    }

    public void nothingView(){
        System.out.println("낫싱");
    }
}
