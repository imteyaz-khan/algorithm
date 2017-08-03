package com.sample.project.algorithm.leetcode;

import javax.swing.tree.TreeNode;
import java.util.*;

/**
 * Created by imteyaz.khan on 03/08/17.
 */
public class RootWordReplace {
    Dictionary dictionary;
    public  RootWordReplace(List<String> words) {
        dictionary=new Dictionary(words);
    }
    public String replaceByRootWord(String sentence) {
        String sentenceWords[]=sentence.split(" ");
        StringBuilder stringBuilder=new StringBuilder();
        for(String word:sentenceWords) {
            stringBuilder.append(dictionary.getRootDictionaryWord(word));
            stringBuilder.append(" ");
        }
        return stringBuilder.toString().trim();
    }
    class TrieNode {
        Character character;
        Map<Character,TrieNode> nodes;
        boolean word=false;

        public TrieNode(char character) {
            this.character=character;
            nodes=new HashMap<>(26);
        }

        TrieNode get(Character character) {
            return nodes.get(character);
        }

        void markWord() {
            this.word=true;
        }

        boolean isWord() {
            return this.word;
        }
    }

    class Dictionary {
        TrieNode root;
        public Dictionary(List<String> words) {
            root=new TrieNode('#');
            buildDictionary(words);
        }

        private void buildDictionary(List<String> words) {
            for(String word:words) {
                TrieNode current=root;
                for(Character character:word.toCharArray()) {
                    TrieNode node=current.get(character);
                    if(isNull(node)) {
                        node=new TrieNode(character);
                        current.nodes.put(character,node);
                    }
                    current=node;
                }
                current.markWord();
            }
        }

        public String getRootDictionaryWord(String word) {
            StringBuilder stringBuilder=new StringBuilder();
            TrieNode currentNode=root;
            for(Character character:word.toCharArray()) {
                TrieNode node=currentNode.get(character);
                stringBuilder.append(character);
                if(node!=null && node.isWord()) {
                    return stringBuilder.toString();
                } else if(node==null) {
                    break;
                }
                currentNode=node;
            }
            return word;
        }
    }

    public static boolean isNull(Object object) {
        return object==null;
    }


    public static void main(String args[]) {
        List<String> words=new ArrayList<>();
        words.add("cat");
        words.add("bat");
        words.add("rat");

        RootWordReplace rootWordReplace=new RootWordReplace(words);
        System.out.println(rootWordReplace.replaceByRootWord("the cattle was rattled by the battery"));
    }
}
