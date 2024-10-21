package estructuras;

import java.util.ArrayList;

import java.util.List;

public class Heap<T extends Comparable<T>> {
    private List<T> elements;
    private boolean isMaxHeap;

    // Constructor
    public Heap(boolean isMaxHeap) {
        this.isMaxHeap = isMaxHeap;
        elements = new ArrayList<>();
    }

    // Método para agregar elementos
    public void add(T element) {
        elements.add(element);
        if (isMaxHeap) {
            siftUpMax(elements.size() - 1);
        } else {
            siftUpMin(elements.size() - 1);
        }
    }

    // Método para retirar el elemento más prioritario (el primero en la heap)
    public T poll() {
        if (elements.size() == 0) return null;

        T root = elements.get(0);
        T last = elements.remove(elements.size() - 1);

        if (elements.size() > 0) {
            elements.set(0, last);
            if (isMaxHeap) {
                siftDownMax(0);
            } else {
                siftDownMin(0);
            }
        }
        return root;
    }

    // Método para obtener la lista de elementos
    public List<T> getElements() {
        return elements;
    }

    // Métodos para subir y bajar elementos (en el heap)
    private void siftUpMax(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (elements.get(index).compareTo(elements.get(parent)) > 0) {
                T temp = elements.get(index);
                elements.set(index, elements.get(parent));
                elements.set(parent, temp);
                index = parent;
            } else {
                break;
            }
        }
    }

    private void siftUpMin(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (elements.get(index).compareTo(elements.get(parent)) < 0) {
                T temp = elements.get(index);
                elements.set(index, elements.get(parent));
                elements.set(parent, temp);
                index = parent;
            } else {
                break;
            }
        }
    }

    private void siftDownMax(int index) {
        while (2 * index + 1 < elements.size()) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int largest = index;

            if (left < elements.size() && elements.get(left).compareTo(elements.get(largest)) > 0) {
                largest = left;
            }
            if (right < elements.size() && elements.get(right).compareTo(elements.get(largest)) > 0) {
                largest = right;
            }

            if (largest != index) {
                T temp = elements.get(index);
                elements.set(index, elements.get(largest));
                elements.set(largest, temp);
                index = largest;
            } else {
                break;
            }
        }
    }

    private void siftDownMin(int index) {
        while (2 * index + 1 < elements.size()) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = index;

            if (left < elements.size() && elements.get(left).compareTo(elements.get(smallest)) < 0) {
                smallest = left;
            }
            if (right < elements.size() && elements.get(right).compareTo(elements.get(smallest)) < 0) {
                smallest = right;
            }

            if (smallest != index) {
                T temp = elements.get(index);
                elements.set(index, elements.get(smallest));
                elements.set(smallest, temp);
                index = smallest;
            } else {
                break;
            }
        }
    }

    public int size() {
        return elements.size();
    }
}
