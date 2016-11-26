package model;

import java.util.HashSet;

public class Politician extends User{
    private HashSet<Integer> affiliation;


    public Politician(String name, int id) {
        super(name, id);
    }

    public HashSet<Integer> getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(HashSet<Integer> affiliation) {
        this.affiliation = affiliation;
    }
}
