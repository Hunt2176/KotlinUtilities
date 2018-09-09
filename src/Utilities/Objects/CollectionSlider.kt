package Utilities.Objects

class CollectionSlider<T>(val arrayToSlide: Collection<T>)
{
	private var cursor = 0
	
	fun reset()
	{
		cursor = 0
	}
	
	fun hasLeft(): Boolean
	{
		return cursor > 0
	}
	
	fun hasRight(): Boolean
	{
		return cursor < arrayToSlide.size - 1
	}
	
	fun getCurrentItem(): T
	{
		return arrayToSlide.elementAt(cursor)
	}
	
	fun moveLeft(): T
	{
		if (hasLeft())
		{
			cursor -= 1
		}
		return getCurrentItem()
	}
	
	fun moveRight(): T
	{
		if (hasRight())
		{
			cursor += 1
		}
		return getCurrentItem()
	}
	
	fun moveLeftorNull(): T?
	{
		return if (hasLeft()) moveLeft() else null
	}
	
	fun moveRightorNull(): T?
	{
		return if (hasRight()) moveRight() else null
	}
}