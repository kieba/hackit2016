package model;

import java.util.LinkedList;

public class Poll {

    protected int id;
    protected String title;
    protected long validUntil;
    protected String description;
    protected LinkedList<PollPart> pollParts;

    public Poll(int id, String title, long validUntil, String description) {
        this.id = id;
        this.title = title;
        this.validUntil = validUntil;
        this.description = description;
    }
}
