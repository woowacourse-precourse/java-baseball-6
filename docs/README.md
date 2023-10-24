# 📁 기능 구현

##  ⬜️ 큰 틀
### Main()
> BaseballGame 객체 생성  
> play()
> ### BaseballGame()
> > + 시작  
      - "숫자 야구 게임을 시작합니다." 시작 문구  
      - game 진행 do-while문
> > ### do-while
> > > + 랜덤 수를 가진 Computer 생성
> > > + Computer의 랜덤수를 맞추기 까지 do-while문
> > > ### do-while
> > > > + 사용자의 입력을 받고 볼&스트라이크 정보를 가지고 있는 Player 생성
> > > > + Computer와 Player 값 비교
> > > > + 결과 출력
> > > > + 3 스트라이크면 do-while문 빠져나옴
> > > + 1과 2 중에서 사용자 입력
> > > + 2 입력이면 do-while문 빠져나옴

## 🎯 세부 기능
+ 시작  
   + "숫자 야구 게임을 시작합니다." 시작 문구  
   + game 진행 do-while문
+ 종료
   + 3스트라이크인 경우 
   + 게임 진행 여부는 1 과 2 입력으로 받음
   + 1 : continue
   + 2 : break

### 👾 game 알고리즘
+ 랜덤
   + `camp.nextstep.edu.missionutils`에서 제공하는 Randoms 및 Console API를 사용하여 구현
   + Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용
   + 서로 다른 숫자의 3자리 수
+ 비교
   + 같은 수가 같은 자리에 있으면 스트라이크 증가
   + 다른 자리에 있으면 볼 증가
+ 출력
   + 볼과 스트라이크 둘 다 0 이면 낫싱 출력
   + 스트라이크가 3 이면 3스트라이크 출력
      + + 3스트라이크인 경우, 게임 종료  
   + 볼과 스트라이크 둘 다 0 보다 크면 볼 갯수 먼저 출력 후 스트라이크 갯수 출력 
+ 입력
   + "숫자를 숫자를 입력해주세요 : " 출력
   + 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용
   + 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException 발생
      + 3자리 수 초과 입력
      + 같은 수 포함
      + 1~9 사이의 숫자 
      + 숫자가 아닌 경우
      + 3스트라이크 후, 1과 2 중에서 입력
