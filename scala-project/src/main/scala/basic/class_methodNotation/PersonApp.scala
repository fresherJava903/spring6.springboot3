package basic.class_methodNotation

object PersonApp extends App {
    try {
        val mary = Person("Mary", "Titanic")
        val jack = Person("Jack", "Caribbean Pirate")

        println(mary())
        println(jack.likes(mary.favoriteFilm))
        println(mary.isAlive)
        println(jack(5))
        println(jack + mary)
        println(Person.age)
    } catch {
        case e: Exception => print(e.getMessage)
    }
}