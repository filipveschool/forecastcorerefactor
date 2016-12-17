package be.ucll.forecast.domainrefactor;

import be.ucll.forecast.domainrefactor.enums.UserStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.NotBlank;
import org.mindrot.jbcrypt.BCrypt;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Filip and Tom on 17/12/2016.
 */
@Entity
@Table(name = "users")
@JsonIgnoreProperties({"id"})
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    @NotBlank(message = "{NotBlank.User.userName}")
    @Column(name = "name", unique = true)
    private String userName;

    @NotBlank (message = "{NotBlank.User.password}")
    @Column (name = "password")
    private String password;

    @NotNull(message = "NotNull.User.status")
    @Column (name = "status")
    @Enumerated (EnumType.STRING)
    private UserStatus status;

    public User() {

    }

    public User( String username, String passwordNotEncrypted ) {
        setUserName ( username );
        setPassword ( passwordNotEncrypted );
        setStatus ( UserStatus.ACTIVE );
    }

    @JsonIgnore
    public Integer getId() {
        return id;
    }

    public void setId( Integer id ) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName( String userName ) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword( String passwordNotEncrypted ) {
        String salt = BCrypt.gensalt (12);
        this.password = BCrypt.hashpw ( passwordNotEncrypted, salt );
    }

    public boolean passwordEqualsEncryptedPassword(String passwordNotEncrypted){
        return BCrypt.checkpw ( passwordNotEncrypted, password );
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus( UserStatus status ) {
        this.status = status;
    }
}
