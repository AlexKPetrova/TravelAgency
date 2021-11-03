package models;

public class Client {

    private int id;
    private int humanId;
    private int countryId;
    private int hotelId;

    public Client(int id, int humanId, int countryId, int hotelId) {
        this.id = id;
        this.humanId = humanId;
        this.countryId = countryId;
        this.hotelId = hotelId;
    }

    public Client(int humanId, int countryId, int hotelId) {
        this.humanId = humanId;
        this.countryId = countryId;
        this.hotelId = hotelId;
    }

    public Client(int humanId, int countryId) {
        this.humanId = humanId;
        this.countryId = countryId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHumanId() {
        return humanId;
    }

    public void setHumanId(int humanId) {
        this.humanId = humanId;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }
}
