package com.Brandon.user_service.user;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.UUID;


@Entity
@Table(name = "users")
public class User {


  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;


  @Column(nullable = false, unique = true , name = "email")
  private String email;


  @Column(nullable = false)
  private String passwordHash;
 
  @Enumerated(EnumType.STRING)
  @Column(name = "user_type", nullable = false)
  private UserType userType;


  @Column(name = "created_at", nullable = false, updatable = false)
  private Instant createdAt;

  protected User() {

  }



















}
