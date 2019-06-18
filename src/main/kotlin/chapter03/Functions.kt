package chapter03

typealias IntBiOp = (Int) -> (Int) -> Int

//fun compose(f: (Int) -> Int, g: (Int) -> Int): (Int) -> Int = { x -> f(g(x)) }
fun <T, U, V> compose(f: (U) -> V, g: (T) -> U): (T) -> V = { f(g(it)) }

fun main() {
    val add: (Int) -> (Int) -> (Int) -> Int = { a -> { b -> { c -> a + b + c } } }
    val addWithAlias: IntBiOp = { a -> { b -> a + b } }

    val a = add(1)
    val b = a(1)
    val c = b(1)
    println(c)
    println(add(10)(10)(10))


    val f: (Int) -> Int = { x: Int -> x }
    val g: (Int) -> Int = { x: Int -> x }

    val compose: ((Int) -> Int) -> ((Int) -> Int) -> ((Int) -> Int) = { a -> { b -> { c -> a(b(c)) } } }
    val square: (Int) -> Int = { it * it }
    val triple: (Int) -> Int = { it * 3 }
    val squareTriple = compose(square)(triple)
    println(squareTriple(2))

    val aa = { x: Int -> x }
    val tax = tax(aa)
}

fun tax(price: (Int) -> Int): (Int) -> (Int) -> Int = { x: Int -> { y: Int -> price(y) } }

fun <T, U, V> higherCompose(): ((U) -> V) -> ((T) -> U) -> (T) -> V = { f ->
    { g -> { x -> f(g(x)) } }
}