# 필요한 기능목록

# Application
- [x] 플레이어를 생성한다.
- [x] 게임을 실행한다.

# GamePlayer
- [x] 게임을 생성한다. (여기서 게임은 컴퓨터 랜덤숫자를 받아오는 부분도 있어야 한다.)
- [x] 플레이어의 입력을 받는 부분 (턴제로 호출한다.)
  - 출력부를 따로 떼는게 좋을듯
- [x] 다시할건지 물어보는 부분 ✅ 2023-10-24

# Game
- [x] 플레이어와 컴퓨터의 입력 숫자를 비교 ✅ 2023-10-24
- [x] 플레이어의 입력을 검증하는 부분
  - [x] 3자리인지
  - [x] 서로 다른 숫자를 갖는지
  - [x] 1~9 범위 안에 있는지
- 
- [x] 플레이어의 입력을 컴퓨터 랜덤과 비교하는 부분 ✅ 2023-10-24
  - [x] 스트라이크, 볼, 낫싱 판정하는 부분 ✅ 2023-10-24

# Computer
- [x] 랜덤 숫자를 내주는 부분 ✅ 2023-10-24
== 입력 검증하는 부분 메서드로 빼야함, Compititor에서도 쓸듯

---
# TestCoverage
- [x] GameManager
  - [x] isValidForm
  - [x] compareBetweenNumbers

- [x] GameParticipant
  - [x] GameStatus

- [x] GameCompititor
  - [x] generateRandomNumber




