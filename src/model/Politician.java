package model;

import java.util.HashSet;

public class Politician extends User{
    private HashSet<Integer> affiliation = new HashSet<>();


    public Politician(String name, int id) {
        super(name, id);
    }

    public Politician(String name){
        super(name);
    }

    public boolean addAffiliation(int postCode){
        return affiliation.add(postCode);
    }

    public boolean removeAffiliation(int postCode){
        return affiliation.remove(postCode);
    }

    public HashSet<Integer> getAffiliations() {
        return affiliation;
    }

}
