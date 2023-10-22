package baseball;

class BaseballGame{
    private HashMap<Integer, Integer> computerNumbers;
    private int[] userNumbers;

    public void play(){
        generateComputerNumbers();

        boolean gameIsOver = false;
        while(!gameIsOver){
            userNumbersInput();

            int strikeNum = countStrikes();
            int ballNum = countBalls();

            gameIsOver = gameResult(strikeNum, ballNum);
        }
    }

    public void generateComputerNumbers(){
    }

    public void userNumbersInput(){
    }

    public int countStrikes(){
    }

    public int countBalls(){
    }

    public boolean gameResult(int strikeNum, int ballNum){
    }
}
