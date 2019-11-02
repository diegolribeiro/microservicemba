package br.com.fiap.parceiros.entity.vo;

import br.com.fiap.parceiros.entity.Endereco;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoVo {

    private Long id;

    private String logradouro;

    private String numero;

    private String complemento;

    private String pontoReferencia;

    public EnderecoVo(Endereco entity) {
        this(
            entity.getId(),
            entity.getLogradouro(),
            entity.getNumero(),
            entity.getComplemento(),
            entity.getPontoReferencia()
        );
    }

}
