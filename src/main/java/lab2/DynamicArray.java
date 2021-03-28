package lab2;

public class DynamicArray {
  private static int INITIAL_CAPACITY = 5;
  private int[] data;
  private int size;
  public DynamicArray() {
    data = new int[INITIAL_CAPACITY];
    size = 0;
  }

  // Returns `true` if the array is empty.
  public boolean isEmpty() {
    return size == 0;
  }

  // Returns the size of the array.
  public int size() {
    return size;
  }

  // Remove all elements from data.
  public void clear() {
    size = 0;
  }

  // Create a `String` with the elements of the array separated by comma, without a new line character at the end.
  // For instance: 4, 5, 6
  public String toString() {
    String s = "";
    for(int i = 0; i < size - 1; ++i) {
      s += data[i] + ", ";
    }
    if(!isEmpty()) {
      s += data[size-1];
    }
    return s;
  }

  // Returns `true` if the array `data` is full: no more element can be added to `data`.
  // Returns `false` otherwise.
  private boolean isFull() {
    return size == data.length;
  }

  // If the array `data` is full:
  //  1. Create a new array `data2` doubling the size of data.
  //  2. Copy the elements of `data` into `data2`.
  //  3. Assign `data2` to `data`.
  private void realloc() {
    if(isFull()) {
      int[] data2 = new int[data.length * 2];
      for(int i = 0; i < data.length; ++i) {
        data2[i] = data[i];
      }
      data = data2;
    }
  }

  // The element `x` is added to `data`, and `size` is incremented by one.
  // `data` is automatically resized if it is too small.
  public void add(int x) {
    realloc();
    data[size] = x;
    size += 1;
  }

  private void checkIndex(int idx) {
    if(idx >= size) {
      throw new ArrayIndexOutOfBoundsException();
    }
  }

  // Set the ith element of `data` to `x`.
  public void set(int idx, int x) {
    checkIndex(idx);
    data[idx] = x;
  }

  // Return the element at the index `idx` of `data`.
  public int get(int idx) {
    checkIndex(idx);
    return data[idx];
  }

  // Remove the element at index `idx`.
  // Shift all the elements after `idx` of one position to the left.
  public void remove(int idx) {
    checkIndex(idx);
    for(int i = idx; i < size - 1; ++i) {
      data[i] = data[i + 1];
    }
    size -= 1;
  }
}
