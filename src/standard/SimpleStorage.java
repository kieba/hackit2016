package standard;

import exception.AlreadyExistException;
import exception.AlreadyVotedException;
import model.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class SimpleStorage implements IStorage{
    private static SimpleStorage INSTANCE;

    private int lastUserId = 0;
    private int lastPollId = 0;

    HashMap<Integer, User> users = new HashMap<>();
    HashMap<Integer, Poll> polls = new HashMap<>();
    HashSet<PollAnswer> votes = new HashSet<>();


    public static SimpleStorage getINSTANCE(){
        if(INSTANCE == null){
            INSTANCE = new SimpleStorage();
            ExampleData.fillData(INSTANCE);
        }
        return INSTANCE;
    }

    private SimpleStorage(){}

    @Override
    public User getUser(String name) {
        for (User user :
                users.values()) {
            if(user.getName().equals(name)){
                return user;
            }
        }
        return null;
    }

    @Override
    public User getUser(int id) {
        return users.get(id);
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public User createUser(User user) throws AlreadyExistException {
        for (User existingUser: users.values()) {
            if(existingUser.getName().equals(user.getName())){
                throw new AlreadyExistException("The username is already in use.");
            }
        }


        user.setId(++lastUserId);
        users.put(user.getId(), user);
        return user;
    }

    @Override
    public Iterator<Poll> getPollsByPostcode(int postcode) {
        LinkedList<Poll> polls = new LinkedList<>();
        for (Poll poll:polls) {
            if(poll.getPolitician().getAffiliations().contains(postcode)){
                polls.add(poll);
            }
        }
        return polls.iterator();
    }

    @Override
    public Iterator<Poll> getOpenPollsByPostcode(int postcode) {
        LinkedList<Poll> tmp = new LinkedList<>();
        for (Poll poll:polls.values()) {
            if(poll.getValidUntil() >= System.currentTimeMillis()){
                tmp.add(poll);
            }
        }
        return tmp.iterator();
    }

    @Override
    public Iterator<Poll> getPollsByPolitician(Politician politician) {
        LinkedList<Poll> tmp = new LinkedList<>();
        for (Poll poll:polls.values()) {
            if(poll.getPolitician() == politician){
                tmp.add(poll);
            }
        }
        return tmp.iterator();
    }

    @Override
    public Poll savePoll(Poll poll) {
        if(!polls.containsValue(poll)){
            poll.setId(++lastPollId);
            polls.put(poll.getId(), poll);
        }
        return poll;
    }

    @Override
    public Poll getPollById(int id) {
        if(id == -1){
            id = 1;
        }
        return polls.get(id);
    }

    @Override
    public void doVote(PollAnswer answer) throws AlreadyVotedException {
        for (PollAnswer existingAnswer : votes) {
            if(existingAnswer.getPoll() == answer.getPoll() &&
                    existingAnswer.getCitizen() == answer.getCitizen()){
                throw new AlreadyVotedException();
            }
        }
        votes.add(answer);
    }

    public boolean hasVoted(Poll poll, Citizen user){
        for (PollAnswer existingAnswer : votes) {
            if(existingAnswer.getPoll() == poll &&
                    existingAnswer.getCitizen() == user){
                return true;
            }
        }

        return false;
    }
}
