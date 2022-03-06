package me.junjiehuang1020.homework.week.two;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisitCount {
    
    public List<String> subdomainVisits(String[] cpdomains) {
        
        Map<String, Integer> map = new HashMap<>();
        
        List<String> ans = new ArrayList<>();
        
        for (String cpdomain: cpdomains) {
            
            String[] repAndDomains = cpdomain.split(" ");
            
            Integer rep = Integer.valueOf(repAndDomains[0]);
            
            String[] domains = repAndDomains[1].split("\\.");
            
            String domain = "";
            
            for (int i = domains.length - 1; i >= 0; i--) {
                
                if (i == domains.length - 1) {
                    domain = domains[i].concat(domain);
                } else {
                    domain = domains[i].concat(".").concat(domain);
                }
                
                if (!map.containsKey(domain)) {
                    map.put(domain, rep);
                } else {
                    Integer count = map.get(domain);
                    map.put(domain, rep + count);
                }
                
            }
            
        }
        
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            ans.add(String.valueOf(entry.getValue()) + " " + entry.getKey());
        }
        
        return ans;
        
    }
}
