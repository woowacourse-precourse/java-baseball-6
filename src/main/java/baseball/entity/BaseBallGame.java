package baseball.entity;

public class BaseBallGame {
    private final UserInput userInput;
    private final Random random;
    private final Hint hint;

    private boolean correct = false;

    private boolean restart = false;

    public BaseBallGame(UserInput userInput, Random random, Hint hint) {
        this.userInput = userInput;
        this.random = random;
        this.hint = hint;
    }


    // 야구 게임 시작 함수
    public void run() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        String randomNumber = null;

        // 재시작을 하지 않을 때까지 반복
        while (!restart) {
            correct = false;
            // 숫자를 맞출때 까지 반복
            while (!correct) {
                // 랜덤값 생성 및 사용자 입력받기
                if(randomNumber == null) random.generateRandomNumber();

                randomNumber = random.getRandomNumber();
                String inputNumber = userInput.receiveInputNumber();

                // 힌트 생성
                hint.generateHint(randomNumber, inputNumber);

                // 랜덤값과 동일한 숫자를 입력하면 게임 종료
                if (isCorrect(randomNumber, inputNumber)) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }
            // 게임 재시작 입력 받기
            String restartNumber = userInput.receiveRestartNumber();
            if(restartNumber.equals("2")) break;
            randomNumber = null;
        }


    }

    // 3개의 숫자를 모두 맞혔는지 여부를 반환하는 함수
    private boolean isCorrect(String randomNumber, String inputNumber) {
        return randomNumber.equals(inputNumber);
    }



}
