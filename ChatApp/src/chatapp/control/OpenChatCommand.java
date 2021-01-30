
package chatapp.control;

import chatapp.model.Chat;
import chatapp.view.ChatDisplay;
import chatapp.view.ChatListDisplay;
import chatapp.view.ChatLoader;
import java.util.List;

public class OpenChatCommand implements Command{
    
    private final ChatLoader chatLoader;
    private final ChatListDisplay chatListDisplay;
    private final ChatDisplay chatDisplay;
    
    public OpenChatCommand (ChatLoader chatLoader, ChatListDisplay chatListDisplay, ChatDisplay chatDisplay){
        this.chatLoader = chatLoader;
        this.chatDisplay = chatDisplay;
        this.chatListDisplay = chatListDisplay;
    }
    
    @Override
    public void execute() {
        List<Chat> chats = this.chatLoader.load();
        for (Chat chat : chats){
            chat.register(chatListDisplay);
        }
        
        this.chatListDisplay.display(this.chatLoader.load());
        this.chatListDisplay.on(chatSelected());
    }

    private ChatListDisplay.ChatSelected chatSelected() {
        return new ChatListDisplay.ChatSelected() {
            @Override
            public void chat(Chat chat) {
                protect(chatDisplay.chat()).unsubscribe(chatDisplay);
                chat.subscribe(chatDisplay);
                chatDisplay.display(chat);
                
            }
        };
  
    }
    
    private Chat protect(Chat chat){
        return chat != null ? chat : Chat.Null;
        
    }
 
}

