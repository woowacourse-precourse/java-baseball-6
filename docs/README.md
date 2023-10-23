## ⚾️ 숫자 야구 게임

***
이전에 한번도 `MVC`패턴에 맞추어 개발해본 적이 없어서 연습삼아 진행해보았습니다.
### Model
1. `Player`: 게임을 플래이하는 객체
   1. 점수를 저장하고 있는 객체
2. `Computer`: 컴퓨터
   1. 정답을 가지고 있는 객체

### Domain
1. `BaseballGame`: 게임을 진행

### Controller
>앱의 사용자로부터의 입력에 대한 응답으로 모델 및/또는 뷰를 업데이트하는 로직
1. `ScoreHandler`: `Player`과 `Computer`값을 비교하여 점수를 채점함
2. `SpanPlayers`: `Player`과 `Computer`를 생성함
### View
