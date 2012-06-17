package eu.solidcraft.domain;

import java.util.List;

public class Book {
    private Long id;
    private String title;
    private String author;
    private String isbn;
    private List<Chapter> chapters;

    public Book(Long id, String title, String author, String isbn, List<Chapter> chapters) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.chapters = chapters;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public List<Chapter> getChapters() {
        return chapters;
    }
}
