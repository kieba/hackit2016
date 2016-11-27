package standard;

import exception.AlreadyExistException;
import exception.AlreadyVotedException;
import model.*;

import java.util.Iterator;

public interface IStorage {
    User getUser(String name);
    User getUser(int id);

    void updateUser(User user);
    User createUser(User user) throws AlreadyExistException;

    Iterator<Poll> getPollsByPostcode(int postcode);
    Iterator<Poll> getOpenPollsByPostcode(int postcode);
    Iterator<Poll> getPollsByPolitician(Politician politician);

    Poll savePoll(Poll poll);
    Poll getPollById(int id);

    void doVote(PollAnswer answer) throws AlreadyVotedException;
}
