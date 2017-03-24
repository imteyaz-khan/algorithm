package com.sample.project.algorithm.misc;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by imteyaz.khan on 24/03/17.
 */
public class Word2WordTransformerTest {
    @Test
    public void sourceToTargetWordPathExists() {
        List words=new ArrayList<>();
        words.add("TOON");
        words.add("POON");
        words.add("PLEE");
        words.add("SAME");
        words.add("POIE");
        words.add("PLIE");
        words.add("PLEA");
        words.add("POIN");
        words.add("ABCD");
        words.add("MBCD");
        words.add("MBXD");
        words.add("MYXD");
        Word2WordTransformer word2WordTransformer=new Word2WordTransformer(words);
        assertTrue(word2WordTransformer.hasPath("MYXD","ABCD"));
    }

    @Test
    public void sourceToTargetWordPathDoesNotExists() {
        List words=new ArrayList<>();
        words.add("ABCD");
        words.add("MBCD");
        words.add("MBXD");
        words.add("MYXD");
        Word2WordTransformer word2WordTransformer=new Word2WordTransformer(words);
        assertFalse(word2WordTransformer.hasPath("MZXD", "ABCD"));
    }
}
