import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

public class Main extends ListenerAdapter {
    public static void main (String[]args) throws LoginException {
        Bot bot = new Bot();
        bot.start();
    }
}
