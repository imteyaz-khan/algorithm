package com.sample.project.datastructure;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by imteyaz.khan on 29/01/17.
 */
public class Trie {

    private TrieNode root;

    public Trie() {
        root=new TrieNode(' ');
    }

    public Trie(Collection<String> words) {
        root=new TrieNode(' ');
        for(String word:words) {
            addToDictionary(word);
        }
    }

    public void addToDictionary(String word) {
        int length=word.length();
        TrieNode travellerNode=root;
        for(int index=0;index<length-1;index++) {
            travellerNode=addTrieNode(new TrieNode(word.charAt(index)),false,travellerNode);
        }
        addTrieNode(new TrieNode(word.charAt(length - 1)), true, travellerNode);
    }

    public boolean isPrefix(String prefix) {
        TrieNode travellerNode=root;
        int length=prefix.length();
        for(int index=0;index<length;index++) {
            travellerNode=getTrieNodeInSequence(new TrieNode(prefix.charAt(index)),travellerNode);
            if(travellerNode==null) {
                return false;
            }
        }
        return true;
    }

    public boolean contains(String word) {
        TrieNode travellerNode=root;
        int length=word.length();
        for(int index=0;index<length;index++) {
            travellerNode=getTrieNodeInSequence(new TrieNode(word.charAt(index)),travellerNode);
            if(travellerNode==null) {
                return false;
            }
        }
        return travellerNode.isWrod;
    }

    private TrieNode addTrieNode(TrieNode target,boolean isWord,TrieNode travellerNode) {
        int indexOf=travellerNode.childNodes.indexOf(target);
        if(indexOf>=0) {
            return travellerNode.childNodes.get(indexOf);
        } else {
            TrieNode newNode=new TrieNode(target.element);
            newNode.isWrod=isWord;
            travellerNode.childNodes.add(newNode);
            return newNode;
        }
    }

    private TrieNode getTrieNodeInSequence(TrieNode target,TrieNode travellerNode) {
        if(travellerNode==null) {
            return null;
        }
        int indexOf=travellerNode.childNodes.indexOf(target);
        if(indexOf>=0) {
            return travellerNode.childNodes.get(indexOf);
        }
        return null;
    }

    private class TrieNode {
        private List<TrieNode> childNodes;
        private boolean isWrod;
        private char element;

        private TrieNode(char t) {
            this.element=t;
            this.childNodes=new ArrayList<>(26);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            TrieNode trieNode = (TrieNode) o;

            return element == trieNode.element;

        }

        @Override
        public int hashCode() {
            return (int) element;
        }
    }
}
