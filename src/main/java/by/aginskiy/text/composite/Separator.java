package by.aginskiy.text.composite;

public enum Separator {
    SYMBOL (""),
    LEXEME (" "),
    SENTENCE (" "),
    PARAGRAPH ("\n\t");

    private String separator;

    Separator(String separator) {
        this.separator = separator;
    }

    public String getSeparator() {
        return separator;
    }
}
