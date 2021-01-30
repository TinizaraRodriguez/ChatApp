
package chatapp.model;

import chatapp.view.ChatDisplay;


public class Chat {
    
    public static Chat Null = new Chat(){
        @Override
        public void unsubscribe (Observer obsever){

        }
        
        @Override
        public void subscribe(Observer observer){

        }
    };

    public void register(Observer observer) {
        
    }
    
    public void unsubscribe(Observer chatDisplay){
        
    }

    public void subscribe(Observer observer) {
       
    }
    
    public interface Observer{
        void updated();
    }
    
}
