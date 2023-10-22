기능목록

BaseballController(입력 담당)

    method
    1. run() - 게임을 시작한다.
    2. getNewAnswerNumbers(boolean isRestart, AnswerNumbers answerNumbers) 
        - 처음시작/재시작인 경우에 새로운 정답을 반환한다.
    3. getAnswerNumbers() 
        - 서로 다른 3개의 1-9사이의 숫자를 List<Integer>타입으로 반환한다.
    4. mapToInListInteger(String str) 
        - 서로 다른 3개의 숫자로 이루어진 문자를 List<Integer>타입으로 3개의 숫자로 반환한다.

AnswerNumbers 클래스

    method
    1. validateSize(List<Integer> answerNumbers) 
        - List<Integer>로 받은 매개변수의 크기가 3인지 검증한다.
    2. validateDuplicate(List<Integer> answerNumbers) 
        - List<Integer>안에 중복된 숫자가 존재하는지 검증한다.
    3. getBallNStrkie(List<Integer> inputNumbers) 
        - 볼과 스트라이크의 개수를 리턴한다.
    4. getStrike(List<Integer> inputNumbers)
        - 스트라이크의 개수를 리턴한다.
    5. getBall(List<Integer> inputNumbers)
        - 볼의 개수를 리턴한다.

Validator 클래스

    method
    1. validateThreeNumber(String str)
        - 3자리의 숫자로 이루어진 문자인지 검증한다.
    2. validateDuplicate(List<Integer> numbers)
        - 중복된 숫자가 있는지 검증한다.
    3. validate1Or2(String str)
        - 1 또는 2의 문자인지 검증한다.

InputView 클래스

    method
    1. input()
        - 내용 출력 후 숫자를 입력받고 리턴한다.
    2. finish()
        - 내용 출력 후  1 또는 2의 숫자를 입력받고 리턴한다.

OutputView 클래스

    method
    1. start()
        - 숫자야구 게임 시작 내용을 출력한다.
    2. printResult(int ball, int strike)
        - 볼과 스트라이크의 개수의 따라 내용을 바꾸어 출력한다.
    3. printBallNStrike(int ball, int strike)
        - 볼과 스트라이크의 개수를 출력한다.
    4. printBall(int ball)
        - 볼의 개수를 출력한다.
    5. printStrike(int strike)
        - 스트라이크의 개수를 출력한다.
    6. printNothing()
        - 낫싱을 출력한다.







