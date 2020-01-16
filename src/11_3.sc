import scala.collection.mutable.ListBuffer


def functionName (string: String) : Boolean =
{
  var binar_parenthesis = new ListBuffer[Int]()
  var x = 0
  for (c <- string) {
    c match {
      case '(' =>
        binar_parenthesis += 1
        x += 1
      case ')' =>
        binar_parenthesis += -1
        x -= 1
      case _ =>
    }
    if (x < 0)
      return false
  }
  val result = binar_parenthesis.foldLeft(0) (_+_)
  if (result == 0)
    true
  else
    false
}

assert(functionName("))((") == false)
assert(functionName("(()(ab)c)"))
assert(functionName("((()())") == false)
assert(functionName("(()))(") == false)
assert(functionName("(aa(b)()c)d"))