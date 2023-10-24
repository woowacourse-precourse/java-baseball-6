### 구현할 기능 목록


- 랜덤 수 생성
  - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용.
- 플레이어 입력 받기
  - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용.
  - 잘못된 값 입력될 경우, `IllegalArgumentException` 발생 및 종료
- 입력에 대한 결과 출력
  - 정답일 경우, 정답 문구 출력 및 게임 종료
  - 하나도 맞춘게 없는 경우, 낫싱 문구 출력 및 게임 진행
  - 나머지 경우, 볼과 스트라이크로 출력 및 게임 진행
- 게임 재시작 여부 처리
  - 1 : 재시작
  - 2 : 게임 종료
  - 잘못된 값 입력될 경우, `IllegalArgumentException` 발생 및 종료