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
            BookDto bookDto = convertBookDto(book);
            List<ChapterDto> chapterDtos = new ArrayList<>();
            for(Chapter chapter : book.getChapters()) {
                convertChapterDto(chapterDtos, chapter);
            }
            bookDto.withChapters(chapterDtos);
            bookDtos.add(bookDto);
        }
        return bookDtos;
    }

    private void convertChapterDto(List<ChapterDto> chapterDtos, Chapter chapter) {
        chapterDtos.add(
                new ChapterDto(chapter.getTitle(), chapter.getText())
        );
    }

    private BookDto convertBookDto(Book book) {
        return new BookDto().
                        withId(book.getId()).
                        withTitle(book.getTitle()).
                        withAuthor(book.getAuthor()).
                        withIsbn(book.getIsbn());
    }
}