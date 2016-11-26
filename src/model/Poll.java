package model;

import java.util.Iterator;
import java.util.LinkedList;

public class Poll {

    protected int id;
    protected String title;
    protected long validUntil;
    protected String description;
    protected LinkedList<PollPart> pollParts;

    public String getTitle() {
        return title;
    }

    public Politician getPolitician() {
        return politician;
    }

    protected Politician politician;


    public Poll(int id, Politician politician, String title, long validUntil, String description) {
        this(politician, title, validUntil, description);
        this.id = id;
    }

    public Poll(Politician politician, String title, long validUntil, String description) {
        this.politician = politician;
        this.title = title;
        this.validUntil = validUntil;
        this.description = description;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(long validUntil) {
        this.validUntil = validUntil;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPolitician(Politician politician) {
        this.politician = politician;
    }

    public void addPollPart(PollPart value){
        pollParts.add(value);
    }

    public boolean removePollPart(PollPart pollPart){
        return pollParts.remove(pollPart);
    }

    public Iterator<PollPart> getPollParts(){
        return pollParts.iterator();
    }
}
