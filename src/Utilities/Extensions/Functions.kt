package Utilities.Extensions

fun <T:Any> T?.ifNotNull(onNotNull:(T) -> Unit)
{
	if (this != null)
	{
		onNotNull(this)
	}
}

fun <T:Any> ifAllNotNull(vararg items: T?, onNoneNull:(Array<T>) -> Unit)
{
	for (i in items)
	{
		if (i == null) return
	}
	onNoneNull(items as Array<T>)
}

fun Any?.isNull(): Boolean
{
	return this == null
}

fun CharSequence.toIntOrZero():Int
{
	return this.toString().toIntOrZero()
}

fun String.toIntOrZero(): Int
{
	return if (this.toIntOrNull() == null) 0 else this.toInt()
}

fun <T> Iterable<T>.ifAllTrue(predicate: (T) -> Boolean): Boolean
{
	this.forEach { if (!predicate(it)) return false  }
	return true
}

fun <T> Collection<T>.ifAllTrue(predicate: (T) -> Boolean): Boolean
{
	this.forEach { if (!predicate(it)) return false }
	return true
}

fun <T:Any> T.use(toDo: (T) -> Unit)
{
	toDo(this)
}

fun <T:Any> T.useAndReturn(toDo: (T) -> T): T
{
	return toDo(this)
}

fun <E, T:Any> T.useAndReturnDifferent(toDo: (T) -> E): E
{
	return toDo(this)
}