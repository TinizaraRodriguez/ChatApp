
package chatapp.view;

import chatapp.model.Chat;
import java.util.List;

public interface ChatListDisplay extends Chat.Observer{
    
    void display (List<Chat> chats);
    void on (ChatSelected chatSelected);
    
    public interface ChatSelected{
        void chat(Chat chat);
    }
    
}
