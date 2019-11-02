package br.com.fiap.parceiros.restcontroller;

import br.com.fiap.parceiros.entity.Parceiro;
import br.com.fiap.parceiros.entity.vo.ParceiroVo;
import br.com.fiap.parceiros.service.ParceiroService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Parceiro")
@RestController
@RequestMapping("/api/parceiro")
public class ParceiroController {

    @Autowired
    private ParceiroService service;

    @ApiOperation(value = "Listar todos os parceiros")
    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ParceiroVo> listaParceiros() {
        return service.findAll();
    }

    @ApiOperation(value = "Criar um novo parceiro")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Parceiro> salvaParceiro(@RequestBody ParceiroVo parceiro) {
        return ResponseEntity.ok(service.salvaParceiro(parceiro));
    }

}
