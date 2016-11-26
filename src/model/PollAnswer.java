package model;

public class PollAnswer {
    private Poll poll;
    private Citizen citizen;

    public PollAnswer(Poll poll, Citizen citizen) {
        this.poll = poll;
        this.citizen = citizen;
    }

    public Poll getPoll() {
        return poll;
    }

    public void setPoll(Poll poll) {
        this.poll = poll;
    }

    public Citizen getCitizen() {
        return citizen;
    }

    public void setCitizen(Citizen citizen) {
        this.citizen = citizen;
    }
}
