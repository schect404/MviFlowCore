package com.atitto.mviflowarch.list

import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.databinding.ListChangeRegistry
import androidx.databinding.ObservableList
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListUpdateCallback
import java.util.AbstractList

class AsyncObservableList<T>(callback: DiffUtil.ItemCallback<T> = SimpleDiffCallback()) : AbstractList<T>(),
    ObservableList<T> {

    private val differ: AsyncListDiffer<T>
    private val listeners = ListChangeRegistry()

    init { differ = AsyncListDiffer(ObservableListUpdateCallback(), AsyncDifferConfig.Builder<T>(callback).build()) }

    fun update(@Nullable newItems: List<T>) {
        differ.submitList(newItems)
    }

    fun list(): List<T> {
        return differ.currentList
    }

    override fun addOnListChangedCallback(@NonNull listener: ObservableList.OnListChangedCallback<out ObservableList<T>>) {
        listeners.add(listener)
    }

    override fun removeOnListChangedCallback(@NonNull listener: ObservableList.OnListChangedCallback<out ObservableList<T>>) {
        listeners.remove(listener)
    }

    override fun indexOf(element: T): Int {
        return differ.currentList.indexOf(element)
    }

    override fun lastIndexOf(element: T): Int {
        return differ.currentList.lastIndexOf(element)
    }

    @NonNull
    override fun subList(fromIndex: Int, toIndex: Int): MutableList<T> {
        return differ.currentList.subList(fromIndex, toIndex)
    }

    @NonNull
    override fun listIterator(index: Int): MutableListIterator<T> {
        return differ.currentList.listIterator(index)
    }

    override fun get(index: Int): T {
        return differ.currentList[index]
    }

    override val size: Int get() = differ.currentList.size

    internal class SimpleDiffCallback<T>: DiffUtil.ItemCallback<T>() {

        override fun areItemsTheSame(oldItem: T, newItem: T) = oldItem == newItem

        override fun areContentsTheSame(oldItem: T, newItem: T) = true
    }

    internal inner class ObservableListUpdateCallback : ListUpdateCallback {

        override fun onChanged(position: Int, count: Int, payload: Any?) {
            listeners.notifyChanged(this@AsyncObservableList, position, count)
        }

        override fun onInserted(position: Int, count: Int) {
            modCount += 1
            listeners.notifyInserted(this@AsyncObservableList, position, count)
        }

        override fun onRemoved(position: Int, count: Int) {
            modCount += 1
            listeners.notifyRemoved(this@AsyncObservableList, position, count)
        }

        override fun onMoved(fromPosition: Int, toPosition: Int) {
            listeners.notifyMoved(this@AsyncObservableList, fromPosition, toPosition, 1)
        }
    }
}