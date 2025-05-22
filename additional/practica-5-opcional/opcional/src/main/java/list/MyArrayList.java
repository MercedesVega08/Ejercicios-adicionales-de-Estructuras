package list;

/**
 * Write a description of class MyArrayList here.
 * 
 */
public class MyArrayList<T> implements List<T> 
{
    private T[] items;
    private static final int MAX_LIST = 100;
    private int numItems;

    /**
     * Constructor for objects of class MyArrayList with specific size.
     */
    public MyArrayList(int size)
    {
        if(size <= 0) {
            throw new IllegalArgumentException("colection size mast be positive");
        }
        items = (T[]) new Object[size];
        numItems = 0;
    }
    
    /**
     * Constructor for objects of class MyArrayList
     */
    public MyArrayList( )
    {
        items = (T[]) new Object[MAX_LIST];
        numItems = 0;
    }

     /**
     * @post Returns the number of elements in the list.
     *   More formally, it satisfies: result = #this.
     */
    public int size() {
        return numItems;
    }

    /**
     * @post Returns true iff the list contains no elements.
     *   More formally, it satisfies: result = #this = 0.
     */
    public boolean isEmpty() {
        return (numItems == 0);
    }

    public int getNumItems(){
        return numItems;
    }
    
    /**
     * @post Returns true iff the list contains element e.
     *   More formally, it satisfies: 
     *   result = exists o | o in this && e.equals(o).
     */
    public boolean contains(T e) {
        int i = 0;
        boolean found = false;
        while(i < numItems && !found) {
            found = e.equals(items[i]);
            i++;
        }    
        return found;
    }

    private void itsfull(T e, boolean tipo, int index){
        if(numItems == MAX_LIST){
            T[] guardado = (T[]) new Object[MAX_LIST * 2];
            guardado = items;
            if(tipo == false && index == 0)
                add(e);
            add(index, e);
        }
    }
    
    /**
     * @post Appends element e to the end of this list.
     *   More formally, it satisfies: this = old(this) ++ [e].
     */
    public void add(T e) {
        int i = 0;
        boolean found = false;
        while(i < MAX_LIST && !found){
            if(items[i] == null){
                found = true;
                items[i] = e;
            }
            i++;
        }
        numItems += 1;
        itsfull(e, false, 0);

    }
    
    /**
     * @post Removes the first occurrence of e from this list.
     *   If e is not in the list it does not modify the list.
     *   Returns true iff e is removed (result = e in old(list)).
     */
    public boolean remove(T e) {
       int i = 0;
       if(i == MAX_LIST)
            items[i] = null;

       while(i < MAX_LIST){
            items[i] = items[i+1];
            i++;
       }
        return contains(e);
    }
    
    /**
     * @post Removes all of the elements from the list,
     *   More formally, it satisfies: #this = 0.
     */
    public void clear() {
        numItems = 0;
    }

    /**
     * @pre 0 <= index < size()
     * @post If the give index is in the list return true, 
     * otherwise false 
     */
    private boolean containsIndex(int index){
       if(reapOK(index))
            throw new IndexOutOfBoundsException();

        for(int i = 0; i < MAX_LIST; i++){
            if(i == index)
                return true;
        }
        return false;
    }
    
    /**
     * @pre 0 <= index < size() (throws an IndexOutOfBoundsException)
     * @post Returns the element at position index in the list,
     *   More formally, it satisfies: result = this[index].
     */
    public T get(int index) {
        if(reapOK(index))
           throw new IndexOutOfBoundsException("Imposible que ese index exista");
        if(containsIndex(index))
            return items[index];
        return null;
    }
    
    /**
     * @pre 0 <= index < size() (throws an IndexOutOfBoundsException)
     * @post Replaces the element at position index with e, and returns
     *   the element that was replaced.
     *   More formally, it satisfies: 
     *     this[index].equals(e) && #this = #old(this) && 
     *     result.equals(old(this)[index]).
     */
    public T set(int index, T e) {
        if(reapOK(index))
           throw new IndexOutOfBoundsException("imposible que ese index exista");
        if(containsIndex(index)){
            T guardado = items[index];
            items[index] = e;
            return guardado;
        }
        return null;
    }

    /**
     * @pre 0 <= index < size()
     * @post Move all elements the unit they reach the given index
     */
    private void mover(int index, boolean tipo){
        if(reapOK(index)) 
            throw new IndexOutOfBoundsException();
        if(tipo == false)
            for(int i = 0; i < MAX_LIST && numItems-i != index; i++)
                items[index+i] = items[1+(i+1)];
        for(int i = 0; i < MAX_LIST &&  numItems-i != index; i++)
            items[numItems-i] = items[numItems-(1+i)];
    }
    
    /**
     * @pre 0 <= index < size() (throws an IndexOutOfBoundsException)
     * @post Inserts the element at position index with e.
     *   More formally, it satisfies: 
     *   this[index].equals(e) && #this = #old(this) +1.
     */
    public void add(int index, T e) {
       if(reapOK(index))
            throw new IllegalArgumentException("Imposible que ese index exista");
        if(containsIndex(index)){
            mover(index, true);
            set(index, e);
            numItems ++;
        }
        itsfull(e, true, index);
        //mover(index);
        //set(index, e);
    }
    
    /**
     * @pre 0 <= index < size() (throws an IndexOutOfBoundsException)
     * @post Removes the element at position index.
     *   More formally, it satisfies: 
     *   result = old(this)[index] && #this = #old(this) -1.
     */
    public T remove(int index) {
        if(reapOK(index)) 
            throw new IllegalArgumentException();
        T guardado = items[index];
        mover(index, false);
        numItems--;
        return guardado;
    }
    
    /** 
     * @post Returns the index of the first occurrence of e
     *   in the list, or -1 if this list does not contain e.
     *   More formally, it satisfies: 
     *     result = -1 -> !(e in this) && 
     *     result != -1 -> this[result].equals(e).
     */
    public int indexOf(T e) {
        for(int i = 0; i < MAX_LIST; i++){
            if(items[i] == e)
                return i;
       }
       return -1;
    }

    private boolean reapOK( int index){
        if(index < 0 || index > MAX_LIST)
            return true;
        return false;
    }
    
}
