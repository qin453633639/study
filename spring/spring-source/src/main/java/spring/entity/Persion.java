package spring.entity;

import org.springframework.context.SmartLifecycle;

import java.util.Objects;

/**
 * Created by qinwei on 2018/2/6.
 */
public class Persion   {

    private User u = new User();
    private String name;

    public User getU() {
        return u;
    }

    public void setU(User u) {
        this.u = u;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Persion( ) {


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Persion)) return false;
        Persion persion = (Persion) o;
        return Objects.equals(u, persion.u) &&
                Objects.equals(name, persion.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(u, name);
    }
}
