package Dialogue;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.*;
import java.util.Map;
import java.util.HashMap;
/**
 *
 * @author ajone
 */
public class DialogueLoader {
    private Map<String, Map<String, DialogueLine>> storedDialogue;

    public Map<String, Map<String, DialogueLine>> getDialogue() {
        return storedDialogue;
    }

    public void setDialogue(Map<String, Map<String, DialogueLine>> dialogue) {
        this.storedDialogue = dialogue;
    }

    public void loadText(String fileName) throws IOException {
        Map<String, Map<String, DialogueLine>> dialogue = new HashMap<>();
        String currentNpc = null;

        try (BufferedReader bR = new BufferedReader(new FileReader(fileName))) {
            String rawLine;

            while ((rawLine = bR.readLine()) != null) {
                String line = rawLine.trim();

                if (line.isEmpty()) {
                    continue;
                }

                if (line.charAt(0) == '#') {
                    continue;
                }

                if (!line.contains("-")) {
                    throw new IllegalArgumentException("Invalid line (missing '-'): " + rawLine);
                }

                String[] part = splitLine(line, '-');
                String header = part[0].trim();
                String body   = part[1].trim();

                if (header.equalsIgnoreCase("c")) {
                    currentNpc = body;
                    dialogue.putIfAbsent(currentNpc, new HashMap<>());
                    continue;
                }

                if (currentNpc == null) {
                    throw new IllegalStateException(
                        "Dialogue/option found before character definition. Line: " + rawLine
                    );
                }

                if (hasChar(header.toLowerCase(), '$')) {
                    int oIndex = header.indexOf('$');
                    if (oIndex <= 0 || oIndex == header.length() - 1) {
                        throw new IllegalArgumentException("Invalid option header: \"" + header + "\" in line: " + rawLine);
                    }

                    String dialogueId = header.substring(0, oIndex);
                    String optionId   = header.substring(oIndex + 1);

                    Map<String, DialogueLine> npcDialogue = dialogue.get(currentNpc);
                    DialogueLine dl = npcDialogue.get(dialogueId);

                    if (dl == null) {
                        throw new IllegalStateException(
                            "Option references non-existent dialogue ID: " + dialogueId +
                            " in line: " + rawLine
                        );
                    }
                    String optionText = body;
                    dl.addOption(new DialogueOption(optionText, optionId));
                }
                else {
                    String dialogueId   = header;
                    String dialogueText = body;

                    dialogue.get(currentNpc)
                            .put(dialogueId, new DialogueLine(dialogueText));
                }
            }
        }
        setDialogue(dialogue);
    }

    private String[] splitLine(String line, char r) {
        int i = line.indexOf(r);
        if (i < 0) {
            throw new IllegalArgumentException("Expected '" + r + "' in line: " + line);
        }
        String[] parts = new String[2];
        parts[0] = line.substring(0, i);
        parts[1] = line.substring(i + 1);
        return parts;
    }

    private boolean hasChar(String line, char r) {
        return line.indexOf(r) != -1;
    }
}