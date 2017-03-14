package com.sample.project.algorithm.misc;

import com.sample.project.datastructure.Graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by imteyaz.khan on 13/03/17.
 */
public class Word2WordTransformer {

    private Map<String,Graph.Vertex> wordsNodeMap;

    public Word2WordTransformer() {
        wordsNodeMap=new HashMap<>();
    }
    //this method return if from source word to target word exists
    public boolean isPathExists(String source,String target) {

        return false;
    }

    public void buildDictionaryGraphAndPopulateReferenceMap(List<String> words) {
       words.forEach(word->addToGraph(word));
    }

    // adding this word to right place and making sure it is connected to all the nodes to whom diff of character
    //is one
    private void addToGraph(String word) {

    }


}
