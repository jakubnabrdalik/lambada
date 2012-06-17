
package eu.solidcraft

import eu.solidcraft.domain.Book
import eu.solidcraft.dtos.BookDto
import eu.solidcraft.dtos.ChapterDto

class EvenMoreRealGroovyBookConverter {
    List<BookDto> convertToDtos(List<Book> books) {
        books.collect {
            new BookDto(it.id, it.title, it.author, it.isbn, it.getChapters().collect {
                    new ChapterDto(it.title, it.text)})}
    }
}
