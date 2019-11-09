package br.com.fiap.parceiros.entity.vo;

import br.com.fiap.parceiros.entity.Endereco;
import br.com.fiap.parceiros.entity.Parceiro;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParceiroVo {

    private Long id;

    private String nome;

    private String sobrenome;

    private String email;

    private EnderecoVo endereco;

    public ParceiroVo(Parceiro entity) {
        this(
            entity.getId(),
            entity.getNome(),
            entity.getSobrenome(),
            entity.getEmail(),
            Optional.ofNullable(entity.getEnderecoParceiro()).map(EnderecoVo::new).orElse(null)
        );
    }

}
