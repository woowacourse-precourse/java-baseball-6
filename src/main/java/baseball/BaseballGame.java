package baseball;

public class BaseballGame {
    private Player player;
    private RandomNumber randomNumber;
    private final int digitCount;

    public BaseballGame(){
        this.digitCount = 3;
        this.player = new Player(this.digitCount);
        this.randomNumber = new RandomNumber(this.digitCount);
    }

    public void play(){
        this.randomNumber.generateRandomNumber();
        System.out.println("숫자 야구 게임을 시작합니다.");

        while(true){
            System.out.print("숫자를 입력해주세요 : ");
            this.player.takeThreeNumberInput();

            int strikeCount = 0;
            int ballCount = 0;
            for (int userInputSequence = 0; userInputSequence < this.player.getInputCount(); userInputSequence++){
                PitchingResult pitchingResult = this.getPitchingResult(userInputSequence);
                if (pitchingResult.equals(PitchingResult.BALL)){
                    ballCount++;
                }
                if (pitchingResult.equals(PitchingResult.STRIKE)){
                    strikeCount++;
                }
            }


            this.printPitchingResult(strikeCount, ballCount);

            if (strikeCount == this.digitCount){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                GameAction gameAction = this.checkContinuity();
                if (gameAction.equals(GameAction.QUIT)){
                    break;
                } else if (gameAction.equals(GameAction.CONTINUE)){
                    this.randomNumber.generateRandomNumber();
                }
            }
        }
    }

    private PitchingResult getPitchingResult(int userInputSequence){
        return this.randomNumber.checkPitchingResult(this.player.getNumberAt(userInputSequence), userInputSequence);
    }
    private GameAction checkContinuity(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return this.player.takeGameAction();
    }
    private void printPitchingResult(int strikeCount, int ballCount){
        if ((ballCount + strikeCount) == 0){
            System.out.println("낫싱");
            return;
        }
        if (ballCount != 0){
            if (strikeCount != 0){
                System.out.println(ballCount +"볼 " + strikeCount + "스트라이크");
                return;
            }
            System.out.println(ballCount +"볼");
            return;
        }
        System.out.println(strikeCount + "스트라이크");
    }
}
