package baseball;


public class Test {

    @org.junit.jupiter.api.Test
    public void randomTest(){
        NumberBoard numberBoard = NumberBoard.makeRandomBoard();
        Player player = new Player(numberBoard);
        int size = numberBoard.size();

        for(int i=0; i<size; i++){
            System.out.println(numberBoard.get(i));
        }
    }

    @org.junit.jupiter.api.Test
    public void inputTest(){
        NumberBoard numberBoard1 = new NumberBoard("012");
        NumberBoard numberBoard2 = new NumberBoard("748");
        Player player1 = new Player(numberBoard1);
        Player player2 = new Player(numberBoard2);
        int size = numberBoard1.size();

        for(int i=0; i<size; i++){
            System.out.println("numberBoard1 = " + numberBoard1.get(i));
        }
        for(int i=0; i<size; i++){
            System.out.println("numberBoard2 = " + numberBoard2.get(i));
        }
    }

    @org.junit.jupiter.api.Test
    public void mvcTest(){
        NumberBoard numberBoard = new NumberBoard("012");
        Player player = new Player(numberBoard);
        int size = numberBoard.size();

        BaseballGameController controller = new BaseballGameController();
        BaseballGameView view = new BaseballGameView();

        BaseBallGameModel model1 = controller.guess(player, "123");
        BaseBallGameModel model2 = controller.guess(player, "021");
        BaseBallGameModel model3 = controller.guess(player, "345");
        BaseBallGameModel model4 = controller.guess(player, "012");

        view.print(model1);
        view.print(model2);
        view.print(model3);
        view.print(model4);
    }
}
