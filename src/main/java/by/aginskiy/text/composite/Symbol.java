package by.aginskiy.text.composite;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Symbol implements Component {

    private static final Logger logger = LogManager.getLogger();
    private TextLayer layer = TextLayer.SYMBOL;
    private Separator separator = Separator.SYMBOL;
    private char letter;

    public Symbol(char letter) {
        this.letter = letter;
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    @Override
    public TextLayer getLayer() {
        return layer;
    }

    @Override
    public Component get(int index) {
        logger.error("Operation get() cannot be applied to class 'Symbol'!");
        throw new UnsupportedOperationException("Cannot be applied to this class!");
    }

    @Override
    public void set(int index, Component component) {
        logger.error("Operation set() cannot be applied to class 'Symbol'!");
        throw new UnsupportedOperationException("Cannot be applied to this class!");
    }

    @Override
    public void add(Component component) {
        logger.error("Operation add() cannot be applied to class 'Symbol'!");
        throw new UnsupportedOperationException("Cannot be applied to this class!");
    }

    @Override
    public void remove(Component component) {
        logger.error("Operation remove() cannot be applied to class 'Symbol'!");
        throw new UnsupportedOperationException("Cannot be applied to this class!");
    }

    @Override
    public int size() {
        return 1;
    }

    @Override
    public int getLayersCount() {
        return 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Symbol symbol1 = (Symbol) o;

        return letter == symbol1.letter;
    }

    @Override
    public int hashCode() {
        return letter;
    }

    @Override
    public String toString() {
        return String.valueOf(letter);
    }
}
