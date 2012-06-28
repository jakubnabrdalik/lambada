
package eu.solidcraft

import eu.solidcraft.domain.Book
import org.junit.Test

class BookCategoryTest {

    @Test
    void "showing categories and mixins"() {

        Book book = new Book(1, "Wiedźmin", "Andrzej Sapkowski", "4657987", [])
        assert book.toString().startsWith("eu.solidcraft.domain.Book")

        use(BookToStringCategory) {
            assert "Wiedźmin" == book.toString()
        }
    }

}


@Category(Book)
class BookToStringCategory {
    public String toString() {
        this.title
    }
}