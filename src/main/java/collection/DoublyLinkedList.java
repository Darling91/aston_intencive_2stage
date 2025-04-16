package collection;

public class DoublyLinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    /**
     * Вставляет элемент в начало списка
     * для этой операции не требуется проходка по всему списку
     *
     * @param value
     */
    public void insertAtHead(E value) {
        Node<E> newNode = new Node<E>(value);
        if (head == null) {
            newNode.next = null;
            newNode.prev = null;
            head = newNode;
            tail = newNode;
            size++;
        } else {
            newNode.next = head;
            newNode.prev = null;
            head.prev = newNode;
            head = newNode;
            size++;
        }
    }

    /**
     * Вставляет элемент в конец списка
     * для этой операции не требуется проходка по всему списку
     *
     * @param value
     */
    public void insertAtTail(E value) {
        Node<E> newNode = new Node<E>(value);
        if (tail == null) {
            newNode.next = null;
            newNode.prev = null;
            head = newNode;
            tail = newNode;
            size++;
        } else {
            tail.next = newNode;
            newNode.next = null;
            newNode.prev = tail;
            tail = newNode;
            size++;
        }
    }

    /**
     * Вставляет элемент в заданную позицию
     * здесь требуется проходка по списку до позиции
     *
     * @param index
     * @param value
     */
    public void insertInPosition(int index, E value) {
        Node<E> currentNode = null;
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            insertAtHead(value);
        } else if (index == size - 1) {
            insertAtTail(value);
        } else if (currentNode == head) {
            //вставка в середину при переборе от головы
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
            //вставка в середину при переборе от хвоста
        }else{
            for(int i = size - 1; i > index; i--) {
                currentNode = currentNode.prev;
            }
        }
            Node<E> previousNode = currentNode.prev;
            //вставка нового узла между предыдущим и текущим
            Node<E> newNode = new Node<E>(value);
            newNode.next = currentNode;
            newNode.prev = previousNode;
            previousNode.next = newNode;
            currentNode.prev = newNode;
            size++;
        }


    /**
     * Проходка по списку в прямом направлении и печать элементов
     */
    public void traverseForward() {
        Node<E> temp = head;
        while (temp != null) {
            System.out.println(temp.item);
            temp = temp.next;
        }
    }

    /**
     * Проходка по списку в обратном направлении и печать элементов
     */
    public void traverseBackward() {
        Node<E> temp = tail;
        while (temp != null) {
            System.out.println(temp.item);
            temp = temp.prev;
        }
    }

    /**
     * Возвращает размер связанного списка
     *
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * Возвращает true, если связанный список пуст
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Поиск элемента по индексу
     *
     * @param index
     * @return
     */
    public Node<E> searchByIndex(int index) {
        Node<E> temp = null;
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        } else if (temp == head) {
            for (int i = 0; i < index; i++) {
                /*
                Начинаем с 0 и идем до тех пор, пока индекс не станет на единицу меньше
                потому что мы переходим к следующему узлу внутри цикла.
                 */
                temp = temp.next;
            }
            return temp;
        }else{
            /*
            Начинаем с последнего элемента и идем до тех пор, пока индекс не станет на единицу больше
            потому что мы переходим к предыдущему узлу внутри цикла
             */
            for (int i = size - 1; i > index; i--){
                temp = temp.prev;
            }
            return temp;
        }
    }


    /**
     * Поиск элемента по значению
     * @param value
     * @return
     */
    public Node<E> searchByValue(E value){
        Node<E> temp = null;
        if(temp == head) {
            while (null != temp.next && temp.item != value) {
                temp = temp.next;
            }
        }else {
            while (null != temp.prev && temp.item != value) {
                temp = temp.prev;
            }
        }
        if(temp.item == value){
            return temp;
        }
        return null;
    }

    /**
     * Удаляет элемент, присутствующий в головном узле
     */
    public void deleteFromHead(){
        if(head == null){
            return;
        }
        Node<E> temp = head;
        head = temp.next;
        head.prev = null;
        size--;
    }

    /**
     * Удаляет последний элемент
     */
    public void deleteFromTail(){
        if(tail == null){
            return;
        }
        Node<E> temp = tail;
        tail = temp.prev;
        tail.next = null;
        size--;
    }

    /**
     * Удаление по индексу
     * @param index
     */
    public void deleteFromPosition(int index){
        Node<E> deleteNode = null;
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        else if(deleteNode == head) {
            for (int i = 0; i < index; i++) {
                deleteNode = deleteNode.next;
            }
        }else {
            for (int i = size-1; i > index; i--) {
                deleteNode = deleteNode.prev;
            }
        }
        Node<E> previousNode = deleteNode.prev;
        Node<E> nextNode = deleteNode.next;
        previousNode.next = nextNode;
        nextNode.prev = previousNode;
        size --;
    }

    /**
     * Возвращает массив, содержащий каждый элемент списка
     * @return
     */
    public Object[] toArray(){
        Object[] array = new Object[size];
        int i = 0;
        for(Node<E> temp = head; temp != null; temp = temp.next){
            array[i++] = temp.item;
        }
        return array;
    }

    /**
     * Класс узла связанного списка
     * @param <T>
     */
    public class Node<T>{
        T item;
        Node<T> next;
        Node<T> prev;
        public Node(T item) {
            this.item = item;
        }

        @Override
        public String toString() {
            return String.valueOf(item);
        }
    }
}

