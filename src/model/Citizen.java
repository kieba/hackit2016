package model;

public class Citizen extends User{
    protected int postcode;

    public Citizen(String name, int id, int postcode) {
        super(name, id);
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }
}
