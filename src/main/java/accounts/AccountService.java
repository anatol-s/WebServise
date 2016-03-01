package accounts;

import java.util.HashMap;
import java.util.Map;

public class AccountService {
    private static AccountService instance;

    private final Map<String, UserProfile> loginToProfile;
    private final Map<String, UserProfile> sessionIdToProfile;

    public static AccountService getInstance() {
        if (instance == null) {
            instance = new AccountService();
        }
        return instance;
    }

    private AccountService() {
        loginToProfile = new HashMap<>();
        sessionIdToProfile = new HashMap<>();
    }

    public void addNewUser(UserProfile userProfile) {
        loginToProfile.put(userProfile.getLogin(), userProfile);
    }

    public UserProfile getUserByLogin(String login) {
        return loginToProfile.get(login);
    }
}