# 구현 기능 목록

## controller
### GameController
- 게임 전 데이터 초기화 기능
- 게임 흐름 제어 기능
- 게임 메인 로직 기능
- 재시작 판단 기능
- 게임 결과 반환 기능
### InputController
- 사용자 입력 받고 반환하는 기능
###OutputController
- 스태틱 스트링
- 멘트 출력 기능
- 결과 출력 기능

## entity
### Game
- 랜덤 정답 초기화 기능
- 스트라이크 카운트 기능
- 볼 카운트 기능
- 정답 판능 기능
### Input
- 인게임 유효성 검사 기능
- 재시작 커맨드 유효성 검사 기능
### Player
- 입력 값 지니고 있도록
### Result
- 스트라이크, 볼, 정답 여부 소지

### Application
- 게임 시작 기능