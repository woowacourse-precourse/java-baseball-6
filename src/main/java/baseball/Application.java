package baseball;

public class Application {
    public static void main(String[] args) {
        Computer com = new Computer();
        User user = new User();
        Result result = new Result();
        int[] target = com.makeList();
        int[] success = new int[2];

        while (true) {
            int[] answer = user.input();
            int strike = st(target, answer);
            int ball = b(target, answer);

            success = result.release(strike, ball);

            if (success[0] == 1) {
                break;
            }
        }

        if (success[1] == 1) {
            main(args);
        }
    }
    static int st(int[] com, int[] user) {
        int strike = 0;

        for(int i = 0; i < 3; i++) {
            if(user[i] == com[i]) {
                strike += 1;
            }
        }
        return strike;
    }

    static int b(int[] com, int[] user) {
        int ball = 0;
        int strike = st(com, user);

        for(int i = 0; i < 3; i++) {
            if(user[0] == com[i]) {
                ball += 1;
                continue;
            }
            if(user[1] == com[i]) {
                ball += 1;
                continue;
            }
            if(user[2] == com[i]) {
                ball += 1;
                continue;
            }
        }
        return ball - strike;
    }
}
