package br.com.fiap.parceiros.entity;

import br.com.fiap.parceiros.entity.vo.EnderecoVo;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ENDERECO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_endereco")
	private Long id;

	@Column(name = "logradouro")
	private String logradouro;

	@Column(name = "numero")
	private String numero;

	@Column(name = "complemento")
	private String complemento;

	@Column(name = "ponto_referencia")
	private String pontoReferencia;

	public Endereco(EnderecoVo vo) {
		this(
			vo.getId(),
			vo.getLogradouro(),
			vo.getNumero(),
			vo.getComplemento(),
			vo.getPontoReferencia()
		);
	}


}
