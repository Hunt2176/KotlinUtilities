package Utilities.Objects

import Utilities.Extensions.useAndReturn

class Queue <T : Any>: Iterator<T>
{
	private var source: ArrayList<T> = arrayListOf()
	val count: Int
		get() = source.count()
	
	val isEmpty: Boolean
		get() = source.isEmpty()
	
	constructor(vararg items: T)
	{
		items.toCollection(source)
	}
	
	constructor(collection: Collection<T>)
	{
		source.addAll(collection)
	}
	
	fun enqueue(item: T)
	{
		source.add(item)
	}
	
	fun enqueue(vararg items: T)
	{
		items.forEach { source.add(it) }
	}
	
	fun enqueueCollection(collection: Collection<T>)
	{
		collection.forEach { source.add(it) }
	}
	
	fun dequeue(): T
	{
		return source.first().useAndReturn {
			source.remove(it)
			source.trimToSize()
			return@useAndReturn it
		}
	}
	
	fun dequeue(using: (T) -> Unit)
	{
		using(dequeue())
	}
	
	override fun next(): T
	{
		return dequeue()
	}
	
	override fun hasNext(): Boolean
	{
		return source.count() > 0
	}
}