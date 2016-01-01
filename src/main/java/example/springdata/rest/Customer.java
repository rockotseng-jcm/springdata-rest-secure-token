package example.springdata.rest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Customer {

	private @Id @GeneratedValue Long id;
	private final String firstName, lastName;

	public Customer() {
		this.firstName = null;
		this.lastName = null;
	}
}
