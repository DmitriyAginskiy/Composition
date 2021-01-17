package by.aginskiy.text.parser;

import by.aginskiy.text.composite.Component;
import by.aginskiy.text.composite.Separator;
import by.aginskiy.text.composite.TextComposite;
import by.aginskiy.text.composite.TextLayer;

public class TextParser extends AbstractParser {

    private final String PARAGRAPH_REGEX = "\\n(\\t|(\\s){4,})";

    @Override
    public Component parse(String message) {
        Component textComposite = new TextComposite(TextLayer.TEXT, Separator.PARAGRAPH);
        String[] paragraphs = message.split(PARAGRAPH_REGEX);
        for(int i = 0; i < paragraphs.length; i++) {
            Component paragraphComposite = this.getNextHandler().parse(paragraphs[i]);
            textComposite.add(paragraphComposite);
        }
        return textComposite;
    }
}
