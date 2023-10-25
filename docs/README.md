# 미션 - 숫자 야구

## 🚀 기능 구현 ##

- Game기능을  ``SystemConsole``, ``BaseballDataBuilder``, ``Message``로 생성된 객체를 이용하여 실행한다.
- pakage는 ``data``,``game``,``util``로 나눈다.

> data - 야구공 데이터를 관리하는 pakage
>> BaseballDataBuilderForThreeNumber : IBaseballDataBuilder 인터페이스를 구현.
> 야구 데이터를 생성하기 위한 랜덤한 숫자 생성과 유효성 검사를 수행
>
> > BaseballDataCompareResult
> >> 스트라이크와 볼 결과를 인스턴스를 생성하여 결과 반환
>
> > BaseballDataUsingThreeNumber
> >> IBaseballData 인터페이스를 구현. 컴퓨터와 사용자가 입력한 야구 데이터를 비교
>
> > IBaseballData
> >> 현재야구데이터와 다른 야구데이터 비교, 야구데이터 값 반환, 야구데이터 크기 반환 인터페이스 정의
>
> > IBaseballDataBuilder
> >> 컴퓨터와 유저의 야구데이터 생성 인터페이스 정의

> game - 게임 구동부분으로 게임 구현과 메세지 정보를 가지고 있는 pakage
> > Game
> >> 게임 인스턴스 생성, 게임 인풋 예외처리, 스트라이크 및 볼 체크, 게임 끝 체크 함수 구현
>
> > IMessage
> >> 자주 사용하는 메세지 인터페이스 정의
>
> > NumberBaseBallGameMessage:
> >> 자주 사용하는 메세지를 정의하는 클래스

> util: 숫자 랜덤생성, 숫자 입력
> > IRandomValueGenerator: 임의의 값 생성 인터페이스 정의
>
> > ISystemConsole :콘솔 입출력 등의 상호 작용 인터페이스 정의
>
> > RandomNumberGeneratorUsingMissionUtil
> >> IRandomValueGenerator 인터페이스를 정의하고, camp.nextstep.edu.missionutils.Randoms API를 통해 1~9사이의 임의의
> > > 정수를 생성하는 클래스
>
> > SystemConsolUsingJavaUtil
> >> Java 표준 라이브러리 사용. 콘솔 상호작용 과 입출력을 다루는 클래스
>
> > SystemConsoleUsingMissionUtil
> >> camp.nextstep.edu.missionutils 라이브러리 사용. 콘솔 상호작용 과 입출력을 다루는 클래스

- camp.nextstep.edu.missionutils 의 Randoms API를 사용하여 서로 다른 수로 이루어진 3자리수 만들기.
- camp.nextstep.edu.missionutils 의 Console내 readline() API를 사용하여 입력값 받기.

## 예외처리 ##

- 잘못된 값을 입력 했을때 IllegalArgumentException 발생 시킨 후 어플리케이션 종료 시키기.
    - 잘못된 값이란
        1. 숫자 야구 게임 중, 서로다른 3개의 1~9의 숫자가 아닐때
        2. 게임 종료 후, 다시 시작 할때 1 또는 2의 값이 아닐때