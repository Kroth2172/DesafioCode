package com.cadastro.desafio.controller;

import com.cadastro.desafio.model.Membro;
import com.cadastro.desafio.service.MembroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/membro")
public class MembroController {

    @Autowired
    MembroService membroService;

    @GetMapping(value = "/listar", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Membro>> listar() {
        try {
            List<Membro> retorno = membroService.listaMembros();
            if (retorno.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(retorno, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/salvar")
    public ResponseEntity<Membro> salvar(@RequestBody Membro membro) {
        try {
            return ResponseEntity.ok(membroService.salvar(membro));
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
