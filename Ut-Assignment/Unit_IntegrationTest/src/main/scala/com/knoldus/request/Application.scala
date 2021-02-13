package com.knoldus.request
import com.knoldus.db.{CompanyReadDto, UserReadDto}
import com.knoldus.models.Company
import com.knoldus.validator.{EmailValidator, CompanyValidator}

object Application {
  def main(args: Array[String]) = {
    val companyReadDto = new CompanyReadDto
    val emailValidator = new EmailValidator
    val companyValidator = new CompanyValidator(companyReadDto, emailValidator)
    val companyImpl = new CompanyImpl(companyValidator)
    val company: Company = Company("Priya", "knoldus@gmail.com", "Noida")
    val result =  companyImpl.createCompany(company)
    println(result)
  }
}