package baseball.play.start.compare;

public sealed interface ResumingGame permits Nothing, OneBall, OneBallOneStrike, OneBallTwoStrike,
    OneStrike, TwoStrike, ThreeBall, TwoBall, TwoBallOneStrike {

  String getResumeMessage();

  String randomNums();
}

record Nothing(String randomNums) implements ResumingGame {

  @Override
  public String getResumeMessage() {
    return "낫싱";
  }
}

record OneBall(String randomNums) implements ResumingGame {

  @Override
  public String getResumeMessage() {
    return "1볼";
  }
}

record OneStrike(String randomNums) implements ResumingGame {

  @Override
  public String getResumeMessage() {
    return "1스트라이크";
  }
}

record OneBallOneStrike(String randomNums) implements ResumingGame {

  @Override
  public String getResumeMessage() {
    return "1볼 1스트라이크";
  }
}

record TwoStrike(String randomNums) implements ResumingGame {

  @Override
  public String getResumeMessage() {
    return "2스트라이크";
  }
}

record OneBallTwoStrike(String randomNums) implements ResumingGame {

  @Override
  public String getResumeMessage() {
    return "1볼 2스트라이크";
  }
}

record TwoBall(String randomNums) implements ResumingGame {

  @Override
  public String getResumeMessage() {
    return "2볼";
  }
}

record TwoBallOneStrike(String randomNums) implements ResumingGame {

  @Override
  public String getResumeMessage() {
    return "2볼 1스트라이크";
  }
}

record ThreeBall(String randomNums) implements ResumingGame {

  @Override
  public String getResumeMessage() {
    return "3볼";
  }
}

