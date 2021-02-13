package com.knoldus

import org.scalatest.flatspec.AnyFlatSpec

class EmailValidTest extends AnyFlatSpec{

  val emailValidator = new EmailValid

  "email" should "have alphanumeric username in lowercase and uppercase " in {

    var result: Boolean = emailValidator.isValidEmail("priya@knoldus.com")
    assert(result == true)
  }

  "email" should "valid when with starting numbers" in {

    var result: Boolean = emailValidator.isValidEmail("1priya@knoldus.com")
    assert(result == true)
  }

  "email" should "invalid with missing @" in {

    var result: Boolean = emailValidator.isValidEmail("priyaknoldus.com")
    assert(result == false)
  }

  "email" should "invalid with starting with special symbols except dot and underscore" in {

    var result: Boolean = emailValidator.isValidEmail("*/priyaknoldus.com")
    assert(result == false)
  }

  "email" should "invalid with space in between" in {

    var result: Boolean = emailValidator.isValidEmail("priya @knoldus.com")
    assert(result == false)
  }

  "email" should "invalid with missing top level domain" in {

    var result: Boolean = emailValidator.isValidEmail("priya@knoldus")
    assert(result == false)
  }

  "email" should "invalid with missing domain main" in {

    var result: Boolean = emailValidator.isValidEmail("priya@.com")
    assert(result == false)
  }

  "email" should "invalid when wrong top level domain except .com/.org/.net" in {

    var result: Boolean = emailValidator.isValidEmail("priya@knoldus.xyz")
    assert(result == false)
  }

  "email" should "invalid with more than one top level domain" in {

    var result: Boolean = emailValidator.isValidEmail("priya@knoldus.com.net")
    assert(result == false)
  }

  "email" should "invalid with double dots after domain name" in {

    var result: Boolean = emailValidator.isValidEmail("priya@knoldus..com")
    assert(result == false)
  }
}
