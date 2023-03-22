package mk.ukim.finki.emtlab.model.enumerations;

public enum Category {
    NOVEL("NOVEL"),
    THRILER("THRILER"),
    HISTORY("HISTORY"),
    FANTASY("FANTASY"),
    BIOGRAPHY("BIOGRAPHY"),
    CLASSICS("CLASSICS"),
    DRAMA("DRAMA");

    private final String name;

    Category(String s) {
        name = s;
    }
}
