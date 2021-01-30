
package chatapp.view;

import chatapp.model.Chat;

public interface ChatDisplay extends Chat.Observer{
    
    Chat chat();
    void display (Chat chat);


    
    
}
