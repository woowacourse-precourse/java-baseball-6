# 기능 구현 목록
### 정답 생성 기능
- `generateAnswer` 메서드
  - 숫자 야구 게임 정답 생성
    - 정답은 중복없이 1~9 숫자 3개로 이루어진 값이다.
### 게임 시작 메시지 출력 기능
- `printStartMessage` 메서드
  - 게임 시작 메시지를 출력함
### 정답 입력 기능
- 사용자로부터 정답을 입력받음
  - 입력값이 각 자리가 1~9인 중복없는 3자리 숫자가 아니라면 `IllegalArgumentException` 발생
- `getPlayerGuess` 메서드
  - 사용자의 예측 정답을 입력 받음
- `validateGuess` 메서드
  - 사용자의 예측 정답 입력이 유효한 값인지 검증하는 메서드
  - 문자열을 인수로 받아 1~9로 이루어진 중복없는 3자리 문자열이 아니라면 `IllegalArgumentException` 발생
  - `isLengthThree` 메서드
    - 문자열을 인수로 받아 길이가 3이라면 true 반환
  - `isAllPositiveInteger` 메서드
    - 문자열을 인수로 받아 각각의 문자가 1~9라면 true 반환
  - `isAllUniqueCharacter` 메서드
    - 문자열을 인수로 받아 각각의 문자가 문자열에서 유일하게 존재하면 true 반환
### 점수 계산 기능
- `calcaulateScore` 메서드
  - 사용자 예측 정답을 인수로 받아 점수를 계산해서 Score 클래스 반환 
  - Score 클래스
    - 스트라이크, 볼 개수를 멤버변수로 가지는 클래스
### 결과 출력 기능
- `printGameResult` 메서드
  - Score 클래스를 인수로 받아 스트라이크, 볼 개수 출력
### 게임 종료 확인 기능
- 스트라이크가 3개라면 게임 종료
### 게임 종료 메시지 출력 기능
- `printEndMessage` 메서드
  - 게임 종료 메시지를 출력
### 게임 재시작 기능
- 사용자로부터 재시작 여부를 입력받음
  - "1" 입력시 게임 재시작
  - "2" 입력시 게임 종료
  - 그 외의 값은 `IllegalArgumentException` 발생
- `getPlayerChoice` 메서드
  - 사용자로부터 게임 재시작 여부를 입력받음
- `validateChoice` 메서드
  - 사용자의 재시작 여부 입력이 유효한 값인지 검증하는 메서드
  - 문자열을 인수로 받아 "1" 또는 "2"가 아니라면 `IllegalArgumentException` 발생
  - `isOneOrTwo` 메서드
    - 문자열을 인수로 받아 "1" 이나 "2"라면 true 반환
