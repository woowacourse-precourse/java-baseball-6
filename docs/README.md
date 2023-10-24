# 구현할 기능 목록
## 1. 정답 생성
- 매 게임 시작시 랜덤하게 정답 생성
  - 1-9 사이의 서로 다른 숫자 3개
  - `camp.nextstep.edu.missionutils.Randoms.pickNumberInRange()` 사용

## 2. 사용자 입력
- 정답을 맞출 때까지 사용자 입력 받기
  - `camp.nextstep.edu.missionutils.Console.readLine()` 사용
- 잘못된 입력을 받으면 `IllegalArgumentException` 발생 후 종료
  - 숫자가 아닌 경우
  - 세 자리가 아닌 경우
  - 중복된 숫자가 있는 경우

## 3. 결과 출력
- 볼/스트라이크 카운트
- 출력 형식
  - `X볼 X스트라이크` - 볼, 스트라이크 모두 있는 경우
  - `X볼` - 볼만 있는 경우
  - `X스트라이크` - 스트라이크만 있는 경우
  - `낫싱` - 볼, 스트라이크 모두 없는 경우

## 4. 새로운 게임 시작
- 새로운 게임 시작 여부 묻기
  - `1` - 재시작
  - `2` - 종료
- 잘못된 입력을 받으면 `IllegalArgumentException` 발생 후 종료
  - `1`, `2` 이외의 값
