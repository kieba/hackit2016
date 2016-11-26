package model;

import java.util.Iterator;
import java.util.LinkedList;

public class Poll {

    protected int id;
    protected String title;
    protected long validUntil;
    protected String description;
    protected LinkedList<PollPart> pollParts;

    public Poll(int id, String title, long validUntil, String description) {
        this(title, validUntil, description);
        this.id = id;
    }

    public Poll(String title, long validUntil, String description) {
        this.title = title;
        this.validUntil = validUntil;
        this.description = description;
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
