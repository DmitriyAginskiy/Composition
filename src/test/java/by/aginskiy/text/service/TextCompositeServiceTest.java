package by.aginskiy.text.service;

import by.aginskiy.text.composite.Component;
import by.aginskiy.text.exception.FileReadingException;
import by.aginskiy.text.parser.*;
import by.aginskiy.text.reader.TextReader;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class TextCompositeServiceTest {

    private Component textComposite;
    private TextCompositeService service = new TextCompositeService();

    @BeforeClass
    public void setUp() {
        AbstractParser parser = new TextParser();
        parser.setNextHandler(new ParagraphParser());
        parser.getNextHandler().setNextHandler(new SentenceParser());
        parser.getNextHandler().getNextHandler().setNextHandler(new LexemeParser());
        String text = "";
        try {
            text = TextReader.readFromFile("src\\main\\resources\\data.txt");
        } catch (FileReadingException e) {
            e.printStackTrace();
        }
        textComposite = parser.parse(text);
    }

    @Test
    public void testSortBySentenceNumber() {
        boolean isSorted = service.sortBySentenceNumber(textComposite);
        Assert.assertTrue(isSorted);
    }

    @Test
    public void testSearchSentencesLongestLexeme() {
        List<Component> longestLexemes = service.searchSentencesLongestLexeme(textComposite);
        boolean isSearched = !longestLexemes.isEmpty();
        Assert.assertTrue(isSearched);
    }
}