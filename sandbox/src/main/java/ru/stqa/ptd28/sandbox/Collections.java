package ru.stqa.ptd28.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {

  public static void main(String[] args) {
    String[] langs = new String[4];
    langs[0] = "Java";
    langs[1] = "C#";
    langs[2] = "Python";
    langs[3] = "PHP";

    // эта запись эквивалентра предыдущей
    String[] langs2 = {"Java2", "C#2", "Python2", "PHP2"};

    for (int i = 0; i < langs.length; i++) {
      System.out.println("Я хочу выучить " + langs[i]);
    }

    for (String l : langs2) {
      System.out.println("Я хочу выучить " + l);
    }

    List<String> languages = new ArrayList<String>();
    languages.add("Java3");
    languages.add("C#3");
    languages.add("Python3");
    languages.add("PHP3");

    for (String l : languages) {
      System.out.println("Я хочу выучить " + l);
    }

    List<String> languages2 = Arrays.asList("Java4", "C#4", "Python4", "PHP4");
    for (String k : languages2) {
      System.out.println("Я хочу выучить " + k);
    }

    for (int i = 0; i < languages2.size(); i++) {
      System.out.println("Я хочу выучить " + languages2.get(i));
    }

  }
}
