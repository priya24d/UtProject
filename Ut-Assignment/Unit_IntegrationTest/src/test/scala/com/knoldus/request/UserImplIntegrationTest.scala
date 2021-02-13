package com.knoldus.request

import com.knoldus.db.{CompanyReadDto, UserReadDto}
import com.knoldus.models.User
import com.knoldus.validator.{EmailValidator, UserValidator}
import org.scalatest.flatspec.AnyFlatSpec

class UserImplIntegrationTest extends AnyFlatSpec {

  val companyReadDto = new CompanyReadDto
  val emailValidator = new EmailValidator
  val userValidator = new UserValidator(companyReadDto, emailValidator)
  val userImpl = new UserImpl(userValidator)

  "User" should "be valid" in {

    val priyaUser: User = User("Priya","Dahiya","Knoldus","priya.dahiya@knoldus.com")
    val result =  userImpl.createUser(priyaUser)
    assert(!result.isEmpty)
  }

  "User" should "be invalid as it company doesnot exists in DB" in {

    val karanUser: User = User("Karan","Sharma","Google","karan@knoldus.com")
    val result =  userImpl.createUser(karanUser)
    assert(result.isEmpty)
  }

  "Employee" should "be invalid as email id is invalid" in {

    val priyaEmployee: User = User("Priya","Dahiya","Knoldus","priya.dahiyaknoldus.com")
    val result = userImpl.createUser(priyaEmployee)
    assert(result.isEmpty)
  }

  "Employee" should "be invalid as email id is invalid and company does not exists in DB" in {

    val priyaUser: User = User("Priya","Dahiya","Google","priya.dahiyaknoldus.com")
    val result =  userImpl.createUser(priyaUser)
    assert(result.isEmpty)
  }
}
