package eu.solidcraft;

import com.google.common.base.Function;
import eu.solidcraft.domain.Book;
import eu.solidcraft.domain.Chapter;
import eu.solidcraft.dtos.BookDto;
import eu.solidcraft.dtos.ChapterDto;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Lists.transform;

public class GuavaBookConverter {

    public List<BookDto> convertToDtos(List<Book> books) {
        return newArrayList(transform(books, bookConverterFunction));
    }

    private final Function<Book, BookDto> bookConverterFunction = new Function<Book, BookDto>() {
        public BookDto apply(Book book) {
            return new BookDto(book.getId(), book.getTitle(), book.getAuthor(), book.getIsbn(),
                    newArrayList(transform(book.getChapters(), chapterConverterFunction)));
        }
    };

    private final Function<Chapter, ChapterDto> chapterConverterFunction = new Function<Chapter, ChapterDto>() {
        public ChapterDto apply(Chapter chapter) {
            return new ChapterDto(chapter.getTitle(), chapter.getText());
        }
    };
}