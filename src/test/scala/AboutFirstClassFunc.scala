case class Person(name: String, age: Int, emailAddresses: List[EmailAddress])

case class EmailAddress(address: String)

class AboutFirstClassFunc extends HandsOn {
  val pierre = Person("Pierre", 30, List(EmailAddress("pierre@gmail.com")))
  val paul = Person("Paul", 33, List(EmailAddress("paul@orange.fr"), EmailAddress("paul@yahoo.fr")))
  val kevin = Person("Kevin", 9, Nil)
  val persons = List(pierre, paul, kevin)

  test("Trouver les adultes") {

    val adults = Nil

    assert(List(pierre, paul) === adults)
  }

  test("Trouver le nom de toutes les personnes") {
    val names = Nil


    assert(List("Pierre", "Paul", "Kevin") === names)
  }

  test("Trouver le nom de tous le adultes") {
    val names = Nil


    assert(List("Pierre", "Paul") === names)
  }

  test("Patition contenant d'un coté les adultes de l'autre les enfants") {
    val (adults, kids) = (Nil, Nil)

    assert(List(pierre, paul) === adults)
    assert(List(kevin) === kids)
  }

  test("Partition contenant d'un coté les gens ayant plus d'une adresse mail de l'autre les autres") {
    val (techies, luddites) = (Nil, Nil)

    assert(List(paul) === techies)
    assert(List(pierre, kevin) === luddites)
  }

  test("Trouve Kevin") {
    val name = "Kevin"
    val person: Option[Person] = None


    person match {
      case Some(person) => assert(kevin === person)
      case _ => sys.error("No match")
    }
  }

  test("Trouve Charlie") {
    val name = "Charlie"
    val person: Option[Person] = Some(persons(0))

    person match {
      case None => () // OK
      case _ => sys.error("Unexpected match")
    }
  }

  test("Trouver l'adresse mail de la personne qui s'appelle Pierre") {
    val name = "Pierre"
    val addresses: Option[List[EmailAddress]] = None


    addresses match {
      case Some(addresses) => assert(pierre.emailAddresses === addresses)
      case _ => sys.error("No match")
    }
  }

  test("Trouver la personne avec l'adresse paul@yahoo.com") {
    val address = EmailAddress("paul@yahoo.fr")
    val person: Option[Person] = None


    person match {
      case Some(person) => assert(paul === person)
      case _ => sys.error("No match")
    }
  }


  test("Faire une liste avec la première adresse de chaque personne") {
    val addresses = Nil

    assert(List(pierre.emailAddresses.head, paul.emailAddresses.head) === addresses)
  }



  test("Bonus : Creer une map NOM -> EMAILs, si pas de mail ne pas inclure") {
    //Tips : utiliser foldLeft
    val emptyMap: Map[String, List[EmailAddress]] = Map()
    val nameToEmail = emptyMap

    assert(Map(pierre.name -> pierre.emailAddresses, paul.name -> paul.emailAddresses) === nameToEmail)
  }
  
}