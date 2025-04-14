package collection;

    /**
     * Простейшая реализация двусвязного LinkedList.
     */
    public class MyLinkedList2<E> {
        private class Node {
            E data;
            Node next;
            Node prev;

            Node(E data) {
                this.data = data;
            }
        }

        private Node head;
        private Node tail;
        private int size;

        /**
         * Добавляет элемент в конец списка.
         *
         * @param element элемент, который нужно добавить
         */
        public void add(E element) {
            Node newNode = new Node(element);
            if (tail != null) {
                tail.next = newNode;
                newNode.prev = tail;
            } else {
                head = newNode;
            }
            tail = newNode;
            size++;
        }

        /**
         * Удаляет элемент по индексу.
         *
         * @param index индекс элемента для удаления
         * @return удаленный элемент
         */
        public E remove(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException();
            }
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            if (current.prev != null) {
                current.prev.next = current.next;
            } else {
                head = current.next; // Если удаляем голову
            }
            if (current.next != null) {
                current.next.prev = current.prev;
            } else {
                tail = current.prev; // Если удаляем хвост
            }
            size--;
            return current.data;
        }

        /**
         * Получает элемент по индексу.
         *
         * @param index индекс элемента
         * @return элемент по указанному индексу
         */
        public E get(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException();
            }
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.data;
        }

        /**
         * Устанавливает элемент по индексу.
         *
         * @param index индекс для установки элемента
         * @param element новый элемент
         * @return старый элемент на указанном индексе
         */
        public E set(int index, E element) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException();
            }
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            E oldElement = current.data;
            current.data = element;
            return oldElement;
        }

        /**
         * Возвращает подсписок от указанного начального индекса до конечного.
         *
         * @param fromIndex начальный индекс
         * @param toIndex конечный индекс
         * @return новый MyDoublyLinkedList, содержащий элементы из указанного диапазона
         */
        public MyLinkedList2<E> subList(int fromIndex, int toIndex) {
            if (fromIndex < 0 || toIndex > size || fromIndex > toIndex) {
                throw new IndexOutOfBoundsException();
            }
            MyLinkedList2<E> subList = new MyLinkedList2<>();
            Node current = head;
            for (int i = 0; i < fromIndex; i++) {
                current = current.next;
            }
            for (int i = fromIndex; i < toIndex; i++) {
                subList.add(current.data);
                current = current.next;
            }
            return subList;
        }

        /**
         * Возвращает количество элементов в списке.
         *
         * @return размер списка
         */
        public int size() {
            return size;
    }
}
