package by.aginskiy.text.parser;

import by.aginskiy.text.composite.Component;

public abstract class AbstractParser {

    private AbstractParser nextHandler;

    public AbstractParser getNextHandler() {
        return nextHandler;
    }

    public void setNextHandler(AbstractParser nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract Component parse(String message);
}
