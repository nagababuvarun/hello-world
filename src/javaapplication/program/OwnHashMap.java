/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication.program;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nagendrababu.g
 */
public class OwnHashMap {

    int initialCapacity = 16;
    int capacity = initialCapacity;
    List<List<Entry<String, String>>> bucketArray = null;

    public OwnHashMap() {
        bucketArray = new ArrayList(initialCapacity);
    }

    public void add(String key, String value) {
        int bucketIndex = hashCode(key);
        List<Entry<String, String>> EntryList = bucketArray.get(bucketIndex);
        if (EntryList != null && !EntryList.isEmpty()) {
            for (Entry<String, String> entryObj : EntryList) {
                if (key.equals(entryObj.key)) {
                    entryObj.value = value;
                }
            }
        }else{
            List<Entry<String, String>> newEntryList  = new ArrayList();
            newEntryList.add(new Entry<String, String>(key,value));
            bucketArray.add(bucketIndex, newEntryList);
        }
        
    }
    public void remove(String key) {

    }
    public int size() {
        return bucketArray.size();
    }

    public boolean isEmpty() {
        return bucketArray.isEmpty();
    }
    
    public int hashCode(String key){
        return key.hashCode()%size();
    }
}


class Entry<K,V> {

    String key;
    String value;

    public Entry(String key, String value ){
        this.key = key;
        this.value = value;
    }
}
