# Java-baseball-6

### 기능 목록

- `void run()`
    - 게임을 실행 합니다.
- `void init()`
    - 게임 데이터를 초기화 합니다.
- `List<T> setNumbers()`
    - 서로 다른 3개의 난수를 생성하여 리턴합니다.
- `int[] countBallAndStrike(String param)`
    - 입력된 값의 ball/strike를 카운트하고 리턴합니다.
- `String inputNumber(String param)`
    - 3자리 숫자를 입력 받아 리턴합니다.
- `String inputCmd(String param)`
    - 1자리 숫자를 입력받아 리턴합니다.
- `boolean isInteger(String param)`
    - 파라미터의 정수 변환 가능 여부를 리턴합니다.
- `booelan isUnique(String param)`
    - 파라미터의 구성 문자가 모두 고유한 값인지 검사 후 결과를 리턴합니다.
- `boolean isCmd(String param)`
    - 입력된 숫자의 명령어 여부를 리턴합니다.
- `String makeMessage(int[] ballCount)`
    - ball/strike 정보를 문자로 변환하여 리턴합니다.