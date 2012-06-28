
package eu.solidcraft

import ch.lambdaj.function.argument.ArgumentConversionException
import ch.lambdaj.function.closure.WrongClosureInvocationException
import eu.solidcraft.domain.Book
import eu.solidcraft.domain.Chapter
import eu.solidcraft.dtos.BookDto
import eu.solidcraft.dtos.ChapterDto
import spock.lang.Unroll

import spock.lang.Specification

class BookConvertersTest extends Specification {
    static List<Book> booksToConvert = [ createBook(1), createBook(2), createBook(3)]
    static List<BookDto> expectedDtos = [ createBookDto(1), createBookDto(2), createBookDto(3)]

    @Unroll("#converter.class.getSimpleName() converts well")
    def "Converters should convert" () {
        expect:
            expectedDtos == converter.convertToDtos(booksToConvert)

        where:
            converter << [
                    new OldJavaBookConverter(),
                    new ClassicJavaBookConverter(),
                    new GuavaBookConverter(),
                    new NaiveGroovyBookConverter(),
                    new RealGroovyBookConverter(),
                    new EvenMoreRealGroovyBookConverter()
            ]
    }

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

    def "LambdaJ has it's limitations"() {
        when:
            new NaiveLambdajBookConverter().convertToDtos(booksToConvert)

        then:
            thrown(ArgumentConversionException)
    }

    def "LambdaJ closure cannot be nested"() {
        when:
            new LabdajWithClosuresBookConverter().convertToDtos(booksToConvert)

        then:
            thrown(WrongClosureInvocationException)
    }
}
