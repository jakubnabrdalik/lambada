package eu.solidcraft;

import eu.solidcraft.domain.Book;
import eu.solidcraft.domain.Chapter;
import eu.solidcraft.dtos.BookDto;
import eu.solidcraft.dtos.ChapterDto;

import java.util.ArrayList;
import java.util.List;

public class ClassicJavaBookConverter {

    public List<BookDto> convertToDtos(List<Book> books) {
        List<BookDto> bookDtos = new ArrayList<>();
        for(Book book : books) {
            bookDtos.add(convertBookDto(book));
        }
        return bookDtos;
    }

    private BookDto convertBookDto(Book book) {
        return new BookDto( book.getId(), book.getTitle(), book.getAuthor(),
                book.getIsbn(), convertChapterDtos(book.getChapters()));
    }

    private List<ChapterDto> convertChapterDtos(List<Chapter> chapters) {
        List<ChapterDto> chapterDtos = new ArrayList<>();
        for(Chapter chapter : chapters) {
            chapterDtos.add(convertChapterDto(chapter));
        }
        return chapterDtos;
    }

    private ChapterDto convertChapterDto(Chapter chapter) {
        return new ChapterDto(chapter.getTitle(), chapter.getText());
    }
}