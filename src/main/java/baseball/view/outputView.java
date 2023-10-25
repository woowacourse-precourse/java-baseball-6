package baseball.view;

import baseball.controller.Controller;

public class outputView {
    public static final String strike = "스트라이크";
    public static final String ball = "볼";
    public static final String nothing = "낫싱";

    public void output(Controller controller){
        if (controller.getNothing() == 3) {
            System.out.println(outputView.nothing);
        }else{
            if (controller.getBall() == 0) {
                System.out.println(controller.getStrike() + outputView.strike);
            }else{
                if (controller.getStrike() == 0) {
                    System.out.println(controller.getBall() + outputView.ball);
                }else{
                    System.out.print(controller.getBall() + outputView.ball+" ");
                    System.out.println(controller.getStrike()+ outputView.strike);

                }
            }
        }
    }

}
