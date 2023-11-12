package basic.class_methodNotation

//to define static in scala, use companion object beside class and put fields needed to be static in it
object Person {
  val age = 40
  def apply(name: String, film: String): Person = new Person(name, film)
}

class Person(val name: String, val favoriteFilm: String) {
  def likes(film: String): Boolean = this.favoriteFilm == film

  def isAlive: Boolean = true

  def +(person: Person): String = this.name + s" is fighting with ${person.name}"

  override def toString: String = s"THIS IS ${this.name.toUpperCase()}"
}

extension (c: Person) {
  def apply(): String = s"Hello ${c.name}"
  def apply(times: Int): String = s"${c.name} watched ${c.favoriteFilm} $times times"
}