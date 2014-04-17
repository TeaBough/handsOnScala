import java.util.Date

class AboutBasics extends HandsOn {
  test("vars may be reassigned") {
    var a = 5
    a should be(__) //Fix this.

    a = 7
    a should be(__)
  }

  test("vals may not be reassigned") {
    val a = 5
    a should be(__)

    // What happens if you uncomment these lines?
    // a = 7
    a should be(__)
  }

  test("""Boolean literals are either true or false, using the true or false keyword""") {
    val a = true
    val b = false
    val c = 1 > 2
    val d = 1 < 2
    val e = a == c
    val f = b == d
    a should be(__)
    b should be(__)
    c should be(__)
    d should be(__)
    e should be(__)
    f should be(__)
  }

  test("""If a method does not of have equal it is considered `Unit` which is analogous to `void` in Java
			""") {
    def foo(x: Int) {
      (x + 4) should be(__)
    }

    foo(5)
  }

  test("""If you want to have an = on the method you can make the return type `Unit`,
			| this also analogous to `void""") {
    def foo(x: Int): Unit = {
      (x + 4) should be(__)
    }

    foo(3)
  }

  test("""Once you have an =, it is understood that there will be a return type and can be inferred""") {
    def foo(x: Int) = 3 + 4
    foo(3).isInstanceOf[Int] should be(__)
  }

  test("""Of course if you wish to be explicit about the return type, you can attach it at the end of themethod""") {
    def foo(x: Int): Int = 3 + 4
    foo(3).isInstanceOf[Int] should be(__)
  }

  test("""As an important concept in function programming and in Scala, a method is also a function""") {
    def foo(x: Int) = x * 2
    val result = List(1, 2, 3).map(foo) //map performs a function on each element
    result should be(__)
  }

  test("Tuples can be created easily") {
    val tuple = ("apple", "dog")
    tuple should be((__, __))
  }

  test("Tuple items may be accessed individually") {
    val tuple = ("apple", "dog")
    val fruit = tuple._1
    val animal = tuple._2

    fruit should be(__)
    animal should be(__)
  }

  test("Tuples may be of mixed type") {
    val tuple5 = ("a", 1, 2.2, new Date(), BigDecimal(5))

    tuple5._2 should be(__)
    tuple5._5 should be(__)
  }

  test("Tuples items can be swapped on a Tuple 2") {
    val tuple = ("apple", 3).swap
    tuple._1 should be(__)
    tuple._2 should be(__)
  }
  
  
  // case classes are very convenient, they give you a lot for free. The following Tests will
  // help you understand some of the conveniences. Case classes are also an integral part of
  // pattern matching which will be the subject of a later

  test("Case classes have an automatic equals method that works") {
    case class Person(first: String, last: String)

    val p1 = new Person("Fred", "Jones")
    val p2 = new Person("Shaggy", "Rogers")
    val p3 = new Person("Fred", "Jones")

    (p1 == p2) should be(__)
    (p1 == p3) should be(__)

    (p1 eq p2) should be(__)
    (p1 eq p3) should be(__) // not identical, merely equal
  }

  test("Case classes have an automatic hashcode method that works") {
    case class Person(first: String, last: String)

    val p1 = new Person("Fred", "Jones")
    val p2 = new Person("Shaggy", "Rogers")
    val p3 = new Person("Fred", "Jones")

    (p1.hashCode == p2.hashCode) should be(__)
    (p1.hashCode == p3.hashCode) should be(__)
  }

  test("Case classes have a convenient way they can be created") {
    case class Dog(name: String, breed: String)

    val d1 = Dog("Scooby", "Doberman")
    val d2 = Dog("Rex", "Custom")
    val d3 = new Dog("Scooby", "Doberman") // the old way of creating using new

    (d1 == d3) should be(__)
    (d1 == d2) should be(__)
    (d2 == d3) should be(__)
  }

  test("Case classes have a convenient toString method defined") {
    case class Dog(name: String, breed: String)
    val d1 = Dog("Scooby", "Doberman")
    d1.toString should be(__)
  }

  test("Case classes have automatic properties") {
    case class Dog(name: String, breed: String)

    val d1 = Dog("Scooby", "Doberman")
    d1.name should be(__)
    d1.breed should be(__)

    // what happens if you uncomment the line below? Why?
    //d1.name = "Scooby Doo"
  }

  test("Case classes can have mutable properties") {
    case class Dog(var name: String, breed: String) // you can rename a dog, but change its breed? nah!
    val d1 = Dog("Scooby", "Doberman")

    d1.name should be(__)
    d1.breed should be(__)

    d1.name = "Scooby Doo" // but is it a good idea?

    d1.name should be(__)
    d1.breed should be(__)
  }

  test("Safer alternatives exist for altering case classes") {
    case class Dog(name: String, breed: String) // Doberman

    val d1 = Dog("Scooby", "Doberman")

    val d2 = d1.copy(name = "Scooby Doo") // copy the case class but change the name in the copy

    d1.name should be(__) // original left alone
    d1.breed should be(__)

    d2.name should be(__)
    d2.breed should be(__) // copied from the original
  }

  
  test("Case classes have default and named parameters") {
    case class Dude(first: String, last: String, age: Int = 0, ssn: String = "")

    val p1 = Dude("Fred", "Jones", 23, "111-22-3333")
    val p2 = Dude("Samantha", "Jones") // note missing age and ssn
    val p3 = Dude(last = "Jones", first = "Fred", ssn = "111-22-3333") // note the order can change, and missing age
    val p4 = p3.copy(age = 23)

    p1.first should be(__)
    p1.last should be(__)
    p1.age should be(__)
    p1.ssn should be(__)

    p2.first should be(__)
    p2.last should be(__)
    p2.age should be(__)
    p2.ssn should be(__)

    p3.first should be(__)
    p3.last should be(__)
    p3.age should be(__)
    p3.ssn should be(__)

    (p1 == p4) should be(__)
  }


}
