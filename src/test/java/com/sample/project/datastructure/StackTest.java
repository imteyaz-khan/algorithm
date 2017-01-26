package com.sample.project.datastructure;

import org.junit.Test;

import java.util.EmptyStackException;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
/**
 * Created by imteyaz.khan on 21/01/17.
 */
public class StackTest {


    @Test
    public void testPush() {
        Stack<String> stack=new Stack<>();
        stack.push("test1");
        stack.push("test2");
        assertEquals("test2",stack.pop());
        stack.push("test3");
        assertEquals("test3",stack.pop());
    }

    @Test
    public void testPop() {
        Stack<String> stack=new Stack<>();
        stack.push("test1");
        stack.push("test2");
        assertEquals("test2", stack.pop());
    }

    @Test(expected = EmptyStackException.class)
    public void shouldRaisedException() {
        Stack<String> stack=new Stack<>();
        stack.pop();
    }

}
