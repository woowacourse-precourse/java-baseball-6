# 숫자 야구 게임

## 구현 기능
- 게임 시작
  - 시작 문구 출력: "숫자 야구 게임을 시작합니다."
    - 최초 시작 시에만 출력
  - 컴퓨터가 3자리 랜덤 숫자 생성
- 게임 진행
  - 사용자 입력
    - "숫자를 입력해주세요 : "
  - 컴퓨터
    - 잘못된 입력인 경우, `IllegalArgumentException` 발생 후 프로그램 종료
      - 3자리가 아닌 경우
      - 숫자가 중복된 경우
      - 0이거나 숫자가 아닌 경우
    - 사용자가 입력한 수에 대한 결과 출력
      - "n볼 n스트라이크" 포맷
      - 하나도 없는 경우 "낫싱"
    - 사용자 입력 계속 처리
      - 모든 숫자를 맞히거나 오류를 발생하는 경우 예외
- 게임 재시작/종료
  - 3개의 숫자를 모두 맞힐 경우
    - "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료"
  - 재시작 및 종료 선택
    - "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
      - 1: 게임 시작
      - 2: 프로그램 종료

---
## 프로그래밍 요구사항
- JDK 17 ver.
- build.gradle 변경 X
- 외부 라이브러리 사용 X
- 프로그램 종료 시 System.exit() 호출 X
- 구현 완료 후 ApplicationTest의 모든 테스트 통과해야 함

### 라이브러리
`camp.nextstep.edu.missionutils`에서 제공하는 Randoms 및 Console API를 사용
- Random 값 추출: camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용
- 사용자가 입력하는 값: camp.nextstep.edu.missionutils.Console의 readLine()을 활용
