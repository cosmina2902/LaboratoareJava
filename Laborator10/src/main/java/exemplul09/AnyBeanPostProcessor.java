package exemplul09;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class AnyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
        System.out.println("Bean name after initialization:"+beanName);
        return bean;
    }
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {
        System.out.println("Bean name before initialization:"+beanName);
        return bean;
    }
}
class Dreptunghi {
    private int lungime;
    private int latime;
    public Dreptunghi(int lungime, int latime) {
        this.lungime = lungime;
        this.latime = latime;
    }
    public void aria() {
        System.out.println("Aria dreptunghiului: "+(lungime*latime));
    }
}
class Triunghi {
//…
}
