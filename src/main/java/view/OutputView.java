package view;

import computer.Hint;

public class OutputView {
    public void viewHint(){
        Hint hint=new Hint();
        if(hint.loadBall()!=0 && hint.loadStrike()!=0){
            System.out.println(hint.loadBall()+"볼 "+hint.loadStrike()+"스트라이크");
            return;
        }
        if(hint.loadBall()!=0 && hint.loadStrike()==0){
            System.out.println(hint.loadBall()+"볼");
            return;
        }
        if(hint.loadBall()==0 && hint.loadStrike()!=0){
            System.out.println(hint.loadStrike()+"스트라이크");
            return;
        }
        if(hint.loadBall()==0 && hint.loadStrike()==0){
            System.out.println("낫싱");
            return;
        }
    }
}
