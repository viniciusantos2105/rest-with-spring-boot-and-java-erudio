package br.com.erudio.integrationtests.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Date;

@Data
@XmlRootElement
public class BookVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String author;

	private Date launchDate;

	private Double price;

	private String title;
}
