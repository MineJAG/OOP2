package Dialogue;

import java.io.File;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.*;
/**
 *
 * @author ajone
 */
public class DialogueLoader {

    public void loadText(String fileName) throws IOException {
        FileReader fR = new FileReader(fileName);
        BufferedReader bR = new BufferedReader(fR);
        String line;
        while ((line = bR.readLine()) != null) {
            if(line.charAt(0) == '#'){
                continue;
            }
            System.out.println(line);
        }
    }
}