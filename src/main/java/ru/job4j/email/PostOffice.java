package ru.job4j.email;

import java.util.*;

public class PostOffice {
       public Map<User, Set<Email>> fusion(Map<User, Set<Email>> mapPrev) {
           Map<User, Set<Email>> mapNext = new LinkedHashMap<>();
           User key = mapPrev.keySet().iterator().next();
           mapNext.put(key, mapPrev.get(key));
           for (Map.Entry<User, Set<Email>> entry : mapPrev.entrySet()) {
              User  keyNext = entry.getKey();
               for (Map.Entry<User, Set<Email>> entry2: mapNext.entrySet()) {
                   Set<Email> emailSet = new HashSet<>();
                   emailSet.addAll(entry.getValue());
                   emailSet.addAll(entry2.getValue());
                   if (emailSet.size() != (entry.getValue().size() + entry2.getValue().size())) {
                       entry.setValue(emailSet);
                       keyNext = entry2.getKey();
                   } else if (mapNext.size() > 1) {
                       continue;
                   }
                  mapNext.put(keyNext, entry.getValue());
               }
           }
           return mapNext;
       }
}
