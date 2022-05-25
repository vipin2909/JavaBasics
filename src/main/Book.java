package main;
//import builder.pattern.Genre;
import java.time.Year;

public class Book {
    private final String isbn;
    private final String title;
    private final String author;
    private final Year published;
    private final String description;

    private Book(Builder builder) {
        this.isbn = builder.isbn;
        this.title = builder.title;
        this.author = builder.author;
        this.published = builder.published;
        this.description = builder.description;

    }

    public String getIsbn() {
        return isbn;
    }
    public String getTitle() {
        return title;

    }
    public String getAuthor() {
        return author;

    }
    public Year getPublished() {
        return published;
    }
    public String getDescription() {
        return description;
    }

    public static class Builder {
        private String isbn;
        private String title;
        private String author;
        private Year published;
        private String description;

        public Builder(String isbn, String title) {
            this.isbn = isbn;
            this.title = title;
        }
        public Builder() {

        }
        public Builder author(String author) {
            this.author = author;
            return this;
        }
        public Builder published(Year published) {
            this.published = published;
            return this;
        }
        public Builder description(String description) {
            this.description = description;
            return this;
        }


        public Book build() {
            return new Book(this);
        }
    }
    public static Builder builder() {
        return new Builder();
    }
}
