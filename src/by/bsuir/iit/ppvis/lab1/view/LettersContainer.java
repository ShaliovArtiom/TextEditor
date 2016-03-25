package by.bsuir.iit.ppvis.lab1.view;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TyZiK on 25.03.2016.
 */
class LetterContainer {

    public static class LettersContainer {
        public List<Glyph> list = new ArrayList<>();

        public void addLetter(Glyph glyph) {
            list.add(glyph);
        }
    }
}
