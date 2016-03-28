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

        public void deleteLastElement() {
            if (!list.isEmpty()) {
                list.remove(list.size() - 1);
            }

        }
    }
}
