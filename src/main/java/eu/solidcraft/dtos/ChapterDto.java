package eu.solidcraft.dtos;

public class ChapterDto {
    private String title;
    private String text;

    public ChapterDto() {
    }

    public ChapterDto(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public ChapterDto withTitle(String title) {
        this.title = title;
        return this;
    }

    public ChapterDto withText(String text) {
        this.text = text;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChapterDto that = (ChapterDto) o;

        if (text != null ? !text.equals(that.text) : that.text != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        return result;
    }
}
