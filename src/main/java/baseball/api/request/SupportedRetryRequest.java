package baseball.api.request;

public enum SupportedRetryRequest {
    ONE(true),
    TWO(false),;

    private boolean flag;

    SupportedRetryRequest(boolean flag) {
        this.flag = flag;
    }

    public static SupportedRetryRequest isRetry(String request) {
        if ("1".equals(request)) {
            return ONE;
        } else if ("2".equals(request)) {
            return TWO;
        }
        throw new IllegalArgumentException();
    }

    public boolean isFlag() {
        return flag;
    }
}
