/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dialogue;


/**
 *
 * @author ajone
 */
public class DialogueOption {
    private String option;
    private String nextLineId;

    public DialogueOption(String option, String nextLineId) {
        this.option = option;
        this.nextLineId = nextLineId;
    }
    public String getOption() {
        return option;
    }
    public void setOption(String option) {
        this.option = option;
    }
    public String getNextLineId() {
        return nextLineId;
    }
    public void setNextLineId(String nextLineId) {
        this.nextLineId = nextLineId;
    }

    
    }