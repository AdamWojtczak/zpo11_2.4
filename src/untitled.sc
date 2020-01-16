import scala.util.Try

var result = 0
var liczba = 0
var stary_operator = ""
var flaga = false
//val string="-3 + 4 - 1 + 1 + 12 - 5 + 6"
val string = "-12 - 7 + 3"
val splitted = string.split(" ")
for(c <- splitted){
  print(c)
  c match {
    case "+" =>
      stary_operator = "+"
    case "-" =>
      stary_operator = "-"
    case a
      if Try(a.toInt).isSuccess =>
      liczba=a.toInt;
      flaga = true
    case _ =>
      throw new NumberFormatException
  }
  if(flaga) {
    if (stary_operator == "+")
      result = result + liczba
    else if (stary_operator == "-")
      result = result - liczba
    else if (stary_operator == "")
      result = liczba
  }
  flaga = false

}
print("Wynik " + result)