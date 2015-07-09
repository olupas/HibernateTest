package my.model;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @author olupas
 * @since 15.08.2014
 */
public class Profile implements Serializable {

    private Integer id;
    private String name;
    private User user;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", user=" + user.getId() +
                '}';
    }
}
