package baseball;

public class NumberGameConfiguration {

    private int minimumNumberOfRange;
    private int maximumNumberOfRange;
    private int numberOfDigits;

    private NumberGameConfiguration() {
    }

    public static class Builder {
        private NumberGameConfiguration configuration;

        public Builder() {
            configuration = new NumberGameConfiguration();
        }

        public Builder minimumNumberOfRange(int minimumNumberOfRange) {
            configuration.minimumNumberOfRange = minimumNumberOfRange;
            return this;
        }

        public Builder maximumNumberOfRange(int maximumNumberOfRange) {
            configuration.maximumNumberOfRange = maximumNumberOfRange;
            return this;
        }

        public Builder numberOfDigits(int numberOfDigits) {
            configuration.numberOfDigits = numberOfDigits;
            return this;
        }

        public NumberGameConfiguration build() {
            return configuration;
        }
    }
}
