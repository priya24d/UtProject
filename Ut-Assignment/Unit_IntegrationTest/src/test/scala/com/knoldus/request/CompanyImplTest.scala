package com.knoldus.request

import org.mockito.MockitoSugar.{mock, when}
import com.knoldus.models.Company
import com.knoldus.validator.CompanyValidator
import org.scalatest.flatspec.AnyFlatSpec


class CompanyImplTest extends AnyFlatSpec {

  val mockedCompanyValidate = mock[CompanyValidator]
  val knoldusCompany: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")
  val googleCompany: Company = Company("Google", "google@gmail.com", "Noida")

  "Company" should "be created" in {

    val companyImpl = new CompanyImpl(mockedCompanyValidate)
    when(mockedCompanyValidate.companyIsValid(knoldusCompany)) thenReturn (true)
    val result = companyImpl.createCompany(knoldusCompany)
    assert(!result.isEmpty)
  }

  "Company" should "not be created" in {

    val companyImpl = new CompanyImpl(mockedCompanyValidate)
    when(mockedCompanyValidate.companyIsValid(googleCompany)) thenReturn (false)
    val result = companyImpl.createCompany(googleCompany)
    assert(result.isEmpty)
  }
}
