package com.sda.spring.core.editor;

public class DemoEditor {
    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();

        textEditor.convert();
        textEditor.format();
        textEditor.spellCheck();
    }
}
