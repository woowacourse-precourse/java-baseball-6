## 구현할 기능 목록

### 객체 설계

숫자야구 기능 요구 사항에 따라 다음과 같은 객체들을 구현할 예정입니다.

#### NumberBaseball

- 책임
    - 숫자야구 게임의 과정에 대한 책임을 가집니다.
- method
    - play: 숫자야구 게임을 실행합니다.

#### NumberBaseballIO

- 책임
    - 숫자 야구 게임의 입력과 출력에 대한 책임을 가집니다.
- method
    - inputGuessAnswer: 사용자가 정답을 추축할때 입력을 해줍니다.
    - printResult: 사용자가 추측한 정답의 결과를 출력합니다.
    - showAndReceiveContinueGame: 게임을 계속진행 할것인지 묻고 답에 대한 입력을 받아줍니다.

#### User

- 책임
    - 숫자야구 게임을 진행하는 사용자에 대한 책임을 가집니다.
- method
    - guessUntilCorrect: 숫자야구 게임의 정답을 맞출때까지 정답을 추측합니다.
    - isContinueGame: 숫자야구 게임을 계속 진행할건지에 대한 답을 해줍니다,

#### Answer

- 책임
    - 숫자야구 게임에서의 정답 타입에 대한 책임을 가집니다.
- method
    - createByRandom: 랜덤한 정답을 만들어줍니다.
    - createByList: 인자로 들어온 list로 정답을 만들어줍니다.
    - getAnswer: 정답을 반환합니다.
    - getSize: 정답의 길이를 반환합니다.

#### Result

- 책임
    - 숫자야구 게임의 결과에 대한 책임을 가집니다.
- method
    - create: 숫자야구 게임의 결과를 만들어줍니다.
    - isCorrect: 결과가 정답인지 알려줍니다.
    - toString: 결과를 String 타입으로 반환해줍니다.

#### InputOutputHandler

- 책임
    - 입력과 출력에 대한 책임을 가집니다.
- method
    - inputUniqueNumbers: 중복되지 않은 숫자를 입력으로 받아줍니다.
    - inputOneNumber: 하나의 숫자를 입력 받아줍니다.
    - printText: text를 출력해줍니다.
    - printlnText: text를 출력하는데 \n을 붙여서 출력합니다.

#### NumberBaseballConstants

- 책임
    - 숫자야구 게임에 필요한 상수들에 대한 책임을 가집니다.

#### InputValidator

- 책임
    - 입력에서의 유효성 검사에 대한 책임을 가집니다.
- method
    - validateUniqueNumbers: 입력값에 대해 중복된 숫자가 없는지 확인합니다.
    - validateSingleNumber: 입력값에 대해 하나의 숫자가 맞는지 확인합니다.

#### NumberBaseballValidator

- 책임
    - 숫자야구 게임에서 유효성 검사에 대한 책임을 가집니다.
- method
    - validateContinueGame: 게임을 계속할건지에 대한 입력값에 대해 검사해줍니다.

#### NumberUtils

- 책임
    - number에 대한 유용한 메서드를 제공해줍니다.
- method
    - isNumeric: 숫자가 맞는지 확인해 줍니다.

#### RandomUtils

- 책임
    - Random에 대한 유용한 메서드를 제공해줍니다.
- method
    - generateDistinctNumbers: 중복되지 않은 숫자들을 랜덤으로 뽑아 줍니다.

#### StringUtils

- 책임
    - String에 대한 유용한 메서드를 제공해줍니다.
- method
    - hasDuplicateCharacters: 중복되는 문자가 있는지 확인해줍니다.
    - toIntegerList: String을 List<Integer>타입으로 변환해줍니다.

#### BaseballApplication

- 책임
    - 애플리케이션의 class에 대해 의존성을 주입해주며, 싱글톤으로 관리되게 해줍니다.
- 메서드
    - run: 애플리케이션을 실행해줍니다.

   

