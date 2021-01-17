package by.aginskiy.text.parser;

import by.aginskiy.text.composite.Component;
import by.aginskiy.text.composite.Separator;
import by.aginskiy.text.composite.TextComposite;
import by.aginskiy.text.composite.TextLayer;

public class SentenceParser extends AbstractParser {

    private final String LEXEME_REGEX = "(?=(\\n))|\\s";

    @Override
    public Component parse(String message) {
        Component sentenceComposite = new TextComposite(TextLayer.SENTENCE, Separator.LEXEME);
        String[] lexemes = message.split(LEXEME_REGEX);
        for(int i = 0; i < lexemes.length; i++) {
            Component lexemeComposite = this.getNextHandler().parse(lexemes[i]);
            sentenceComposite.add(lexemeComposite);
        }
        return sentenceComposite;
    }
}
