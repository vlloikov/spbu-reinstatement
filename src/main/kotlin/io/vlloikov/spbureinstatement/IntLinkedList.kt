package io.vlloikov.spbureinstatement

/**
 * Односвязный список целых чисел.
 *
 * Элементы списка хранятся в отдельных узлах, связанных ссылками.
 */
class IntLinkedList : Iterable<Int> {
    private class Node(
        val value: Int,
        var next: Node? = null,
    )

    private var head: Node? = null
    private var tail: Node? = null

    /**
     * Добавляет целое число в конец списка.
     *
     * @param value добавляемое значение
     */
    fun addLast(value: Int) {
        val newNode = Node(value)

        if (head == null) {
            head = newNode
            tail = newNode
            return
        }

        tail?.next = newNode
        tail = newNode
    }

    /**
     * Возвращает итератор для последовательного обхода элементов списка.
     *
     * @return итератор по элементам списка
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

/**
 * Создаёт новый связный список без повторяющихся соседних элементов.
 *
 * Исходный список не изменяется и продолжает находиться в памяти отдельно
 * от созданного результата.
 *
 * @param source исходный связный список
 * @return новый связный список без последовательных повторов
 */
fun removeConsecutiveDuplicates(source: IntLinkedList): IntLinkedList {
    val result = IntLinkedList()
    val iterator = source.iterator()

    if (!iterator.hasNext()) {
        return result
    }

    var previousValue = iterator.next()
    result.addLast(previousValue)

    while (iterator.hasNext()) {
        val currentValue = iterator.next()

        if (currentValue != previousValue) {
            result.addLast(currentValue)
            previousValue = currentValue
        }
    }

    return result
}
