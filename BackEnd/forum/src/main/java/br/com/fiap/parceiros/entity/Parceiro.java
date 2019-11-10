package br.com.fiap.parceiros.entity;

import br.com.fiap.parceiros.entity.vo.ParceiroVo;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PARCEIRO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Parceiro {

    @Column(name = "id_parceiro")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "sobrenome")
    private String sobrenome;

    @Column(name = "email")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco", referencedColumnName = "id_endereco")
    private Endereco enderecoParceiro;

    public Parceiro(ParceiroVo vo) {
        this(
            vo.getId(),
            vo.getNome(),
            vo.getSobrenome(),
            vo.getEmail(),
            vo.getEndereco()
        );
    }

}