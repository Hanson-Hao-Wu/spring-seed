package org.hao.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity // This tells Hibernate to make a table out of this class
public class Customer {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	
    private String firstName, lastName;

}
