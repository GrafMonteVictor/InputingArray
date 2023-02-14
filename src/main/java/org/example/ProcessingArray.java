package org.example;

import java.util.*;

public class ProcessingArray {
    public static String processingArray(String[] inputAr) {
        List<String> copyInput = new ArrayList<>(Arrays.asList(inputAr));

        Map<String,ArrayList<Integer>> data = new HashMap<>();

        for (int i = 0; i < copyInput.size() - 1; i++) {
            if (copyInput.get(i) == null) {
                continue;
            }
            String currentWord = copyInput.get(i); //будем сравнивать в этом слове буквы из wordFromList
            for (int j = i + 1; j < inputAr.length; j++) {
                String comparingWord = inputAr[j]; //будем удалять буквы из этого слова
                if(currentWord.length() == comparingWord.length()) {

                    //проходимся по слову
                    boolean isMatch = false;
                    //проходимся по символам из слова из List
                    for (int k = 0; k < currentWord.length(); k++) {
                        char symbol = currentWord.charAt(k);
                        if (comparingWord.contains(String.valueOf(symbol))) {
                            //удаляем символ
                            isMatch = true;
                            int index = comparingWord.indexOf(symbol);
                            comparingWord = comparingWord.substring(0, index) +
                                    comparingWord.substring(index + 1, comparingWord.length());
                        }
                        else {
                            isMatch = false;
                            break;
                        }
                    }

                    if (isMatch == true) {

                        if (!data.containsKey(currentWord)) {
                            //добавляем новове слово с индексами
                            data.put(currentWord, new ArrayList<>(Arrays.asList(i, j)));
                        }
                        else {
                            //добавляем индекс к существующему слову
                            data.get(currentWord).add(j);
                        }
                        copyInput.set(j, null);
                    }
                }

            }
        }

        StringBuilder indexes = new StringBuilder();
        for (Map.Entry<String, ArrayList<Integer>> words: data.entrySet()) {
            indexes.append(" ");
            indexes.append(words.getKey());
            indexes.append(" =");
            for (int i = 0; i < words.getValue().size(); i++) {
                if (i != words.getValue().size() - 1) {
                    indexes.append(" ");
                    indexes.append(words.getValue().get(i));
                    indexes.append(",");
                }
                else {
                    indexes.append(" ");
                    indexes.append(words.getValue().get(i));
                }
            }
        }
        String output = indexes.toString();
        if(output == null || output.equals("")) {
            return "";
        }
        output = output.substring(1, output.length());
        return output;
    }
}
