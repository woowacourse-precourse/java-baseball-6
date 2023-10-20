# 기능 구현 목록
### 정답 랜덤 생성 기능
- `generateAnswer` 메서드
  - 서로 다른 1~9 값 3개를 저장한 숫자 리스트 반환
### 정답 입력 기능
- `inputPlayerAnswer` 메서드
  - 사용자로부터 서로 다른 3자리 수 입력받아 각각의 자리 숫자를 저장한 리스트 반환
- `isUniqueThreeDigitNumber` 메서드
  - 문자열을 인수로 받아 중복없는 3자리 숫자라면 true, 아니라면 false 반환
    - 입력값이 숫자가 아니라면 `IllegalArgumentException` 발생
    - 입력값에 중복이 있다면 `IllegalArgumentException` 발생
    - 입력값이 3자리가 아니라면 `IllegalArgumentException` 발생
- `convertThreeDigitStringToList` 메서드
  - 입력값을 인수로 받아 각 자리를 저장한 숫자 리스트 반환
### 스트라이크, 볼 계산 기능
- `calculateStrike` 메서드
  - 정답 리스트와 사용자 입력 리스트를 인수로 받아 비교해서 스트라이크 개수 계산 후 반환
- `calculateBall` 메서드
  - 정답 리스트와 사용자 입력 리스트를 인수로 받아 비교해서 볼 개수 계산 후 반환
### 정답 확인 기능
- `isAnswer` 메서드
  - 스트라이크가 3개라면 true 반환 아니라면 false 반환
### 게임 종료 기능
- 정답이라면 메시지 출력 후 게임 종료
### 게임 재시작 기능
- `isValidChoice` 메서드
  - 사용자의 입력을 인수로 받아 "1"이나 "2"가 아니라면 `IllegalArgumentException` 발생
### 결과 출력 기능
- `printGameResult` 메서드
  - 스트라이크, 볼 개수를 인수로 받아 결과 출력