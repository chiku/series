package org.chiku;

import java.util.HashMap;

public class ShuffleOperations {

    private final StringBuilder builder;
    private int size;

    public ShuffleOperations(int size) {
        this.builder = new StringBuilder();
        this.size = size;
    }

    public void shuffle() {
        builder.append("[");
        for (int i = 1; i < size; i++) {
            addPair(i);
            builder.append(", ");
        }
        addPair(size);
        builder.append("]");
    }

    private void addPair(int i) {
        builder.append("[");
        builder.append(i);
        builder.append(", ");
        builder.append(new ShuffleOperation(i).shuffleTimes());
        builder.append("]");
    }

    public HashMap<String, String> result() {
        HashMap<String, String> scopes = new HashMap<String, String>();
        scopes.put("data", builder.toString());
        return scopes;
    }
}
