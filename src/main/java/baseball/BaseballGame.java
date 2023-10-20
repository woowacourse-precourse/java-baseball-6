package baseball;


public class BaseballGame {
    InputReader inputReader;
    RandomNumberGenerator randomNumberGenerator;


    public BaseballGame(){
        this.inputReader = new InputReader();
        this.randomNumberGenerator = new RandomNumberGenerator();
    }

    public void play(){
        String randomNumber = this.randomNumberGenerator.generateRandomNumber();
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(true){
            int strikeCount = 0;
            int ballCount = 0;
            String inputNumber = this.inputReader.readNumber();
            System.out.println("숫자를 입력해주세요 : ");

            System.out.println();
            for (int inputNumberIndex = 0; inputNumberIndex < inputNumber.length(); inputNumberIndex++){
                for (int randomNumberIndex = 0; randomNumberIndex < randomNumber.length(); randomNumberIndex++){
                    if (inputNumber.charAt(inputNumberIndex) ==randomNumber.charAt(randomNumberIndex) ){
                        if (inputNumberIndex == randomNumberIndex){
                            strikeCount++;
                        }
                        else{
                            ballCount++;
                        }
                    }
                }
            }



        }


    }

}
