package by.aginskiy.text.parser;

import by.aginskiy.text.composite.Component;
import by.aginskiy.text.composite.Separator;
import by.aginskiy.text.composite.TextComposite;
import by.aginskiy.text.composite.TextLayer;

public class ParagraphParser extends AbstractParser {

    private final String SENTENCE_REGEX = "(?<=[.!?])\\s";

    @Override
    public Component parse(String message) {
        Component paragraphComposite = new TextComposite(TextLayer.PARAGRAPH, Separator.SENTENCE);
        String[] sentences = message.split(SENTENCE_REGEX);
        for(int i = 0; i < sentences.length; i++) {
            Component sentenceComposite = this.getNextHandler().parse(sentences[i]);
            paragraphComposite.add(sentenceComposite);
        }
        return paragraphComposite;
    }
}
