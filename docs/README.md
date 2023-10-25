# 기능 목록

### UserPlayer(사용자)
- [x] 숫자 입력
  - [x] 문자 -> 숫자 변환
    - [x] 숫자 입력했는지 검증
      - 숫자 아니면 IllegalArgumentException, "숫자만 입력 가능합니다." 발생 후 애플리케이션 종료
  - [x] 입력 검증
    - [x] 서로 다른 수로 이루어진 3자리의 수 검증
    - [x] 입력 가능한 수 범위 123 ~ 987

### ComputerPlayer
- [x] ComputerPlayer 생성
  -  camp.nextstep.edu.missionutils에서 제공하는 Randoms 함수 사용

### Referee(심판)
- [x] 두명의 Player 값 비교
  - [x] 한자리 숫자 비교
    - [x] 같음, 다름
  - [x] 세자리 숫자 비교
    - [x] 숫자 포함 확인 -> 볼
      - [x] 같은 자리에 위치하는지 확인 -> 스트라이크
    - [x] 낫싱

### GameManager(게임 관리자 및 Controller)
- [x] 게임 진행
  - [x] Viewer 와 Entity 를 연결 및 관리
  - [x] 새로운 게임 시작 및 종료 관리

### Viewer
- [x] 출력
  - [x] 게임 시작 문구 "숫자 야구 게임을 시작합니다."
  - [x] 숫자 입력 문구 "숫자를 입력해주세요 : "
  - [x] 결과 표시 문구 "볼", "스트라이크", "x볼 x스트라이크", "낫싱"
  - [x] 모두 맞춤 문구 "3개의 숫자를 모두 맞히셨습니다! 게임 종료"
  - [x] 게임 종료, 재시작 문구 "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."

### Coin
- [ ] GameManager에서 게임 진행에 필요한 값
  - [ ] 입력 검증 
    - 오류시 IllegalArgumentException, 입력할 수 있는 값은 1, 2입니다.