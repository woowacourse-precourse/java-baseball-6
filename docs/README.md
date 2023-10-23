# 우테코 프리코스 1주차 - 숫자야구 구현
## 구현의도
- 실제 야구와 동일하게 홈팀, 어웨이팀, 심판을 생각하며 구현해보았습니다.
- 홈 : Player (사용자), 어웨이 : Computer, 심판 : Referee

## 기능목록
### 공통
- 각 클래스가 가지고 있는 멤버 변수는 get, set을 통해서만 접근하기
### Player
- 멤버 변수 : number

| 메소드       | 매개변수    | 설명                                       | 반환값  |
|-----------|--------|------------------------------------------|------|
| askNumber | void   | 사용자 입력을 받아 멤버 변수 "number" 에 저장           | void |
| is  | String |[Exception 발생] <br/>사용자 입력이 3자리인지 확인      | void                                     |
| is  | String |[Exception 발생] <br/>사용자 입력이 숫자인지 확인       | void                                     |
| is  | String |[Exception 발생] <br/>사용자 입력에 중복이 없는지 확인    | void                                     |

### Computer
- 멤버 변수 : number

| 메소드       |  설명                                       | 반환값             |
|-----------|------------------------------------------|-----------------|
| makeRandomNumber   |  주어진 Randoms을 사용하여 <br/>컴퓨터의 랜덤값 생성      | List< Integer > |
| getNumberToString  |  만들어진 랜덤값을 입력으로 받아 <br/>String으로 변환       |
