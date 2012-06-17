
package eu.solidcraft

import eu.solidcraft.domain.Book
import eu.solidcraft.domain.Chapter
import eu.solidcraft.dtos.BookDto
import eu.solidcraft.dtos.ChapterDto

public class RealGroovyBookConverter {
    public List<BookDto> convertToDtos(List<Book> books) {
        return books.collect { Book book ->
            new BookDto(book.id, book.title, book.author, book.isbn,
                    book.getChapters().collect { Chapter chapter ->
                        new ChapterDto(chapter.title, chapter.text)
                    }
            )
        }
    }
}
