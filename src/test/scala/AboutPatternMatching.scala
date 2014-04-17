class AboutPatternMatching extends HandsOn {

  test("Pattern matching returns something") {

    val stuff = "blue"

    val myStuff = stuff match {
      case "red" => println("RED"); 1
      case "blue" => println("BLUE"); 2
      case "green" => println("GREEN"); 3
      case _ => println(stuff); 0 //case _ will trigger if all other cases fail.
    }

    myStuff should be(__)

  }

  test("Pattern matching can return complex somethings") {
    val stuff = "blue"

    val myStuff = stuff match {
      case "red" => (255, 0, 0)
      case "green" => (0, 255, 0)
      case "blue" => (0, 0, 255)
      case _ => println(stuff); 0
    }

    myStuff should be(__, __, __)

  }

  test("Pattern matching can match complex expressions") {

    def goldilocks(expr: Any) = expr match {
      case ("porridge", "Papa") => "Papa eating porridge"
      case ("porridge", "Mama") => "Mama eating porridge"
      case ("porridge", "Baby") => "Baby eating porridge"
      case _ => "what?"
    }

    goldilocks(("porridge", "Mama")) should be(__)

  }

  test("Pattern matching can wildcard parts of expressions") {

    def goldilocks(expr: Any) = expr match {
      case ("porridge", _) => "eating"
      case ("chair", "Mama") => "sitting"
      case ("bed", "Baby") => "sleeping"
      case _ => "what?"
    }

    goldilocks(("porridge", "Papa")) should be(__)
    goldilocks(("chair", "Mama")) should be(__)

  }

  test("Pattern matching can substitute parts of expressions") {

    def goldilocks(expr: Any) = expr match {
      case ("porridge", bear) => bear + " said someone's been eating my porridge"
      case ("chair", bear) => bear + " said someone's been sitting in my chair"
      case ("bed", bear) => bear + " said someone's been sleeping in my bed"
      case _ => "what?"
    }

    goldilocks(("porridge", "Papa")) should be(__)
    goldilocks(("chair", "Mama")) should be(__)
  }

  test(
    """To pattern match against a List, the list can be broken out into parts,
      | in this case the head (x) and the tail(xs). Since the case doesn't terminate in Nil,
      | xs is interpreted as the rest of the list""") {
    val secondElement = List(1, 2, 3) match {
      case x :: xs => xs.head
      case _ => 0
    }

    secondElement should be(__)
  }

  test(
    """To obtain the second you can expand on the pattern. Where x is the first element, y
      | is the second element, and xs is the rest. """.stripMargin) {
    val secondElement = List(1, 2, 3) match {
      case x :: y :: xs => xs
      case _ => 0
    }

    secondElement should be(__)
  }

  test(
    """Same test as above, but we are pattern matching of a list with only one item!""".stripMargin) {
    val secondElement = List(1) match {
      case x :: y :: xs => xs
      case _ => 0
    }

    secondElement should be(__)
  }

  test(
    """To pattern match against List, you can also establish a pattern match
      | if you know the exact number of elements in a List""") {

    val r = List(1, 2, 3) match {
      case x :: y :: Nil => y
      case _ => 0
    }

    r should be(__)
  }




}