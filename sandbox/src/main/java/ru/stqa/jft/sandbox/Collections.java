package ru.stqa.jft.sandbox;

import java.util.Arrays;
import java.util.List;

public class Collections {
    public static void main(String[] args) {
        List<String> languages = Arrays.asList("Java","C#", "Python", "PHP");

        for (int i = 0; i < languages.size(); i++) {
            System.out.println("i am pro in " + languages.get(i));
        }
    }
}
