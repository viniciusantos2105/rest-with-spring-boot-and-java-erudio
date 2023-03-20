package br.com.erudio.data.vo.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;
import jakarta.persistence.Column;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

@Data
@JsonPropertyOrder({"id", "address", "firstName", "lastName", "gender"})
public class PersonVO extends RepresentationModel<PersonVO> implements Serializable
{
	private static final long serialVersionUID = 1L;

	@JsonProperty("id")
	@Mapping("id")
	private Long key;

	private String firstName;

	private String lastName;

	private String address;

	private String gender;

	private Boolean enabled;
}
