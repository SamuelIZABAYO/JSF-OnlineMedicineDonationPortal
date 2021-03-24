
package Model.Domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Builder;

/**
 *
 * @author eddy
 */
    @MappedSuperclass
    @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
    public class User implements Serializable {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long userId;
    private String userName;
    private String password;
    private String name;
    private String location;
    private String contactNo;
    @Transient
    private String roles;

    public User(String userName, String password, String name, String location, String contactNo) {
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.location = location;
        this.contactNo = contactNo;
    } 
    
    public User() {
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
    
}
