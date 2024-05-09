package com.ari;

import java.util.*;

import static java.util.Collections.replaceAll;

public class SortingChar {
    public Map<Character, Integer> splitting(String[] words) {
        Map<Character, Integer> perChar = new HashMap<>();

        String change = Arrays.toString(words).replaceAll("[\\[\\],\\s]", "");
        ;

        for (Character x : change.toCharArray()) {
            if (perChar.containsKey(x)) {
                perChar.put(x, perChar.get(x) + 1);
            } else {
                perChar.put(x, 1);
            }
        }
        return perChar;
    }

    public void sortingCharacter(String[] words) {
        String result = "";
        Map<Character, Integer> splittingResult = new HashMap<>(splitting(words));

        Map<Integer, List<Character>> groupedMap = new HashMap<>();

        for(Map.Entry<Character, Integer> entry : splittingResult.entrySet()){
            Character key = entry.getKey();
            int value = entry.getValue();
            if(!groupedMap.containsKey(value)){
                groupedMap.put(value, new ArrayList<>());
            }
            groupedMap.get(value).add(key);
        }

        for (Map.Entry<Integer, List<Character>> entryValue : groupedMap.entrySet()) {
            for (int i = 0; i < entryValue.getValue().size(); i++) {
                for (int j = 0; j < entryValue.getValue().size() - i - 1; j++) {
                    if (entryValue.getValue().get(j) > entryValue.getValue().get(j + 1)) {
                        char temp = entryValue.getValue().get(j);
                        entryValue.getValue().set(j, entryValue.getValue().get(j + 1));
                        entryValue.getValue().set(j + 1, temp);
                    }
                }
            }

        }

        for(int x = groupedMap.size()+1; x >= 0; x--){
            if(groupedMap.containsKey(x)){
                List<Character> listChar = groupedMap.get(x);
                for(Character c : listChar){
                    result += c;
                }
            }
        }

        System.out.println(result);
    }
}
