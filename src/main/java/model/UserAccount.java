package model;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Table(name = "user_account")
public class UserAccount {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_name", unique = true)
    @Pattern(regexp = "^[a-zA-Z0-9]{5,}$", message = "Username should contain at least 5 letters or digits")
    private String userName;

    @Column(name = "email")
    @Pattern(regexp = "^\\S+@\\S+$", message = "Email is not in a correct form")
    @NotEmpty(message = "Email is required")
    private String email;

    @Column(name = "password")
    //@Pattern(regexp = "^[a-zA-Z0-9]{5,}$", message = "Password should contain at least 5 letters or digits")
   // @NotEmpty(message = "Password is required")
    private String password;

    @Range(min = 0, message = "Positive number is required")
    @Column(name = "money")
    private float money;

    @NotEmpty(message = "Gender is required")
    @Column(name = "gender")
    private String gender;

    @Column(name = "avatar")
    private String avatar;


    @OneToMany(mappedBy = "userAccountInRole", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<UserRole> userRole = new HashSet<UserRole>(0);

    @OneToMany(mappedBy = "userAccount", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<Product> products = new HashSet<Product>(0);

    @OneToOne(mappedBy = "userAccountRef", fetch = FetchType.LAZY , cascade = CascadeType.REMOVE)
    private UserConfirmation userConfirmation;

    @OneToMany(mappedBy = "fromu", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    //@OrderBy("date_sent ASC ")
    private Set<Message> messagesFrom = new TreeSet<>();

    @OneToMany(mappedBy = "tou", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    //@OrderBy("date_sent ASC ")
    private Set<Message> messagesTo = new TreeSet<>();



    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setProducts(Set<Product> prducts) {
        this.products = prducts;
    }

    public Set<Message> getMessagesFrom() {
        return messagesFrom;
    }

    public void setMessagesFrom(Set<Message> messagesFrom) {
        this.messagesFrom = messagesFrom;
    }

    public Set<Message> getMessagesTo() {
        return messagesTo;
    }

    public void setMessagesTo(Set<Message> messagesTo) {
        this.messagesTo = messagesTo;
    }

    public Set<Product> getProducts() {
        return products;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserConfirmation getUserConfirmation() {
        return userConfirmation;
    }

    public void setUserConfirmation(UserConfirmation userConfirmation) {
        this.userConfirmation = userConfirmation;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAvatar() {
        return avatar;
    }

    public Set<UserRole> getUserRole() {
        return this.userRole;
    }

    public void setUserRole(Set<UserRole> userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {

        return "userId= "+this.id+", userName= "+ this.userName + ", password= "+ this.password + ", email =" +this.email +", money ="+ this.money + ", avatar = "+ this.avatar + ", gender = "  +this.gender;

    }
}