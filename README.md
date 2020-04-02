# 스프링
## 1. 오브젝트와 의존관계
#### 스프링 컨테이너
    스프링은 스프링 컨테이너 또는 애플리케이션 컨텍스트라고 불리는 스프링 런터임 엔진을 제공
    스프링 컨테이너는 설정정보를 참고로 해서 애플리케이션을 구성하는 오브젝트를 생성하고 관리

#### 스프링 프로그래밍 모델
    IoC / DI, 추상화, AOP
    
#### 스프링 추구
    단순함, 유연성
    
### DAO
    Data Acceess Object 는 DB를 사용해 데이터를 조회하거나 조작하는 기능을 전담하도록 만든 오브젝트
###### 자바빈
    비주얼 툴에서 조작 가능 한 컴포넌트 였지만 "웹 기반의 엔터프라이즈 방식으로 바뀌면서 ?" 
    비주얼 컴포넌트라기보다는 다음 두 가지 관례를 따라 만들어진 오브젝트를 가리킨다.
    디폴트 생성자, 프로퍼티
    
### 관심사의 분리
    관심이 같은 것끼리는 하나의 객체 안으로 또는 친한 객체로 모이게 하고,
    관심이 다른 것은 가능한 따로 떨어져서 서로 영향을 주지 않도록 분리하는 것

###### 템플릿 메소드 패턴
    슈퍼클래스의 기본적인 로직의 흐름을 만들고, 그 기능의 일부를 추상 메소드나 오버라이딩이
    가능한 protected 메소드 등으로 만든 뒤 서브클래스에서 이런 메소드를 필요에 맞게
    구현해서 사용하도록 하는 방법을 "템플릿 메소드 패턴" 이라고 한다.
    
###### 팩토리 메소드 패턴
    오브젝트를 생성하는 메소드를 정의해놓고 서브클래스에서 해당 메소드를 구현하여
    어떤 오브젝트를 어떻게 생성할 것인지리를 결정하는 방법을 "팩토리 메소드 패턴" 이라고 한다.
    
### 객체지향 기술의 이론

###### 개방 폐쇄 원칙
    OCP, Open-Closed Principle
    클래스나 모듈은 확장에는 열려 있어야 하고 변경에는 닫혀있어야 한다.
###### 높은 응집도와 낮은 결합도
    응집도가 높다는 건 하나의 모듈, 클래스가 하나의 책임 또는 관심사에만 집중되어 있다는 뜻
    응집도가 높다는 건 변화가 일어날 때 해당 모듈에서 변하는 부분이 크다는 것
    만약 모듈의 일부분에만 변경이 일어나도 된다면, 모듈 전체에서 어떤 부분이 바뀌어야 하는지 파악
    
    결합도가 낮다는 건 하나의 오브젝트가 변경이 일어날 때 관계를 맺고있는 다른 오브젝트에게
    적은 변화를 요구한다는 것
    
###### 전략 패턴
    자신의 기능 맥락에서 필요에 따라 변경이 필요한 알고리즘을 인터페이스를 통해 
    통째로 외부로 분리시키고 이를 구현한 구체적인 알고리즘 클래스를 필요에 따라
    바꿔서 사용할 수 있게 하는 디자인 패턴

###### 팩토리
    객체의 생성 방법을 결정하고 그렇게 만들어진 오브젝트를 돌려주는 클래스
    
### 제어의 역전
    IoC, Inversion of Control
    프로그램의 제어 흐름 구조가 뒤바뀌는 것
    오브젝트가 자신이 사용할 오브젝트를 스스로 선택하지 않는다.
    ★ 제어의 역전이라는 말로 많이 헷갈렸음.
        결국 생성자로 던져주는 ConnectionMaker 의 DConnectionMaker는 내가 선택하는 것이 아닌가
        라고 생각했음. 그런데 선택(나는 제어라고 생각함) 여부가 아닌 어떤 객체가 그 주도권을 행사할것인가
        라는 의미로 받아들여야 한다고 생각.
        
       내 정의로 주도권의 역전 이라고 생각. 어떤 객체가 컨트롤 할 것이냐를 제어로 표현
       제어는 강제적인 느낌, 주도권은 더 우위? 더 영향력이 큰 느낌,
       
###### 스프링 IoC
    스프링에서 제어권을 가지고 직접 만들고 관계를 부여하는 오브젝트를 빈 bean 이라 함
    빈의 생성과 제어를 담당하는 IoC 오브젝트를 빈 팩토리 bean factory 라고 함
    애플리케이션 전반에 걸쳐 모든 구성요소의 제어 작업을 담당하는 Ioc 엔진을 애플리케이션 컨텍스트라 함
    
#### 애플리케이션 컨텍스트
    Application Context
    
    클라이언트는 구체적인 팩토리 클래스를 알 필요가 없다.
        어플리케이션 컨텍스트를 이용하면 오브젝트 팩토리가 아무리 많아져도 이를 알아야 하거나 직접 사용할 필요가 없다.
        일관된 방식으로 원하는 오브젝트를 가져올 수 있다. 또 XML처럼 단순한 방법을 이용해 IoC 설정정보를 만들 수도 있다.
    
    애플리케이션 컨텍스트는 종합 IoC 서비스를 제공해준다.
        애플리케이션 컨텍스트는 오브젝트가 만들어지는 방식, 시점과 전략을 다르게 가져갈 수도 있고,
        부가적으로 자동생성, 오브젝트에 대한 후처리, 정보의 조합, 설정방식의 다변화, 인터셉팅 등 
        다양한 기능을 제공
        
    애플리케이션 컨텍스트는 빈을 검색하는 다양한 방법을 제공한다.
        getBean() 메소드는 빈의 이름을 이용해 빈을 찾아준다.
        

###### 싱글톤 레지스트리
    어플리케이션 컨텍스트에서 빈을 추출하여 확인해보면 모두 같은 객체임을 알 수 있음.
    
    싱글톤 패턴의 한계
        1. private 생성자를 갖고 있기 때문에 상속할 수 없다.
        2. 싱글톤은 테스트하기가 힘들다.
        3. 서버환경에서는 싱글톤이 하나만 만들어지는 것을 보장하지 못한다.
        4. 싱글톤의 사용은 전역 상태를 만들 수 있기 때문에 바람직하지 못하다.
    
    싱글톤 레지스트리는 이러한 싱글톤 패턴의 한계 때문에 
    직접 싱글톤 형태의 오브젝트를 만들고 관리하는 기능을 제공한다.
    
###### 스프링 빈의 스코프
    스프링이 관리하는 빈이 생성되고, 존재하고, 적용되는 범위를 빈의 스코프라 함
    대부분 스프링에서 만들어지는 빈은 싱글톤 스코프를 갖는다.
    싱글톤 외의 스코프에는 
    프로토타입 스코프 - 빈을 요청할 때마다 새로운 오브젝트르 만들어줌 (<-> 싱글톤)
    요청 스코프 - 새로운 HTTP 요청이 생길때마다 생성되는,
    세션 스코프 - 웹의 세션과 스코프가 유사한
    등등 이 있음.
    
#### DI
    Dependency Injection
    의존관계 주입 조건
    1. 클래스 모델이나 코드에는 런타임 시점의 의존관계가 드러나지 않는다.
       그러기 위해서는 인터페이스에만 의존하고 있어야 한다.
    2. 런타임 시점의 의존관계는 컨테이너나 팩토리 같은 제 3의 존재가 결정한다.
    3. 의존관계는 사용할 오브젝트에 대한 레퍼런스를 외부에서 제공(주입) 해줌으로써 만들어진다.

###### 의존관계 검색
    자신이 필요로 하는 의존 오브젝트를 능동적으로 찾는다.
    물론 자신이 사용할 클래스의 오브젝트를 이용할지 결정하지는 않는다.
    
    의존관계 검색과 의존관계 주입을 적용할 때 차이점은 의존관계 검색 방식에서는
    검색하는 오브젝트 자신이 빈일 필요는 없다는 것
    
    보통 main 함수 내에서 의존관계 주입을 사용할 수 없어, 의존관계 검색을 사용함 (test 등)
    
###### XML 을 이용한 DI 설정
    빈의 이름 : @Bean 메소드 이름
    빈의 클래스 : Bean 오브젝트를 어떤 클래스르 이용해서 만들지를 정의
    빈의 의존 오브젝트 : Bean 의 생성자나 수정자 메소드를 통해 의존 오브젝트를 넣어준다.
        의존 오브젝트도 하나의 Bean 이므로 이름이 있고, 그 이름에 해당하는 메소드를 호출
        
```java
public class DaoFactory {
    @Bean // <bean
    public ConnectionMaker connectionMaker() { // id="connectionMaker"
        return new CountingConnectionMaker(new DConnectionMaker()); // class="toby/src../CountingConnectionMaker" />
    }
}
```

    XML 작성
    <beans> // @Configuration 과 동일
        <bean id="JAVA메소드명" class="빈오브젝트를 구현할 클래스">
            <property name="set메소드이름(set제외하고사용)" ref="의존빈id" />
        </bean>
    </beans>
    
    XML 사용
    ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
    로 사용한다.
    실제 xml 파일은 현 프로젝트에서 resources로 명시되어있는 path에 넣지 않으면 파일을 못찾아냄
    이유가뭐지
    
    bean 의 property 중 value 값 대입 시, String 값이 아닌 Class 이름이 들어갈 때가 있음
    스프링에서 set 메소드의 파라미터 타입을 확인 하고 해당 오브젝트로 자동 형변환 시킴
    
#### 정리
    관심사의 분리
    인터페이스 구현 인터페이스로만 접근가능( 전략 패턴 )
    개방 폐쇄 원칙
    낮은 결합도와 높은 응집도
    IoC
    싱글톤 레지스트리
    DI
    생성자 주입과 수정자 주입
    XML 설정
    

## 2. 테스트
    
    @Test 어노테이션이 왜 java 패키지에서는 작동안하는지 확인

#### @Test( expected = 예외클래스명 )
    테스트 메소드 실행 중에 발생하리라 기대하는 예외 클래스를 넣어줌
    보통의 테스트와는 반대로, 정상적으로 테스트 메소드를 마치면 테스트 실패
    expected 에서 지정한 예외가 던져지면 테스트 성공
    
    테스트 할 메소드에서 예외발생시 throw 되는 혹은 throw 시키는 예외 클래스명 을 넣어줌
    
#### 포괄적인 테스트
    테스트 코드 작성시 성공 케이스를 예상하고 테스트 코드를 작성하기 보다는
    예외적인 상황까지 고려하며 테스트 코드를 작성해야 한다.
    "항상 네거티브 테스트를 먼저 만들라"
    
#### TDD
    만들고자 하는 기능의 내용을 담고 있으면서 만들어진 코드를 검증도 해줄 수 있도록
    테스트 코드를 먼저 만들고, 테스트를 성공하게 해주는 코드를 작성하는 방식의 개발 방법
    "실패한 테스트를 성공시키기 위한 목적이 아닌 코드는 만들지 않는다."
    
#### JUnit 테스트 클래스 수행 순서
    1. 테스트 클래스에서 @Test가 붙은 public, void 형의 파라미터가 없는 테스트 메소드를 찾는다.
    2. 테스트 클래스의 오브젝트를 만든다.
    3. @Before가 붙은 메소드 실행
    4. @Test 붙은 메소드를 호출하고 테스트 결과를 저장
    5. @After가 붙은 메소드 실행
    6. 나머지 테스트 메소드에 대해 2-5 까지 반복
    7. 모든 테스트 결과를 종합
    
    테스트 메소드를 실행할 때마다 새로운 오브젝트를 만듬
    각 테스트가 서로 영향을 주지 않고 독립적으로 실행함을 보장해주기 위해
    
#### 픽스처
    fixture
    테스트를 수행하는 데 필요한 정보나 오브젝트
    일반적으로 @Before 메소드를 이용해 생성
    
#### @BeforeClass
    테스트 클래스 전체에 걸쳐 한 번만 실행되는 스태틱 메소드
#### @ContextConfiguration
    테스트 컨텍스트 프레임워크
    여러개의 클래스 내에서 어플리케이션 컨텍스트를 공유
#### @Autowired
    변수타입과 일치하는 컨텍스트 내의 빈을 찾아서 주입해준다.
    같은 타입의 빈이 두 개 이상 있는 경우에는 타입만으로는 어떤 빈을 가져올지 결정할 수 없다.
    빈 하나를 선택할 수 없는 경우에는 "변수의 이름과 같은 이름의 빈"이 있는지 확인
    
#### @DirtiesContext
    스프링의 테스트 컨텍스트 프레임워크에게 해당 클래스의 테스트에서 
    애플리케이션 컨텍스트의 상태를 변경한다는 것을 알려줌.
    이 어노테이션이 붙은 테스트 클래스에는 애플리케이션 컨텍스트 공유를 허용하지 않음.

#### 테스트 방법 선택
    스프링 컨테이너 없이 테스트할 수 있는 방법
    
#### 정리
    테스트는 자동화
    JUnit 프레임워크를 이용하면 편리
    일관성이 있어야함
    포괄적으로 작성, 충분한 검증
    간격이 짧을수록 좋다
    테스트를 먼저 만들고 테스트를 성공시키는 코드를 만들기
    @Before, @After 사용
    동일한 설정파일은 하나의 애플리케이션 컨텍스트 공유
    @Autowired 이용 
    학습 테스트
    버그 테스트
    
## 3. 템플릿
    
#### 분리와 재사용을 위한 디자인 패턴 적용
    변하는 성격이 다른 것을 찾아냄. ( 관심사의분리? )
#### 익명 내부 클래스
    상속할 클래스나 구현할 인터페이스를 생성자 대신 사용해서 다음과 같은 형태로 만들어 사용
    클래스를 재사용할 필요가 없고, 구현한 인터페이스 타입으로만 사용할 경우에 유용
    new 인터페이스이름(){ 클래스 본문 };
    
#### 스프링 빈으로 DI를 적용
    의존 관계 주입(DI)시 클래스 레벨에서 구체적인 의존과계가 만들어지지 않도록 인터페이스를 사용
    그러나 스프링 빈으로 DI 를 적용할 경우( 클래스 레벨 )의 이유 
    1. 스프링 컨테이너의 싱글톤 레지스트리 사용
        사용하는 인스턴스 변수가 읽기 전용( 여기선 DataSource ) 
    2. DI를 통해 다른 빈에 의존하고 있기 때문
        DI 를 적용할 클래스가 이미 다른 빈을 통해 DI를 사용하고 있을 경우
    3. 강한 결합이 필요한 경우
    
    ( 그저 인터페이스를 만들기가 귀찮으니까 그냥 클래스를 사용하자는 것은 잘못된 생각이다! ) 

#### 템플릿과 콜백
    템플릿은 고정된 작업 흐름을 가진 코드를 재사용한다는 의미
    콜백은 템플릿 안에서 호출되는 것을 목적으로 만들어진 오브젝트
    
#### 템플릿 / 콜백 패턴
    일반적인 DI 방식의 전략 패턴 구조 인데
    일반적인 DI는 템플릿에 인스턴스 변수를 만들어두고 사용할 의존 오브젝트를 수정자 메소드로 받지만
    템플릿 / 콜백 방식에서는 매번 메소드 단위로 사용할 오브젝트를 새롭게 전달받는다.
    전략 패턴과 DI의 장점을 익명 내부클래스 사용 전략과 결합한 활용법
    
    템플릿( 메소드 )에 사용할 콜백 인터페이스를 전달받아 실행


    
## 4. 예외
## 5. 서비스추상화
## 6. AOP
## 7. 스프링 핵심 기술의 응용
## 8. 스프링이란 무엇인가?
## 9. 스프링 프로젝트 시작하기