package eu.solidcraft;

import ch.lambdaj.function.closure.Closure;
import eu.solidcraft.domain.Book;
import eu.solidcraft.domain.Chapter;
import eu.solidcraft.dtos.BookDto;
import eu.solidcraft.dtos.ChapterDto;

import java.util.ArrayList;
import java.util.List;

import static ch.lambdaj.Lambda.*;

public class LabdajWithClosuresBookConverter {
    public List<BookDto> convertToDtos(List<Book> books) {
        ArrayList<ChapterDto> chapterDtos = new ArrayList<>();
        Closure convertChapterDtos = closure(); {
            of(chapterDtos).add(
                    new ChapterDto( var(Chapter.class).getTitle(), var(Chapter.class).getText() )
            );
        }

        ArrayList<BookDto> bookDtos = new ArrayList<>();
        Closure convert = closure(); {
            of(bookDtos).add(new BookDto(
                    var(Book.class).getId(),
                    var(Book.class).getTitle(),
                    var(Book.class).getAuthor(),
                    var(Book.class).getIsbn(),
                    (List<ChapterDto>) convertChapterDtos.each(var(Book.class).getChapters())));
        }

        return (List<BookDto>) convert.each(books);
    }
}
