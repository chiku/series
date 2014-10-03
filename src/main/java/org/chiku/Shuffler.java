package org.chiku;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Shuffler {

    public static void main(String[] args) throws IOException {
        ShuffleOperations operations = new ShuffleOperations(10000);
        operations.shuffle();
        HashMap<String, String> result = operations.result();

        MustacheFactory mf = new DefaultMustacheFactory();
        Mustache mustache = mf.compile("series.js.mustache");
        mustache.execute(new PrintWriter("public/series.js"), result).flush();
    }
}
