package model;

import java.util.LinkedList;

public class PollPart {
    protected LinkedList<PollPartOption> options;
    protected int partNo;
    protected String question;

    public PollPart( LinkedList<PollPartOption> options, int partNo, String question) {
        this.options = options;
        this.partNo = partNo;
        this.question = question;
    }


    public LinkedList<PollPartOption> getOptions() {
        return options;
    }

    public void setOptions(LinkedList<PollPartOption> options) {
        this.options = options;
    }

    public int getPartNo() {
        return partNo;
    }

    public void setPartNo(int partNo) {
        this.partNo = partNo;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
