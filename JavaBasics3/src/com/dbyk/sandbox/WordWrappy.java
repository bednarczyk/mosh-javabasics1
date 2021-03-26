package com.dbyk.sandbox;

public class WordWrappy {

    public static String wrap(String s, int width) {
        int counter = 0;
        StringBuilder sbWord = new StringBuilder();
        StringBuilder sbSentence = new StringBuilder();
        s = s.trim();

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            counter++;

            //this is a complete hack and i should go to hell for it
            if(c == '\r'){
                if ((i + 1) < s.length()) {
                    if(s.charAt(i +1) == '\n'){
                        c = '\n';
                        i++;
                    }
                }
            }

            if (counter == width) {
                // Check to see if the next char is a space
                // If it is, we need to append this word to the line before making a newline
                // But make sure we're not looking outside the index of the string!
                if ((i + 1) < s.length()) {
                    if (s.charAt(i + 1) == ' ') {
                        sbWord.append(c);
                        sbSentence.append(sbWord);
                        sbWord.setLength(0);
                        counter = 0;
                    } else {
                        // If our last character is not a space, it needs to be added to the current word
                        if (c != ' ')
                            sbWord.append(c);

                        // If our last character is a space, the word needs to be appended to the sentence
                        if (c == ' ') {
                            sbSentence.append(sbWord);
                            sbWord.setLength(0);
                        }
                    }
                    sbSentence.append("\n");
                    counter = sbWord.length();
                }
            }

            // there's a special case where counter is at 1 and current char is ' '
            // in this case, we've just printed the last word and sbWord is currently empty
            // we don't want to print sb and a space because this is the beginning of a line
            else if (c == ' ') {
                sbSentence.append(sbWord);
                sbWord.setLength(0);
                // If our line starts with a space we want to remove the space and set the counter back
                if (counter == 1) {
                    counter = 0;
                }
                if (counter > 1) {
                    sbSentence.append(c);
                }
            } else if (c == '\n') {
                sbSentence.append(sbWord);
                sbWord.setLength(0);
                sbSentence.append('\n');
                counter = 0;

                // accommodating leading spaces for the beginning of a paragraph/line
                int j = i;
                while((j + 1) < s.length()){

                }
            } else {
                sbWord.append(c);
            }
        }
        // flush anything remaining in the wordbuilder
        sbSentence.append(sbWord);
        return sbSentence.toString();
    }

}
