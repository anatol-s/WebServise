package accounts;

import db.DBException;
import db.DBService;
import db.dataSets.UsersDataSet;

public class AccountService {

    public void addNewUser(UserProfile userProfile) {
        DBService dbService = new DBService();
        try {
            dbService.addUser(userProfile.getLogin(), userProfile.getPass());
        } catch (DBException e) {
            e.printStackTrace();
        }
    }

    public UserProfile getUserByLogin(String login) {
        DBService dbService = new DBService();
        try {
            UsersDataSet usersDataSet = dbService.getUserByName(login);
            return usersDataSet != null ? new UserProfile(usersDataSet.getName(), usersDataSet.getPass()) : null;
        } catch (DBException e) {
            e.printStackTrace();
        }
        return null;
    }
}
