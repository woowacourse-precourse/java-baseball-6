<p align="center">
    <img src="./woowacourse.png" alt="우아한테크코스" width="250px">
</p>

# 프리코스 1주차 미션 - 숫자 야구 게임

---

![Generic badge](https://img.shields.io/badge/precourse-week1-green.svg)
![Generic badge](https://img.shields.io/badge/test-2_passed-blue.svg)
![Generic badge](https://img.shields.io/badge/version-1.0.1-brightgreen.svg)

> 우아한테크코스 6기 1주차 미션, 숫자 야구 게임을 구현한 저장소입니다.

# 목차
---
# 규칙
- 1~9 사이의 중복되지 않는 3개의 정수를 생성한다.
- 사용자는 3개의 숫자를 입력한다.
- 생성된 3개의 숫자를 맞추는데 위치까지 정확히 맞춰야 한다.
- 숫자와 숫자의 위치까지 일치하면 스트라이크 로 판정한다.
- 숫자는 맞지만 위치가 틀렸다면 볼 로 판정한다.
- 숫자3개가 모두 일치하지 않으면 낫싱 으로 판정한다.
- 3 strike 가 되면 게임은 종료된다.
- 계속할지 종료할지 여부를 물어보고 다음 진행을 한다
  
# 기능목록
- controller
    - BaseBallContoroller : 메인 메서드를 통해 호출받으며 GameMaker를 통해 생성된 computerNumbers를                                          BallAndStrikeChecker에 저장 gameProgress의 값을 확인하며 반복문 실행, 사용자의 값이                              computerNumbers과 일치할경우 FinishView에 있는 gameContinueCheck값을 확인 후 재귀호                              출 여부 판단
      
- model
    - BallAndStrikeChecker : UserNumbers에 있는 값과 생성자를 통해 지정된 정답을 반복문을 통해 비교하며 ball과                                 stike의 값 BallAndStike에 저장 만약 strike가 3일시 게임진행여부를 판단하는                                       gameProgress를 false값으로 설정
    - GameMaker : 중복하지 않은 1~9 사이의 난수생성 후 리스트로 반환
      
- view
    - InputView : 사용자의 입력 받고 중복, 숫자로 구성인지, 길이를 체크하여 UserNumbers에 저장
    - ResultView : BallAndStrikeChecker를 통해 BallAndStirke에 저장된 값을 StringBuilder를 통해 화면에 출력
    - FinishView : 정답시 사용자에게 게임의 진행여부를 확인하여 반환
      
- vo
    - BallAndStrike : Ball 과 Strike를 저장하는 클래스
    - UserNumbers : 사용자에게 입력받은 값을 저장하는 클래스
