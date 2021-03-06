package standard;

import model.Citizen;
import model.Politician;
import model.User;

public class AccountLogic {

    private User user;

    public AccountLogic(int id){
        this.user = SimpleStorage.getINSTANCE().getUser(id);
    }

    public User getUser(){
        return user;
    }

    public boolean isPolitician(){
        return user instanceof Politician;
    }

    public boolean isCitizen(){
        return user instanceof Citizen;
    }

    public String printHiddenField(){
        return "<input type=\"hidden\" name=\"account_id\" value=\"" + user.getId() + "\">";
    }

    public static AccountLogic login(String name){

        User user = SimpleStorage.getINSTANCE().getUser(name);
        if(user == null){
            return null;
        }
        return new AccountLogic(user.getId());
    }

}
