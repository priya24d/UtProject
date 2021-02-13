package com.knoldus.validator

class EmailValidator {

  def emailIdIsValid(emailId: String): Boolean = {

    var regex= """^([_|a-zA-Z\d\.-]+)@([a-zA-Z\d-]+)\.(com|net|org)$"""
    return emailId.matches(regex);
  }
}
