package dev.negativekb.bot.core.util;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class Message {

    @Getter
    private final String initial;
    @Getter
    @Setter
    private String message;

    /**
     * Message Constructor (as String)
     *
     * @param msg Message
     */
    public Message(String... msg) {
        String actual = String.join("\n", msg);
        setMessage(actual);
        this.initial = actual;
    }

    /**
     * Replacer
     * <p>
     * Simply replaces object1 with object2.
     * Could be a string, int, double, whatever
     *
     * @param o1 - Object 1
     * @param o2 - Object 2
     * @return - Returns replaced value
     */
    public Message replace(Object o1, Object o2) {
        if (o2 instanceof Integer || o2 instanceof Double || o2 instanceof Long) {
            o2 = Utils.decimalFormat(o2);
        }

        String newMSG = this.message;

        newMSG = newMSG.replaceAll(String.valueOf(o1), String.valueOf(o2));

        setMessage(newMSG);
        return this;
    }


}
