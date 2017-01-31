package com.sample.project.datastructure;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
/**
 * Created by imteyaz.khan on 29/01/17.
 */
public class TrieTest {


    @Test
    public void shouldLoadAllWordsAndGetByPrefix() {
        List<String> words=new ArrayList<>();
        words.add("abcd");
        words.add("abefgh");
        words.add("abcemnop");
        words.add("apexyz");
        Trie trie=new Trie(words);
        assertTrue(trie.isPrefix("abce"));
        assertTrue(trie.contains("abefgh"));
        trie.addToDictionary("axmnop");
        trie.addToDictionary("xyz");
        assertTrue(trie.isPrefix("xy"));
        assertTrue(trie.isPrefix("axmnop"));
    }

    @Test
    public void shouldGetByPrefix() {
        Trie trie=new Trie();
        trie.addToDictionary("test");
        assertTrue(trie.isPrefix("test"));
    }

    @Test
    public void shouldNotGetByPrefix() {
        Trie trie=new Trie();
        trie.addToDictionary("test");
        assertFalse(trie.isPrefix("test1"));
    }

    @Test
    public void shouldGetByWord() {
        Trie trie=new Trie();
        trie.addToDictionary("test");
        assertTrue(trie.contains("test"));
    }

    @Test
    public void shouldNotGetByWord() {
        Trie trie=new Trie();
        trie.addToDictionary("test");
        assertFalse(trie.contains("test1"));
    }

}
