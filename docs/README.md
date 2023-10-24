# 미션 - 숫자 야구

## 숫자 야구 프로그램의 기능을 정의한다.

### Application

프로그램을 실행한다.

- NUMBER_LENGTH 변수
    - 야구 게임에서 사용하는 수가 몇 자리의 숫자인지 정의한다.
- main 메소드
    - 멤버변수 run 은 boolean 타입으로, 초기값은 true이다.
    - run 은 애플리케이션의 유지/종료를 담당한다. run 값이 true이면 애플리케이션이 계속 실행되고, false 이면 애플리케이션이 종료된다.
    - 재시작 입력을 받았다면 gameStart 메소드를 재실행한다.
    - 종료 입력을 받았다면 애플리케이션을 종료한다.

### Balls

야구공들의 숫자를 저장하고, 야구공들에 대한 처리를 한다.

- List<Integer> 타입의 컬렉션에 야구공들의 수를 저장한다.
- 생성자에서 Validation 클래스를 이용해 입력을 검증한다.
- 생성자에서 Converter 클래스를 이용해 입력을 변환한다.

### BaseballGame

사용자의 입출력을 전담한다.

- gameStart 메소드
    - 컴퓨터 난수를 생성한다.
        - GenerateRandomNumber 객체를 이용한다.
        - 컴퓨터 난수는 정수형 리스트 List<Integer>에 저장되어 Balls 객체로 만들어진다.
    - 사용자로부터 숫자 야구 게임을 위한 입력을 받는다.
        - 사용자 입력은 정수형 리스트인 List<Integer> 로 받아 Balls 객체로 만든다.
    - 사용자에게 숫자 야구 게임의 결과를 출력한다.
    - return 타입은 boolean 이다.
- restartOrEnd 메소드
    - 사용자에게 게임이 끝난 경우 재시작 할 지, 애플리케이션을 종료할 지 질문한다.
    - 사용자로부터 재시작/종료에 대한 입력을 받는다.
    - return 타입은 boolean 이다.

### GenerateRandomNumber

컴퓨터가 3개의 무작위 번호를 만들어 낸다.

- generateRandomNumber 메소드
    - 3개의 번호는 1~9 사이의 숫자이며, 서로 달라야 한다는 규칙을 지키며 만들어진다.
    - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
    - return 타입은 정수형 리스트인 List<Integer> 이다.
- CorrectNumberLength 메소드
    - 컴퓨터가 생성하는 난수 리스트의 길이가 3인지 확인한다.
    - return 타입은 boolean 이다.
- duplicationNumber 메소드
    - 컴퓨터가 생성하는 난수 리스트의 숫자들이 중복되는지 확인한다.
    - return 타입은 boolean 이다.

### BaseballGameService

사용자 입력과 컴퓨터의 랜덤값을 비교한 결과를 제공한다.

- countBall 메소드
    - 볼의 개수를 카운트한다.
    - return 타입은 int형이다.
- isBall 메소드
    - 볼의 여부를 판단한다.
    - 사용자 입력과 컴퓨터 입력을 비교하여 같은 수가 다른 자릿수에 있으면 '볼'이라 판단한다.
    - return 타입은 boolean형이다.
- countStrike 메소드
    - 스트라이크의 개수를 카운트한다.
    - return 타입은 int형이다.
- isStrike 메소드
    - 스트라이크의 여부를 판단한다.
    - 사용자 입력과 컴퓨터 입력을 비교하여 같은 수가 같은 자릿수에 있으면 '스트라이크'라 판단한다.
    - return 타입은 boolean형이다.
- isNothing 메소드
    - 사용자 입력과 컴퓨터 입력을 비교한 결과 같은 수가 전혀 없으면 낫싱이라 판단한다.
    - return 타입은 boolean형이다.
- baseballGameServiceStart 메소드
    - 컴퓨터의 3자리 난수를 생성하고, 사용자 입력과 비교하는 일련의 과정을 처리한다.

### Validation

사용자의 입력을 검증한다.
예외가 발생하는 경우 `IllegalArgumentException` 을 발생시키고 애플리케이션을 종료한다.

- inputLengthIsZero 메소드
    - 사용자로부터 받은 입력의 개수가 0개일 때 예외를 발생시킨다.
- inputLengthIsOver 메소드
    - 사용자로부터 받은 입력의 개수가 3개보다 많을 때 예외를 발생시킨다.
- inputLengthIsUnder 메소드
    - 사용자로부터 받은 입력의 개수가 3개보다 적을 때 예외를 발생시킨다.
- inputIsNotNumber 메소드
    - 사용자로부터 받은 입력이 숫자가 아닌 경우 예외를 발생시킨다.
- duplicateNumber 메소드
    - 사용자로부터 받은 입력의 자릿수 중 중복되는 수가 있는 경우 예외를 발생시킨다.
- userGameStartValidation 메소드
    - 게임을 시작할 때 사용자의 입력을 검증한다.
- userGameRestartOrEndValidation 메소드
    - 게임을 종료 또는 재시작하기 위해 사용자의 입력 받을 때 그 입력을 검증한다.

### Converter

특정 자료형을 다른 자료형으로 변환한다.

- stringToIntList
    - String 타입의 데이터들을 int타입 List로 변환한다.
- intListToString
    - int타입의 List를 String으로 변환한다. 
