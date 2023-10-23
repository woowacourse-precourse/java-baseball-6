package baseball;

public class Application {
    public static void main(String[] args) {
        RandomNumberCreater randomNumberCreater = new RandomNumberCreater();
        int result = randomNumberCreater.getRandomNumber();
        System.out.println(result);
    }
}
