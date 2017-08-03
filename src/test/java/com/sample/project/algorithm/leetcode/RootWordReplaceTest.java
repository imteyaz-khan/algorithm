package com.sample.project.algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by imteyaz.khan on 03/08/17.
 */
public class RootWordReplaceTest {
    @Test
    public void testRootReoplacement() {
        List<String> words=new ArrayList<>();
        words.add("cat");
        words.add("bat");
        words.add("rat");

        RootWordReplace rootWordReplace=new RootWordReplace(words);
        Assert.assertEquals("the cat was rat by the bat", rootWordReplace.replaceByRootWord("the cattle was rattled by the battery"));
    }
}
