package dmitry.borodin.console.game.utils;

import java.util.ArrayList;
import java.util.List;

public class MessageHolder {

    private static List<Message> messages = new ArrayList<>();

    public static void addErrorMessage(String errorMessage) {
        messages.add(new Message(errorMessage, Message.Type.ERROR));
    }

    public static void addInfoMessage(String infoMessage) {
        messages.add(new Message(infoMessage, Message.Type.INFO));
    }

    public static List<Message> getMessages() {
        return messages;
    }

    public static void eraseErrors() {
        messages = new ArrayList<>();

    }
}
