package br.com.erudio.data.vo.v1.security;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

import java.io.Serializable;

@Data
public class AccountCredentialsVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String username;
	private String password;
}
