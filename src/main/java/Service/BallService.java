package Service;

public interface BallService {
    public void generateRandomNumber(); //랜덤 숫자 생성

    public boolean isValidation(String ballCount); //입력 유효성 검사

    public boolean startGame(String ballCount); //랜덤 숫자와 입력 숫자 비교

    public void printBallCount(int ball, int strike); //볼카운트 출력


}
