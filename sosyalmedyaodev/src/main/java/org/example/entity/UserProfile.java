package org.example.entity;


import jakarta.persistence.*;

@Entity
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    @Column(unique = true)
    private String username ;
    private String password;

    public UserProfile(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserProfile() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static class Builder{

        private int id ;
        private String username ;
        private String password;

        public Builder id(int id ){
            this.id=id;
            return this;
        }
        public Builder userName(String username){
                this.username=username;
                return this;
        }
        public  Builder password(String password){
            this.password=password;
            return this;
        }

        public static  Builder userBuilder(){
            return  new Builder();
        }
        public  UserProfile build(){
            UserProfile userProfile=new UserProfile();
            userProfile.setId(this.id);
            userProfile.setUsername(this.username);
            userProfile.setPassword(this.password);
            return userProfile;
        }


    }

}
