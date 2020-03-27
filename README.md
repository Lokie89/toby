# 스프링

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
    
    
    
    