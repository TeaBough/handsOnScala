import org.scalatest.exceptions.TestPendingException
import org.scalatest.FunSuite
import org.scalatest.matchers.{Matcher, ShouldMatchers}

trait HandsOn extends FunSuite with ShouldMatchers {

  def __ : Matcher[Any] = {
    throw new TestPendingException
  }

  protected class ___ extends Exception {
    override def toString = "___"
  }

}
