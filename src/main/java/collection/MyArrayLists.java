package collection;

public class MyArrayLists<E> {
    /**
     * Простейшая реализация ArrayList.
     */
        private Object[] elements;
        private int size;

        public MyArrayLists() {
            elements = new Object[10];
            size = 0;
        }

        /**
         * Добавляет элемент в конец списка.
         *
         * @param element элемент, который нужно добавить
         */
        public void add(E element) {
            ensureCapacity();
            elements[size++] = element;
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
            E removedElement = (E) elements[index];
            System.arraycopy(elements, index + 1, elements, index, size - index - 1);
            elements[--size] = null; // Убираем ссылку для сборщика мусора
            return removedElement;
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
            return (E) elements[index];
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
            E oldElement = (E) elements[index];
            elements[index] = element;
            return oldElement;
        }

        /**
         * Возвращает подсписок от указанного начального индекса до конечного.
         *
         * @param fromIndex начальный индекс
         * @param toIndex конечный индекс
         * @return новый MyArrayList, содержащий элементы из указанного диапазона
         */
        public MyArrayLists<E> subList(int fromIndex, int toIndex) {
            if (fromIndex < 0 || toIndex > size || fromIndex > toIndex) {
                throw new IndexOutOfBoundsException();
            }
            MyArrayLists<E> subList = new MyArrayLists<>();
            for (int i = fromIndex; i < toIndex; i++) {
                subList.add((E) elements[i]);
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

        private void ensureCapacity() {
            if (size == elements.length) {
                Object[] newElements = new Object[elements.length * 2];
                System.arraycopy(elements, 0, newElements, 0, elements.length);
                elements = newElements;
            }
        }
    }

