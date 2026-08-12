/**
 * Односвязный список целых чисел.
 *
 * Элементы хранятся в отдельных узлах, связанных друг с другом ссылками.
 */
class IntLinkedList : Iterable<Int> {
    private class Node(
        val value: Int,
        var next: Node? = null,
    )

    private var head: Node? = null
    private var tail: Node? = null

    /**
     * Добавляет значение в конец списка.
     *
     * @param value добавляемое целое число
     */
    fun addLast(value: Int) {
        val newNode = Node(value)

        if (head == null) {
            head = newNode
            tail = newNode
        } else {
            tail?.next = newNode
            tail = newNode
        }
    }

    /**
     * Возвращает итератор для последовательного обхода элементов списка.
     *
     * @return итератор, перемещающийся по связанным узлам списка
     */
    override fun iterator(): Iterator<Int> = NodeIterator(head)

    private class NodeIterator(
        private var current: Node?,
    ) : Iterator<Int> {
        override fun hasNext(): Boolean = current != null

        override fun next(): Int {
            val node = current ?: throw NoSuchElementException("No more elements in the linked list")

            current = node.next
            return node.value
        }
    }
}