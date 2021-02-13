package com.knoldus.validator

import com.knoldus.db.CompanyReadDto
import com.knoldus.models.User
import com.knoldus.models.Company
import org.scalatest.flatspec.AnyFlatSpec
import org.mockito.MockitoSugar.{mock, when}

class UserValidatorTest extends AnyFlatSpec {

  val googleCompany: Company = Company("Google", "google@gmail.com", "Noida")
  val komalUser: User = User("Komal","Verma","knoldus","komal@knoldus.com")
  val mockedCompanyREadDto = mock[CompanyReadDto]
  val mockedEmailValidator = mock[EmailValidator]

  "User" should "be a valid user" in{

    when(mockedCompanyREadDto.getCompanyByName(komalUser.companyName)) thenReturn(Option(googleCompany))
    when(mockedEmailValidator.emailIdIsValid(komalUser.emailId)) thenReturn(true)
    val userValidator= new UserValidator(mockedCompanyREadDto ,  mockedEmailValidator)
    val result=userValidator.userIsValid(komalUser)
    assert(result)
  }

  "User" should "be a invalid user as it already exists" in{

    when(mockedCompanyREadDto.getCompanyByName(komalUser.companyName)) thenReturn(None)
    when(mockedEmailValidator.emailIdIsValid(komalUser.emailId)) thenReturn(true)
    val userValidator= new UserValidator(mockedCompanyREadDto ,  mockedEmailValidator)
    val result=userValidator.userIsValid(komalUser)
    assert(!result)
  }

  "User" should "be a invalid user and email id is valid" in{

    when(mockedCompanyREadDto.getCompanyByName(komalUser.companyName)) thenReturn(Option(googleCompany))
    when(mockedEmailValidator.emailIdIsValid(komalUser.emailId)) thenReturn(false)
    val userValidator= new UserValidator(mockedCompanyREadDto ,  mockedEmailValidator)
    val result=userValidator.userIsValid(komalUser)
    assert(!result)
  }

  "User" should "be a invalid user and as email id is invalid" in{

    when(mockedCompanyREadDto.getCompanyByName(komalUser.companyName)) thenReturn(None)
    when(mockedEmailValidator.emailIdIsValid(komalUser.emailId)) thenReturn(false)
    val userValidator= new UserValidator(mockedCompanyREadDto ,  mockedEmailValidator)
    val result=userValidator.userIsValid(komalUser)
    assert(!result)
  }
}
