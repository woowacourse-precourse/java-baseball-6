package baseball.utils;

public class Constant {
    public enum BallCount {
        STRIKE("스트라이크"),
        BALL("볼"),
        NOTHING("낫싱");
        final private String ballCount ;
        BallCount(String count) {
            ballCount = count;
        }
        public static String getBallCount(BallCount count) {
            return count.ballCount;
        }
    }

    public enum Process {
        RESTART(1),
        END(2);
        final private Integer process;
        Process(Integer p) {
            process = p;
        }
        public static Integer getProcess(Process p) {
            return p.process;
        }
    }
}
