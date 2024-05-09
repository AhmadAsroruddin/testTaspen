package com.ari;

import javax.security.auth.login.CredentialNotFoundException;
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

        //PENGELOMPOKAN
        for(Map.Entry<Character, Integer> entry : splittingResult.entrySet()){
            Character key = entry.getKey();
            int value = entry.getValue();
            if(!groupedMap.containsKey(value)){
                groupedMap.put(value, new ArrayList<>());
            }
            groupedMap.get(value).add(key);
        }
        //PENGURUTAN HURUF
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


        List<Map.Entry<Integer, List<Character>>> list = new ArrayList<>(groupedMap.entrySet());
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j).getKey() < list.get(j + 1).getKey()) {
                    Map.Entry<Integer, List<Character>> temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
        for (Map.Entry<Integer, List<Character>> entry : list) {
            for(int x = 0; x < entry.getValue().size(); x++){
                result += entry.getValue().get(x);
            }
        }

        System.out.println(result);
    }
}
