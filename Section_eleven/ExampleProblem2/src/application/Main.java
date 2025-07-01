package application;

import entities.Comment;
import entities.Post;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {

        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        Post postOne = new Post(
            LocalDateTime.parse("21/06/2018 13:05:44", format),
            "Traveling to New Zealend",
            "I'm going to visit this wonderful country!",
            12
        );

        postOne.addComment(new Comment("Have a nice trip!"));
        postOne.addComment(new Comment("Wow that's awesome!"));

        Post postTwo = new Post(
                LocalDateTime.parse("28/07/2018 23:14:19", format),
                "Good night guys",
                "See you tomorrow",
                5
        );

        postTwo.addComment(new Comment("Good night"));
        postTwo.addComment(new Comment("May the force be with you"));

        out.println(postOne.toString());
        out.println(postTwo.toString());
    }
}