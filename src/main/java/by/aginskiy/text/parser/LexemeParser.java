package by.aginskiy.text.parser;

import by.aginskiy.text.composite.Component;
import by.aginskiy.text.composite.Separator;
import by.aginskiy.text.composite.TextComposite;
import by.aginskiy.text.composite.TextLayer;
import by.aginskiy.text.composite.Symbol;

public class LexemeParser extends AbstractParser {

    @Override
    public Component parse(String message) {
        Component lexemeComposite = new TextComposite(TextLayer.LEXEME, Separator.SYMBOL);
        char[] symbols = message.toCharArray();
        for(int i = 0; i < symbols.length; i++) {
            lexemeComposite.add(new Symbol(symbols[i]));
        }
        return lexemeComposite;
    }
}
