package com.yogeshspringproject.banking_app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="accounts")
@Entity
public class Account {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="account_number")
private Long id;

@Column(name="account_holder_name")
private String accountHolderName;
private double balance;
}
