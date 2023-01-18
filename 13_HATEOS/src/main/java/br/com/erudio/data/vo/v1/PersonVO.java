package br.com.erudio.data.vo.v1;

import com.github.dozermapper.core.Mapping;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonVO extends RepresentationModel<PersonVO> implements Serializable {


    private static final long serialVersionUID = 1L;

    @Mapping("id")
    private Long key;
    private String firstName;
    private String lastName;
    private String address;
    private String gender;
}
