package Entity;

public class Users {

private int id;
private String name;
private String surname;
private String eMail;
private String password;

    public Users(int id, String name, String surname, String eMail, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.eMail = eMail;
        this.password = password;
    }

    public Users() {
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id + ", name='" + name + '\'' + ", surname='" + surname + '\'' +
                ", eMail='" + eMail + '\'' + ", password='" + password + '\'' + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public static class UserBuilder{

        private int id;
        private String name;
        private String surname;
        private String email;
        private String password;

        public UserBuilder Id(int id) {
            this.id = id;
            return this;
        }
        public UserBuilder Name(String name) {
            this.name = name;
            return this;
        }
        public UserBuilder Surname(String surname) {
            this.surname = surname;
            return this;
        }
        public UserBuilder eMail(String email) {
            this.email = email;
            return this;
        }
        public UserBuilder Password(String password) {
            this.password = password;
            return this;
        }

        public static UserBuilder startUserBuilder(){
            return new UserBuilder();
        }
        public Users build(){
            Users users = new Users();
            users.setId(id);
            users.setName(name);
            users.setSurname(surname);
            users.seteMail(email);
            users.setPassword(password);
            return users;
        }

    }
}
