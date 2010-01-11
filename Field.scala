/** 
 *
 *
 *
 * @author: Tom Johnson
 **/


package marc

import scala.collection.mutable.Map

class Field(tag: Int, i1: Int, i2: Int, subfields: Map[Char, String]) { 

  //add additional constructors

  var ind1 = i1
  var ind2 = i2
  
  def get: (Int, Int, Int, Map[Char, String]) = (tag, ind1, ind2, subfields) // returns field data as a tuple.
  def getStr: String = tag.toString + " " + ind1.toString + ind2.toString + " " + subfieldStr // returns field data as a string.

  /**
   * subfield handling methods
   **/
   // returns subfield as sorted list.
  def subfieldList: List[(Char,String)] = subfields.toList.sort((a,b) => a < b)
  def subfieldStr(k: Char): String = "$" + k + subfields.apply(k)
  def subfieldStr(k: String): String = subfieldStr(k(0))
  def subfieldStr: String = { 
    var a: String = "" 
    subfieldList foreach((li) => a += subfieldStr(li._1))
    a
  }
  def updateSubfield(code: Char, data: String) = {
    subfields += code -> data
  } 
}

//object Field {
  //hashes for field and subfield structure...

//  def checkValid(f: Field): Boolean = true //replace with real check algorithim

//}
