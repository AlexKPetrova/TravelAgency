package models;

public class User {

    private int id;
    private String name;
    private String dateOfBirth;
    private int countryOfResidence;
    private int citizenship;

    private String login;
    private int password;


    public User(int id, String name, String dateOfBirth, int countryOfResidence,
                int citizenship, String login, int password) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.countryOfResidence = countryOfResidence;
        this.citizenship = citizenship;
        this.login = login;
        this.password = password;
    }

    public User(String name, String dateOfBirth, int countryOfResidence, int citizenship, String login, int password) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.countryOfResidence = countryOfResidence;
        this.citizenship = citizenship;
        this.login = login;
        this.password = password;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getCountryOfResidence() {
        return countryOfResidence;
    }

    public void setCountryOfResidence(int countryOfResidence) {
        this.countryOfResidence = countryOfResidence;
    }

    public int getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(int citizenship) {
        this.citizenship = citizenship;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }
}

