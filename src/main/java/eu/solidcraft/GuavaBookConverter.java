package eu.solidcraft;

import com.google.common.base.Function;
import eu.solidcraft.domain.Book;
import eu.solidcraft.domain.Chapter;
import eu.solidcraft.dtos.BookDto;
import eu.solidcraft.dtos.ChapterDto;

import javax.annotation.Nullable;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Lists.transform;

public class GuavaBookConverter {

    public List<BookDto> convertToDtos(List<Book> books) {
        return newArrayList(transform(books, bookConverterFunction));
    }

    private final Function<Book, BookDto> bookConverterFunction = new Function<Book, BookDto>() {
        public BookDto apply(@Nullable Book book) {
            return new BookDto().
                    withId(book.getId()).
                    withTitle(book.getTitle()).
                    withAuthor(book.getAuthor()).
                    withIsbn(book.getIsbn()).
                    withChapters(newArrayList(transform(book.getChapters(), chapterConverterFunction)));
        }
    };

    private final Function<Chapter, ChapterDto> chapterConverterFunction = new Function<Chapter, ChapterDto>() {
        public ChapterDto apply(@Nullable Chapter chapter) {
            return new ChapterDto().
                    withText(chapter.getText()).
                    withTitle(chapter.getTitle());
        }
    };
}