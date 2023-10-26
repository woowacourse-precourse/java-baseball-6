package baseball;

public class Application {
    public static void main(String[] args) {
        Computer computer = new Computer();
        User user = new User();
        while(user.isExit != 2){
            computer.setRandomNumber(); // 난수 설정
            computer.startGame(); // 게임 시작 메시지 출력
            while(!computer.isOut && user.isExit != 2){
                user.setNumber(); // 사용자가 숫자 입력
                if(user.isExit != 2){
                    computer.isCorrect(user); // 스트라이크, 볼을 계산
                    computer.printResult();
                }
            }
            if(user.isExit != 2){
                user.isAgain(); // 게임 제시작 여부를 입력
            }
        }
    }
}
