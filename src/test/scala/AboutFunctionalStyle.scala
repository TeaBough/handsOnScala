import scala.annotation.tailrec

class AboutFunctionalStyle extends HandsOn {

  test(
    """Methods can be embedded in other methods, this is particularly useful as helper methods for recurs
ion.
      | Also in Scala, any recursive method must have a return type.""") {

    //Reminder: 5! = 1 x 2 x 3 x 4 x 5 = 120

    def factorial(i: Int): Int = {
      def fact(i: Int, accumulator: Int): Int = {
        if (i <= 1)
          accumulator
        else
          fact(i - 1, i * accumulator)
      }
      fact(i, 1)
    }

    factorial(0) should be(__)
    factorial(1) should be(__)
    factorial(2) should be(__)
    factorial(3) should be(__)
  }

  test(
    """As a precaution, the helpful @tailrec annotation will throw a compile time if a method is not tail
 recursive,
      | meaning that the last call and only call of the method is the recursive method. Scala optimizes r
ecursive calls
      | to a loop from a stack""") {


    //    @tailrec   //Uncomment this like to see the result, then comment it again and answer the test
    def fibonacci(n: Int): Int = {
      if (n <= 1)
        1
      else
        fibonacci(n - 1) + fibonacci(n - 2)
    }

    //Reminder fibonacci sequence: 1, 1, 2, 3, 5, 8, 13, 21
    fibonacci(4) should be(__)
  }

  test(
    """As properly tail recursive method will use an accumulator method so that the only call of a recurs
ive method is the last one.
      | just like the first test above.""") {


    def fibonacci(n: Int) = {
      @tailrec
      def fib(n: Int, b: Int, a: Int): Int = n match {
        case 0 => a
        case _ => fib(n - 1, a + b, b)
      }

      fib(n, 1, 0)
    }
    //Reminder fibonacci sequence: 1, 1, 2, 3, 5, 8, 13, 21
    fibonacci(4) should be(__)
  }

  test( """ Exercice : implement the function last, that given a List return the last element using pattern matching """) {
    def last[A](l: List[A]): A = {
      ???
    }

    last(List(1, 2, 3, 4, 5, 6)) should be(6)
  }


}