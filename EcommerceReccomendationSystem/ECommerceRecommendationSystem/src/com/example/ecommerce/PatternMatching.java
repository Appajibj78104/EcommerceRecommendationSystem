package com.example.ecommerce;

public class PatternMatching {
    public int[] computeKMPTable(String pattern) {
        int[] table = new int[pattern.length()];
        int j = 0;

        for (int i = 1; i < pattern.length(); i++) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                j++;
                table[i] = j;
            } else {
                if (j != 0) {
                    j = table[j - 1];
                    i--;
                } else {
                    table[i] = 0;
                }
            }
        }
        return table;
    }

    public boolean KMPSearch(String text, String pattern) {
        int[] table = computeKMPTable(pattern);
        int i = 0, j = 0;

        while (i < text.length()) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }

            if (j == pattern.length()) {
                return true;
            } else if (i < text.length() && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = table[j - 1];
                } else {
                    i++;
                }
            }
        }
        return false;
    }
}
