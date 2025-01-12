package Amazon;

import java.util.*;

public class PhoneDirectory {
    static ArrayList<ArrayList<String>> displayContacts(int n, String contact[], String s) {
        Arrays.sort(contact);
        Trie trie = new Trie();
        for (String str : contact) {
            trie.insert(str);
        }
        ArrayList<ArrayList<String>> resultContacts = new ArrayList<>();
        StringBuilder prefixBuilder = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            prefixBuilder.append(s.charAt(i));
            String currentPrefix = prefixBuilder.toString();

            ArrayList<String> matchedContacts = new ArrayList<>();
            for (String con : contact) {
                if (con.startsWith(currentPrefix)) {
                    matchedContacts.add(con);
                } else if (con.compareTo(currentPrefix) > 0) {// Since contact is sorted, we can stop early if the
                                                              // current string no longer matches
                    break;
                }
            }

            if (matchedContacts.isEmpty()) {
                matchedContacts.add("0");
            }
            matchedContacts = new ArrayList<>(new LinkedHashSet<>(matchedContacts)); // Removing duplicates while
                                                                                     // maintaining orders

            resultContacts.add(matchedContacts);
        }

        return resultContacts;
    }
}
