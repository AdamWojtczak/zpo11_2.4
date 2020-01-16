import scala.util.Try

object Password {
  def JednaWielka(string:String): Boolean = {
    for (c <- string)
      if (c.isUpper == true)
        true
    false
  }
  def JednaMala(string:String): Boolean = {
    for (c <- string)
      if (c.isLower == true)
        true
    false
  }
  def JednaCyfra(string:String): Boolean = {
    for (c <- string)
      if (Try(c.toInt).isSuccess)
        true
    false
  }
  def DwieCyfry(string:String): Boolean = {
    var x = 0
    for (c <- string)
      if (Try(c.toInt).isSuccess)
        x += 1
    if (x > 1)
      true
    false
  }
  def iloscCyfr(callback: String => Boolean, string:String): Boolean = {
    return callback(string);
  }
  def dlugosc(min_len: Int) (max_len: Int) (string:String): Boolean= {
    if (string.length() < min_len)
      false
    if (string.length() > max_len)
      false
    true
  }
  def test(string:String): Boolean = {
    val testDlugosci = dlugosc(3)(10)_
    var x = 0
    if (iloscCyfr(DwieCyfry,string) == true)
      print("ilosc ok")
    if (JednaMala(string) == true)
      print("jedna mala ok")
    if (JednaWielka(string)== true)
      print("Jedna Wileka ok")
    if (testDlugosci(string)== true)
      print("Dlugosc ok")
    true
  }
  def main(args: Array[String]): Unit =
  {
    val haslo = "test"
    test(haslo)
  }
}