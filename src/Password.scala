import scala.util.Try

object Password {
  def JednaWielka(string:String): Boolean = {
    return string.exists(_.isUpper)
  }
  def JednaMala(string:String): Boolean = {
    return string.exists(_.isLower)
  }
  def JednaCyfra(string:String): Boolean = {
    var x = false
    for (c <- string)
    {
      if (c.isDigit)
      {
        x = true
      }

    }
    return x
  }
  def DwieCyfry(string:String): Boolean = {
    var x = 0
    for (c <- string)
    {
      if (c.isDigit)
      {
        x += 1
      }
    }
    if (x > 1)
    {
      true
    }
    else
    {
      false
    }
  }
  def iloscCyfr(callback: String => Boolean, string:String): Boolean = {
    val x = callback(string)
    return x;
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
    if (iloscCyfr(JednaCyfra,string) == true)
      println("ilosc cyfr ok")
    if (JednaMala(string) == true)
      println("jedna mala ok")
    if (JednaWielka(string)== true)
      println("Jedna Wileka ok")
    if (testDlugosci(string)== true)
      println("Dlugosc ok")
    true
  }
  def main(args: Array[String]): Unit =
  {
    val haslo = "Test123"
    test(haslo)
  }
}