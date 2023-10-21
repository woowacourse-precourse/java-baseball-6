package baseball;

public class Application {
    public static void main(String[] args) {
        int choice;
        do {
            playBaseBall();
            choice = getChoice();
        } while(choice == 1);
    }
}
