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

                // skip empty lines
                if (line.isEmpty()) {
                    continue;
                }

                // skip comments
                if (line.charAt(0) == '#') {
                    continue;
                }

                // every non-comment, non-empty line must have '-'
                if (!line.contains("-")) {
                    throw new IllegalArgumentException(
                        "Invalid line (missing '-'): \"" + rawLine + "\""
                    );
                }

                String[] part = splitLine(line, '-');
                String header = part[0].trim();
                String body   = part[1].trim();

                // character line: c-Old Man
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

                // option line: 1o2-option2, 1o!1-GiveItem1, etc
                if (hasChar(header.toLowerCase(), 'o')) {
                    int oIndex = header.indexOf('o');
                    if (oIndex <= 0 || oIndex == header.length() - 1) {
                        throw new IllegalArgumentException(
                            "Invalid option header: \"" + header + "\" in line: " + rawLine
                        );
                    }

                    String dialogueId = header.substring(0, oIndex);     // e.g. "1"
                    String optionId   = header.substring(oIndex + 1);    // e.g. "2" or "!1"

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
                // normal dialogue (includes things like "!1-Item1" or "?-GiveItem")
                else {
                    String dialogueId   = header;   // "1", "2", "!1", "?", ...
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
            throw new IllegalArgumentException(
                "Expected '" + r + "' in line: \"" + line + "\""
            );
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