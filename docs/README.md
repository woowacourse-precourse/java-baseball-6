# 미션 - 숫자 야구

🚀 기능 목록
> 기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.

- [x] 프로젝트 폴더 구조 세팅

### 컴퓨터 숫자 생성 로직 작성
- 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 생성한다
- 생성한 숫자를 검증하여 예외 발생(`IllegalArgumentException`)

### 사용자 입력 로직 작성
- 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 입력받는다
- 이 과정에서 숫자를 검증하여 예외 발생(`IllegalArgumentException`)
    - `DuplicateNumbersInInputException` : 입력받은 숫자 중에서 서로 중복되는 숫자가 있는 경우
    - `NumberLengthBelowMinimumLengthException` : 입력받은 숫자의 길이가 3자리보다 짧은 경우
    - `NumberLengthExceedMaximumLengthException` : 입력받은 숫자의 길이가 3자리보다 긴 경우
    - `NumberNotDigitExcepton` : 입력받은 숫자(문자열)가 모두 숫자가 아닌 경우

### 게임 시뮬레이션 진행
- 사용자에게 입력받은 수와 컴퓨터가 생성한 숫자를 비교하여 볼, 스트라이크 개수 계산
  - 스트라이크 : 같은 수가 같은 자리에 있는 경우
  - 볼: 같은 수가 다른 자리에 있는 경우
  - 낫싱 : 같은 수가 전혀 없는 경우
- 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임 종료
- 게임을 다시 시작하거나 완전히 종료 : 이 과정에서 숫자를 검증하여 예외 발생(`IllegalArgumentException`)
  - `NumberNotRestartOrQuitException` : 다시 시작(1), 종료(2)가 아닌 숫자가 입력으로 들어오는 경우