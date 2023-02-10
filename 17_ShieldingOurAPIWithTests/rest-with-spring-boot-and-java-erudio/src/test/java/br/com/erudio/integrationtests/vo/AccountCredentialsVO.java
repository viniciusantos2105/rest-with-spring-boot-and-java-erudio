package br.com.erudio.integrationtests.vo;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountCredentialsVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String username;
	private String password;


}
