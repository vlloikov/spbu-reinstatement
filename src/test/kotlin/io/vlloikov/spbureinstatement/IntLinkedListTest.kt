package io.vlloikov.spbureinstatement

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotSame

internal class IntLinkedListTest {
    @Test
    fun removesConsecutiveDuplicatesFromTaskExample() {
        val source =
            IntLinkedList().apply {
                addLast(1)
                addLast(1)
                addLast(2)
                addLast(3)
                addLast(3)
                addLast(3)
            }

        val result = removeConsecutiveDuplicates(source)

        assertEquals("1 2 3", result.joinToString(" "))
    }

    @Test
    fun returnsEmptyListForEmptySource() {
        val source = IntLinkedList()

        val result = removeConsecutiveDuplicates(source)

        assertEquals("", result.joinToString(" "))
        assertNotSame(source, result)
    }

    @Test
    fun keepsSingleElement() {
        val source =
            IntLinkedList().apply {
                addLast(42)
            }

        val result = removeConsecutiveDuplicates(source)

        assertEquals("42", result.joinToString(" "))
    }

    @Test
    fun keepsElementsWithoutConsecutiveDuplicates() {
        val source =
            IntLinkedList().apply {
                addLast(1)
                addLast(2)
                addLast(3)
                addLast(4)
            }

        val result = removeConsecutiveDuplicates(source)

        assertEquals("1 2 3 4", result.joinToString(" "))
    }

    @Test
    fun collapsesIdenticalElementsIntoOne() {
        val source =
            IntLinkedList().apply {
                addLast(7)
                addLast(7)
                addLast(7)
                addLast(7)
            }

        val result = removeConsecutiveDuplicates(source)

        assertEquals("7", result.joinToString(" "))
    }

    @Test
    fun keepsEqualElementsWhenTheyAreNotConsecutive() {
        val source =
            IntLinkedList().apply {
                addLast(1)
                addLast(2)
                addLast(1)
                addLast(2)
            }

        val result = removeConsecutiveDuplicates(source)

        assertEquals("1 2 1 2", result.joinToString(" "))
    }

    @Test
    fun supportsNegativeValuesAndZero() {
        val source =
            IntLinkedList().apply {
                addLast(-1)
                addLast(-1)
                addLast(0)
                addLast(0)
                addLast(2)
            }

        val result = removeConsecutiveDuplicates(source)

        assertEquals("-1 0 2", result.joinToString(" "))
    }

    @Test
    fun doesNotModifySourceList() {
        val source =
            IntLinkedList().apply {
                addLast(1)
                addLast(1)
                addLast(2)
                addLast(3)
                addLast(3)
                addLast(3)
            }

        val result = removeConsecutiveDuplicates(source)

        assertEquals("1 1 2 3 3 3", source.joinToString(" "))
        assertEquals("1 2 3", result.joinToString(" "))
        assertNotSame(source, result)
    }
}
