package OOP.demo

import scala.util.Try

abstract class MyList[+T] {
  def head: T
  def tail: MyList[T]
  def isEmpty: Boolean
  def ++[S >: T](list: MyList[S]): MyList[S]
  def printElements: String
  def withFilter(predicate: T => Boolean): MyList[T]
  def map[B](transformer: T => B): MyList[B]
  def flatMap[B](transformer: T => MyList[B]): MyList[B]
  override def toString = s"${printElements}"
}

object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException()
  def tail: MyList[Nothing] = throw new NoSuchElementException()
  def isEmpty: Boolean = true
  def ++[S >: Nothing](list: MyList[S]): MyList[S] = list
  def withFilter(predicate: Nothing => Boolean): MyList[Nothing] = Empty
  def map[B](transformer: Nothing => B): MyList[B] = Empty
  def flatMap[B](transformer: Nothing => MyList[B]): MyList[B] = Empty
  def printElements:String = ""
}

//case class ~ record
case class Node[+T](h: T, t:MyList[T]) extends MyList[T] {
  def head: T = h
  def tail: MyList[T] = t
  def isEmpty: Boolean = false
  def ++[S >: T](list: MyList[S]): MyList[S] = Node(h, tail ++ list)
  def withFilter(predicate: T => Boolean): MyList[T] = {
    if (predicate(h)) Node(h, tail.withFilter(predicate)) else tail.withFilter(predicate)
  }
  def map[B](transformer: T => B): MyList[B] = Node(transformer(h), tail.map(transformer))
  def flatMap[B](transformer: T => MyList[B]): MyList[B] = transformer(h) ++ tail.flatMap(transformer)
  def printElements: String = if (tail.isEmpty) s"$h" else s"$h, ${tail.printElements}"
}

//object Empty extends MyList[Nothing] {
//  def head: Nothing = throw new NoSuchElementException()
//  def tail: MyList[Nothing] = throw new NoSuchElementException()
//  def isEmpty: Boolean = true
//  def ++[S >: Nothing](list: MyList[S]): MyList[S] = list
//  def printElements:String = ""
//}
//
//class Node[+T](val h: T, val t:MyList[T]) extends MyList[T] {
//  def head: T = h
//  def tail: MyList[T] = t
//  def isEmpty: Boolean = false
//  def ++[S >: T](list: MyList[S]): MyList[S] = new Node(h, tail ++ list)
//  def printElements: String = if (tail.isEmpty) s"$h" else s"$h, ${tail.printElements}"
//}
//
object TestGenerics extends App {
  val numbers1 = Node("1", Node("two", Node("3", Empty)))
  val numbers = Node(1, Node(2, Node(3, Empty)))
  val chars = Node("a", Node("b", Node("c", Empty)))
  val newList = numbers ++ chars
  val doubleMap = numbers.map(x => x * 2)
  println(numbers)
  println(newList)
  println(numbers == numbers1)
  println(doubleMap)
  println(numbers.withFilter(x => x%2 != 0))
  println(numbers.flatMap(x => Node(x, Node(x+1, Empty))))

  val result = for {
    x <- numbers if (x % 2 == 0)
    y <- chars
  } yield x + y
  println(result)

//  val tryResult = Try(numbers1.map(s => Integer.parseInt(s)))
//  val matchResult = tryResult match {
//    case Success(value) => value
//    case Failure(exception) => {
//      println(exception)
//      Empty
//    }
//  }
//  println(matchResult)
}