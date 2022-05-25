package main;
import java.time.Year;
import java.util.Locale;

public class Builder {
    public static void main(String[] args) {
        Book.Builder book = new Book.Builder("0-12-345678-9", "Moby-Dick")
                .author("Herman Melville")
                .published(Year.of(1851))
                .description(
                        "The book is the sailor Ishmael's narrative of the obsessive quest of "
                                + "Ahab, captain of the whaling ship Pequod, for revenge on Moby Dick, "
                                + "the giant white sperm whale that on the ship's previous voyage bit "
                                + "off Ahab's leg at the knee."
                );
        Book ansBook = book.build();
        System.out.println(ansBook.getDescription()+"\t"+ansBook.getAuthor());

        Book p1 = Book.builder().author("Harley davidson").build();
        Locale e1 = new Locale.Builder()
                .setLanguage("en").setRegion("IN")
                .build();

        System.out.println("This is country: " + e1.getLanguage() + " and region: " + e1.getDisplayCountry());

        // UserDetails in Spring Security is an interface that tells us how a user Looks like

        // dummy example

        // we can easily recognize builder when attritbues are setted like that

        /*
          User.withUserName("")
          .password("user@gmail.com")
          .build();
         */
    }

}
