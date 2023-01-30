package br.com.erudio.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import org.junit.jupiter.api.Order;

import java.io.Serializable;

@Data
public class PersonVO implements Serializable
{
	private static final long serialVersionUID = 1L;

	private Long id;

	private String firstName;

	private String lastName;

	private String address;

	private String gender;
}
