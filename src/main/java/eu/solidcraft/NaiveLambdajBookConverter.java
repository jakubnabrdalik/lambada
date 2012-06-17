package eu.solidcraft;

import eu.solidcraft.domain.Book;
import eu.solidcraft.domain.Chapter;
import eu.solidcraft.dtos.BookDto;
import eu.solidcraft.dtos.ChapterDto;

import java.util.List;

import static ch.lambdaj.Lambda.on;
import static ch.lambdaj.Lambda.project;

public class NaiveLambdajBookConverter {
    public List<BookDto> convertToDtos(List<Book> books) {
        return project(books, BookDto.class,
                    on(Book.class).getId(),
                    on(Book.class).getTitle(),
                    on(Book.class).getAuthor(),
                    on(Book.class).getIsbn(),
                    project(on(Book.class).getChapters(), ChapterDto.class,
                            on(Chapter.class).getTitle(),
                            on(Chapter.class).getText()));
    }
}
