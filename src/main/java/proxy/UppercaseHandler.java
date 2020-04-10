package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class UppercaseHandler implements InvocationHandler {

//    Hello target;

    Object target;

    public UppercaseHandler(/*Hello target*/Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        String ret = (String) method.invoke(target, args); // 타깃으로 위임, 인터페이스의 모든 메소드 호출에 적용
//        return ret.toUpperCase(); // 부가기능

        Object ret = method.invoke(target, args);
        // String 일 경우에만 대문자로 변환 ( return 타입이 Integer 인 인터페이스 메소드가 추가 되더라도 영향이 없도록
        if (ret instanceof String && method.getName().startsWith("say")) {
            return ((String) ret).toUpperCase();
        } else {
            return ret;
        }
    }
}
