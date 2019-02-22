package dmitry.borodin.console.game.utils;

public class Message {

    private final String message;
    private final Type type;

    public Message(String message, Type type) {
        this.message = message;
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public Type getType() {
        return type;
    }

    public enum Type {
        ERROR,
        INFO
    }
}
