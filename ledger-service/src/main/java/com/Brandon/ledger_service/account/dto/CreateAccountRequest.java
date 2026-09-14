package com.Brandon.ledger_service.account.dto;


import com.Brandon.ledger_service.account.AccountType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;


public class CreateAccountRequest {
  private UUID ownerId;

  @NotNull(message = "account is  required")
  private AccountType accountType;

  @NotBlank(message = "currency is required")
  @Size(min = 3 , max = 3 , message = "currency must be a 3-letter ISO code")
  private String currency;

  @NotBlank(message = "name is required")
  private String name;

  public CreateAccountRequest(){

  }

  public UUID getOwnerId(){
    return ownerId;
  }
  public void setOwnerId(UUID ownerId){
    this.ownerId = ownerId;
  }
  public AccountType getAccountType(){
    return accountType;
  }
  public void getAccountType( AccountType accountType){
    this.accountType = accountType;
  }
  public String getCurrency(){
    return currency;
  }
  public void getCurrency(String currency){
    this.currency = currency;
  }
  
  public String getName(){
    return name;
  }
  public void setName(String name){
    this.name = name;
  }
















}

