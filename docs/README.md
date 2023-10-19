# 숫자 야구 기능 목록
## 정답 숫자 랜덤 선택 기능 
- setRandomNumber 메서드
  - 중복 없이 1~9 값 3개를 변수 `answer` 리스트에 저장
  - Random 값 생성은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용
## 정답 입력 받기 기능 
- readInput 메서드
  - 사용자로부터 3자리 숫자 정답을 입력받음
    - 입력된 값이 숫자가 아니라면 `IllegalArgumentException`을 발생
    - 입력된 문자의 길이가 3이 아니라면 `IllegalArgumentException`을 발생
    - 입력된 값에 중복이 있다면 `IllegalArgumentException`을 발생
  - 입력받은 각 자리의 숫자를 변수 `userAnswer`에 저장
## 스트라이크, 볼 계산 기능
- calculateStrikeAndBall 메서드
  - `answer` 리스트와 `userAnswer` 리스트를 비교해서 스트라이크, 볼 개수를 계산하고 출력
  - 정답이라면 `isAnswer` 변수를 `true`로 변경
## 게임 시작 기능
- startGame 메서드
  - 숫자 야구 게임을 시작하는 메서드
  - setRandomNumber 메서드로 정답 설정
  - readInput 메서드로 사용자 입력값 받기 반복
  - calcaulateStrikeAndBall 메서드 결과 출력
## 게임 반복 기능
- startGame 메서드를 반복
- 게임 종료 후 값을 입력받아 1이라면 재시작, 2라면 종료
  - 1이나 2가 아니면 `IllegalArgumentException` 발생