package game;

public class Judgment {
    public static Result judge(String userNumber, String computerNumber) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < userNumber.length(); i++) {
            if (userNumber.charAt(i) == computerNumber.charAt(i)) {
                strikes++;
            } else if (computerNumber.contains(Character.toString(userNumber.charAt(i)))) {
                balls++;
            }
        }

        return new Result(strikes, balls);
    }
}
