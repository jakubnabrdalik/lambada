package eu.solidcraft;

import eu.solidcraft.domain.Book;
import eu.solidcraft.domain.Chapter;
import eu.solidcraft.dtos.BookDto;
import eu.solidcraft.dtos.ChapterDto;

import java.util.ArrayList;
import java.util.List;

public class OldJavaBookConverter {

    public List<BookDto> convertToDtos(List<Book> books) {
        List<BookDto> bookDtos = new ArrayList<>();
        for(Book book : books) {
            List<ChapterDto> chapterDtos = new ArrayList<>();
            for(Chapter chapter : book.getChapters()) {
                ChapterDto chapterDto = new ChapterDto(chapter.getTitle(), chapter.getText());
                chapterDtos.add(chapterDto);
            }
            BookDto bookDto = new BookDto( book.getId(), book.getTitle(), book.getAuthor(),
                                           book.getIsbn(), chapterDtos);
            bookDtos.add(bookDto);
        }
        return bookDtos;
    }

}
