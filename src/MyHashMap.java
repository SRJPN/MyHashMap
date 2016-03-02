public class MyHashMap<KEY, VALUE> {
    private final int capacity;
    private final KeyValuePair<KEY,VALUE>[] content;
    private int size;

    public MyHashMap(int capacity) {
        this.capacity = capacity;
        content = new KeyValuePair[capacity];
        this.size = 0;
    }

    public MyHashMap() {
        this(10);
    }

    public int getCapacity(){
        return capacity;
    }

    public int getSize(){
        return size;
    }

    public int add(KEY key, VALUE value){
        int hashIndex = generateHash(key);
        KeyValuePair<KEY,VALUE> pair = new KeyValuePair<>(key, value);
        this.content[hashIndex] = pair;
        this.size++;
        return hashIndex;
    }

    private int generateHash(Object item){
        String stringRep = item.toString();
        int hashIndex = addUpHash(stringRep);
        return hashIndex >= capacity ? generateHash(hashIndex) : hashIndex;
    }

    private int addUpHash(String stringRep){
        int sumUp = 0;
        for (int i = 0; i < stringRep.length() ; i++) {
            sumUp += Integer.bitCount(stringRep.codePointAt(i));
        }
        return sumUp;
    }

    public VALUE getElementOf(KEY key) {
        int hashIndex = generateHash(key);
        if (content[hashIndex] == null)
            return null;
        return content[hashIndex].getKey() == key ? content[hashIndex].getValue() : null;
    }

    public void remove(KEY key){
        int hashIndex = generateHash(key);
        content[hashIndex] = null;
    }
}
