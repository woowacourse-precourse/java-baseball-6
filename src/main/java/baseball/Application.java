package baseball;

public class Application {
    public static void main(String[] args){
        // TODO: 프로그램 구현
        BaseballService baseballService = new BaseballService();
        //static을 활용해서 숫자를 받아오는 것과 클래스를 생성한뒤 불러오는 방법중 더 나은 것은?
        BaseballNumber computerNumber = BaseballNumber.initializeComputerNumber();
        BaseballNumber userNumber = BaseballNumber.initializeUserNumber();

    }
}
