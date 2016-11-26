package model;

public class PollPartAnswer {
    private PollPart part;
    private int optionId;

    public PollPartAnswer(PollPart part, int optionId) {
        this.part = part;
        this.optionId = optionId;
    }

    public PollPart getPart() {
        return part;
    }

    public void setPart(PollPart part) {
        this.part = part;
    }

    public int getOptionId() {
        return optionId;
    }

    public void setOptionId(int optionId) {
        this.optionId = optionId;
    }
}
