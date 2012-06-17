
package eu.solidcraft

import eu.solidcraft.domain.Book
import eu.solidcraft.domain.Chapter
import eu.solidcraft.dtos.BookDto
import spock.lang.Specification
import eu.solidcraft.dtos.ChapterDto
import spock.lang.Unroll

class BookConvertersTest extends Specification {
    static List<Book> booksToConvert = [ createBook(1), createBook(2), createBook(3)]
    static List<BookDto> expectedDtos = [ createBookDto(1), createBookDto(2), createBookDto(3)]

    static BookDto createBookDto(int i) {
        new BookDto(i, "title $i", "author $i", "isbn $i", [createChapterDto(i, 1), createChapterDto(i, 2), createChapterDto(i, 3)])
    }

    static ChapterDto createChapterDto(int bookI, int i) {
        new ChapterDto("title $bookI, $i", "text $bookI, $i")
    }

    static Book createBook(int i) {
        new Book(i, "title $i", "author $i", "isbn $i", [createChapter(i, 1), createChapter(i, 2), createChapter(i, 3)])
    }

    static Chapter createChapter(int bookI, int i) {
        new Chapter("title $bookI, $i", "text $bookI, $i")
    }

    @Unroll("test converter for #converter.class")
    def "Converters should convert" () {
        expect:
            dtos == converter.convertToDtos(booksToConvert)

        where:
            converter                             | dtos
            new ClassicJavaBookConverter()        | expectedDtos
            new GuavaBookConverter()              | expectedDtos
//          new NaiveLambdajBookConverter()       | expectedDtos
            new NaiveGroovyBookConverter()        | expectedDtos
            new RealGroovyBookConverter()         | expectedDtos
            new EvenMoreRealGroovyBookConverter() | expectedDtos
    }
}
