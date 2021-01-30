package com.company;


import java.util.*;

public class Main {

    public static void main(String[] args) {
        HashMap<String, String[]> dictionary = new HashMap<>();

        dictionary.put("прекрасный", new String[]{"красивый", "восхитительный",
                "умопормрачительный", "замечатьный"});
        dictionary.put("человек", new String[]{"существо", "сапианс", "личность"});
        dictionary.put("дом", new String[]{"логово", "жилье", "квартира",
                "убежище", "хата"});

        HashMap<String, String[]> bigDictionary = new HashMap<>(dictionary);
        Set<String> keys = dictionary.keySet();
        Iterator<String> iterator = keys.iterator();
        while(iterator.hasNext()) {
            String oldKey = iterator.next();
            String[] oldValues = bigDictionary.get(oldKey);
            for (int i = 0; i < oldValues.length; i++) {
                String newKey = oldValues[i];
                ArrayList<String> listOfValues = new ArrayList<>();
                Collections.addAll(listOfValues, oldValues);
                listOfValues.remove(newKey);
                listOfValues.add(oldKey);
                String[] newValues = new String[listOfValues.size()];
                listOfValues.toArray(newValues);
                bigDictionary.put(newKey, newValues);
            }
        }

        for (Map.Entry<String, String[]> item : bigDictionary.entrySet()) {
            System.out.println(item.getKey() + " - " + Arrays.toString(item.getValue()));
        }

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите слово:");
            String sentence = scanner.nextLine();
            String[] words = sentence.split(" ");
            for (String word : words) {
                if (bigDictionary.get(word) != null) {
                    String[] synonyms = bigDictionary.get(word);
                    Random random = new Random();
                    int index = random.nextInt(synonyms.length);
                    System.out.print(synonyms[index] + " ");
                } else {
                    System.out.println("Такого слова нет");
                }
            }
            System.out.println();
        }

    }
}
