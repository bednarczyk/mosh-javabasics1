package com.mosh;

public class Textbox  extends UIControl {
    private String text = "";

    public Textbox(String text){
        super(true);
        this.text = text;
    }

    public Textbox() {
        super(true);
    }

    @Override
    public void render() {
        System.out.println("Render Textbox");
    }

    @Override
    public String toString(){
        return text;
    }

    public void setText(String text){
        this.text = text;
    }

    public String getText(){
        return text;
    }

    public void clear(){
        text = "";
    }
}
