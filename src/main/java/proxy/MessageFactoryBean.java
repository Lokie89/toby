package proxy;

import org.springframework.beans.factory.FactoryBean;

public class MessageFactoryBean implements FactoryBean<Message> {
    String text;

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public Message getObject() throws Exception {
        return Message.newMessage(this.text);
    }

    @Override
    public Class<?> getObjectType() {
        return Message.class;
    }

    // getObject() 메소드가 돌려주는 오브젝트가 싱글톤인지를 알려준다.
    // 이 팩토리 빈은 매번 요청할 때마다 새로운 오브젝트를 만드므로 false 로 설정한다.
    // 이것은 팩토리 빈의 동작방식에 관한 설정이고 만들어진 빈 오브젝트는 싱글톤으로 스프링이 관리해줄 수 있다.
    public boolean isSingleton() {
        return false;
    }
}
