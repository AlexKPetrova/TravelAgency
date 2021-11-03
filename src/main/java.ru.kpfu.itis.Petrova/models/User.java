package models;

public class User {

    private int id;
    private String name;
    private String dateOfBirth;
    private int countryOfResidenceId;
    private int citizenshipId;

    private String login;
    private String password;


    public User(int id, String name, String dateOfBirth, int countryOfResidence,
                int citizenship, String login, String password) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.countryOfResidenceId = countryOfResidence;
        this.citizenshipId = citizenship;
        this.login = login;
        this.password = password;
    }

    public User(String name, String dateOfBirth, int countryOfResidence, int citizenship, String login, String password) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.countryOfResidenceId = countryOfResidence;
        this.citizenshipId = citizenship;
        this.login = login;
        this.password = password;
    }

    public User(int countryOfResidenceId, int citizenshipId, String login, String password) {
        this.countryOfResidenceId = countryOfResidenceId;
        this.citizenshipId = citizenshipId;
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

    public int getCountryOfResidenceId() {
        return countryOfResidenceId;
    }

    public void setCountryOfResidenceId(int countryOfResidenceId) {
        this.countryOfResidenceId = countryOfResidenceId;
    }

    public int getCitizenshipId() {
        return citizenshipId;
    }

    public void setCitizenshipId(int citizenshipId) {
        this.citizenshipId = citizenshipId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", countryOfResidenceId=" + countryOfResidenceId +
                ", citizenshipId=" + citizenshipId +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

