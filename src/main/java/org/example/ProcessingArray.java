package org.example;

import java.util.*;

public class ProcessingArray {
    public static void processingArray(String[] inputAr) {
        List<String> copyInput = Arrays.asList(inputAr);

        Map<String,ArrayList<Integer>> data = new HashMap<>();

        for (int i = 0; i < copyInput.size(); i++) {
            for (int j = i + 1; j < inputAr.length; j++) {
                if(copyInput.size() == inputAr.length) {
//                    System.out.println("Длины совпадают у слов с индексами:");
//                    System.out.println("(индекс по листу) i - " + i);
//                    System.out.println("(индекс по массиву) j - " + j);

                    //проходимся по слову
                    String wordFromList = copyInput.get(i); //будем удалять буквы из этого слова
                    String wordFromArray = inputAr[j]; //будем сравнивать в этом слове буквы из wordFromList
                    boolean matchingSymbol = false;
                    //проходимся по символам из слова из List
                    for (int k = 0; k < wordFromArray.length(); k++) {
                        char symbol = wordFromArray.charAt(k);
                        if (wordFromList.contains(String.valueOf(symbol))) {
                            //удаляем символ
                            matchingSymbol = true;
                            int index = wordFromList.indexOf(symbol);
                            wordFromList = wordFromList.substring(0, index) +
                                    wordFromList.substring(index + 1, wordFromList.length());
                        }
                        else {
                            matchingSymbol = false;
                            break;
                        }
                    }

                    if (matchingSymbol == true) {
                        if (!data.containsKey(wordFromArray)) {
                            //добавляем новове слово с индексами
                            data.put(wordFromArray, new ArrayList<>(Arrays.asList(i, j)));
                        }
                        else {
                            //добавляем индекс к существующему слову
                            for (Map.Entry<String, ArrayList<Integer>> words: data.entrySet()) {
                                if (words.getKey().equals(wordFromArray)) {
                                    words.getValue().add(j);
                                }
                            }
                        }
                    }
                }
            }
        }

        for (Map.Entry<String, ArrayList<Integer>> words: data.entrySet()) {
            StringBuilder indexes = new StringBuilder();
            for (int i = 0; i < words.getValue().size(); i++) {
                if (i != words.getValue().size()) {
                    indexes.append(i);
                    indexes.append(", ");
                }
                else {
                    indexes.append(i);
                }
            }
            System.out.print(words.getKey() + " " + indexes);
        }
    }
}
