package exemplul08;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Dreptunghi implements InitializingBean, DisposableBean {
    private int lungime;
    private int latime;
    public Dreptunghi(int lungime, int latime) {
        this.lungime = lungime;
        this.latime = latime;
    }
    public void aria() {
        System.out.println("Aria dreptunghiului: "+(lungime*latime));
    }
    public void init(){
        System.out.println("init()");
    }
    public void disp(){
        System.out.println("disp()");
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean - afterPropertiesSet()");
    }
    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean - destroy()");
    }
}
