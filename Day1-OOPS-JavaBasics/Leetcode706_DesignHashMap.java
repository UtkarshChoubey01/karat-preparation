//Design a HashMap without using any built-in hash table libraries.
//
//Implement the MyHashMap class:
//
//MyHashMap() initializes the object with an empty map.
//void put(int key, int value) inserts a (key, value) pair into the HashMap. If the key already exists in the map, update the corresponding value.
//int get(int key) returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
//void remove(key) removes the key and its corresponding value if the map contains the mapping for the key.
// 
//
//Example 1:
//
//Input
//["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
//[[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
//Output
//[null, null, null, 1, -1, null, 1, null, -1]


class MyHashMap {

    public MyHashMap(){
        buckets = new Node[bucketSize];
    }
    
    private static class Node{
            int key;
            int value;
            Node next;

            Node(int key,int value){
                this.key=key;
                this.value = value;
            }
    }
    

    private final int bucketSize=1000;
    private Node [] buckets;

    
     public int hash(int key){
        return key%bucketSize;
    }

    public void put(int key, int value) {
        int idx=hash(key);

        if(buckets[idx]==null){
            buckets[idx]= new Node(key,value);
            return;
        }

        Node curr=buckets[idx];
        while(true){
            if(curr.key==key){
                curr.value=value;
                return;
            }

            if(curr.next==null){
                break;
            }
            curr=curr.next;
        }
        curr.next= new Node(key,value);
    }
    
    public int get(int key) {
         int idx=hash(key);

         Node curr=buckets[idx];
         while(curr!=null){
            if(curr.key==key){
            return curr.value;
         }
         curr=curr.next;
         }
         
         return -1;
    }
    
    public void remove(int key) {
        int idx=hash(key);

         Node curr=buckets[idx];
         Node prev=null;

         while(curr!=null){
            if(curr.key==key){
               if(prev==null){
                buckets[idx]=curr.next;
               }
               else prev.next=curr.next;
               return;
            }
            prev=curr;
         curr=curr.next;
         }        
    }
}

