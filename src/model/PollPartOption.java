package model;

public class PollPartOption {
    private PollPart parrent;
    private int optionId;
    private String description;

    public PollPartOption(PollPart parrent, int optionId, String description) {
        this.parrent = parrent;
        this.optionId = optionId;
        this.description = description;
    }

    public PollPart getParrent() {
        return parrent;
    }

    public void setParrent(PollPart parrent) {
        this.parrent = parrent;
    }

    public int getOptionId() {
        return optionId;
    }

    public void setOptionId(int optionId) {
        this.optionId = optionId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
