import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDABuilder;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import javax.security.auth.login.LoginException;

public class Bot {
    private JDABuilder builder = new JDABuilder(AccountType.BOT);
    private String token = Secret.getToken();
    public Bot() {
        builder.setToken(token);

    }

    public void start() throws LoginException {
        builder.addEventListeners(new MainManager());
        builder.build();
    }
}
