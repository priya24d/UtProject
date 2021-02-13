package com.knoldus

class EmailValid {                    //return if email is valid or not

  def isValidEmail(emailid: String) :Boolean={

    var regex= """^([_|a-zA-Z\d\.-]+)@([a-zA-Z\d-]+)\.(com|net|org)$"""
    return emailid.matches(regex);
  }

  def main(args:Array[String]) ={

    val ch= isValidEmail("try@gmail.com")
    println(ch)
  }
}
