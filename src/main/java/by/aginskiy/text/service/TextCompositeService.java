package by.aginskiy.text.service;

import by.aginskiy.text.composite.Component;
import by.aginskiy.text.composite.TextLayer;

import java.util.ArrayList;
import java.util.List;


public class TextCompositeService {

    public boolean sortBySentenceNumber(Component composite) {
        if(composite.getLayer() != TextLayer.TEXT) {
            return false;
        }
        for(int i = 0; i < composite.size(); i++) {
            for(int j = 0; j < composite.size() - i - 1; j++) {
                if(composite.get(j).size() < composite.get(j + 1).size()) {
                    Component buffer = composite.get(j);
                    composite.set(j, composite.get(j + 1));
                    composite.set(j + 1, buffer);
                }
            }
        }
        return true;
    }

    public List<Component> searchSentencesLongestLexeme(Component composite) {
        if(composite.getLayer() != TextLayer.TEXT) {
            return new ArrayList<>();
        }
        List<Component> sentences = new ArrayList<>();
        int maxWordLength = 0;
        int currentWordLength = 0;
        for(int i = 0; i < composite.size(); i++) {
            Component paragraph = composite.get(i);
            for(int j = 0; j < paragraph.size(); j++) {
                Component sentence = paragraph.get(j);
                maxWordLength = 0;
                for(int k = 0; k < sentence.size(); k++) {
                    if(maxWordLength < sentence.get(k).size()) {
                        maxWordLength = sentence.get(k).size();
                    }
                }
                if(currentWordLength < maxWordLength) {
                    currentWordLength = maxWordLength;
                    sentences.clear();
                    sentences.add(sentence);
                } else if(currentWordLength == maxWordLength) {
                    sentences.add(sentence);
                }
            }
        }
        return sentences;
    }

    public void removeSentencesLessWordNumber(Component composite, int wordNumber) {
        for(int i = 0; i < composite.size(); i++) {
            Component paragraph = composite.get(i);
            for(int j = 0; j < paragraph.size(); j++) {
                if(paragraph.get(j).size() < wordNumber) {
                    paragraph.remove(paragraph.get(j));
                }
            }
        }
    }
}
