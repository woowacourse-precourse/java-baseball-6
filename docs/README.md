# 기능 명세
숫자야구 게임의 기능 명세
## 기능
* 숫자야구 게임의 시작 / 끝을 알림
* 게임의 query - response 계산 후 출력
* 정답일 경우 종료.

## 클래스
### Application
* 책임
  * 게임 시작 안내
  * 재시작 여부 묻기
* attribute
  * 
* method
  * main
  * askRestart
### Game
* 책임
  * 게임 진행 (Query-Response 루프, 정답 시 종료)
  * query에 대한 계산
  * query 받고 출력
* attribute
  * answer
* method
  * run
  * askQuery
  * judge

# 기타 Issue
### answer 결정에 대한 책임은 어디에서?
  * 나중에 확장할 때 인간과의 플레이가 가능하다고 전제.
  * Game 밖에서 결정 후 시작하는 것이 적절.
### askSomething은 출력의 책임이 있나?
  * 출력의 책임을 ask가 지는 쪽이 깔끔하다고 판단