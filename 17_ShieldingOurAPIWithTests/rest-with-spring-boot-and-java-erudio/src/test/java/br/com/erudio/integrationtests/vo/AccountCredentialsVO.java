package br.com.erudio.integrationtests.vo;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@XmlRootElement
@NoArgsConstructor
@AllArgsConstructor
public class AccountCredentialsVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String username;
	private String password;


}
