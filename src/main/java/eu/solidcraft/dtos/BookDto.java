package eu.solidcraft.dtos;

import java.util.List;

public class BookDto {
    private Long id;
    private String title;
    private String author;
    private String isbn;
    private List<ChapterDto> chapters;

    public BookDto() {
    }

    public BookDto(Long id, String title, String author, String isbn, List<ChapterDto> chapters) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.chapters = chapters;
    }

    public BookDto withId(Long id) {
        this.id = id;
        return this;
    }

    public BookDto withTitle(String title) {
        this.title = title;
        return this;
    }

    public BookDto withAuthor(String author) {
        this.author = author;
        return this;
    }

    public BookDto withIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public BookDto withChapters(List<ChapterDto> chapters) {
        this.chapters = chapters;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookDto bookDto = (BookDto) o;

        if (author != null ? !author.equals(bookDto.author) : bookDto.author != null) return false;
        if (chapters != null ? !chapters.equals(bookDto.chapters) : bookDto.chapters != null) return false;
        if (id != null ? !id.equals(bookDto.id) : bookDto.id != null) return false;
        if (isbn != null ? !isbn.equals(bookDto.isbn) : bookDto.isbn != null) return false;
        if (title != null ? !title.equals(bookDto.title) : bookDto.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (isbn != null ? isbn.hashCode() : 0);
        result = 31 * result + (chapters != null ? chapters.hashCode() : 0);
        return result;
    }
}
