package com.cds.nicroservicio.companiescrud.controllers;
/**
 * <p> Proyecto companies-crud.
 * <p> Clase CompanyController 22/5/2024.
 * <p> Copyright 2024 Consejo de la Judicatura.
 * <p> Todos los derechos reservados.
 */

import com.cds.nicroservicio.companiescrud.entities.Company;
import com.cds.nicroservicio.companiescrud.services.CompanyService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import java.net.URI;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * -- AQUI AÑADIR LA DESCRIPCION DE LA CLASE --.
 *
 * <p>Historial de cambios:
 *
 * <ul>
 *   <li>1.0.0 - Descripción del cambio inicial - jhonatan.almeida - 22/5/2024
 *       <!-- Añadir nuevas entradas de cambios aquí -->
 * </ul>
 *
 * @author jhonatan.almeida
 * @version 1.0.0 $
 * @since 22/5/2024
 */
@RestController
@AllArgsConstructor
@RequestMapping(path = "company")
@Slf4j
@Tag(name = "Companies resource")
public class CompanyController {
    private final CompanyService companyService;

    @Operation(summary = "Obtiene la companía por su nombre")
    @GetMapping(path = "{name}")
    public ResponseEntity<Company> get(@PathVariable String name){
        log.info("GET: company{}", name);
        return  ResponseEntity.ok(this.companyService.readByName(name));
    }

    @Operation(summary = "inserta(post) en la Base de Datos la companía con los datos correspondientes")
    @PostMapping
    public ResponseEntity<Company> post(@RequestBody Company company){
        log.info("POST: company{}", company.getName());
        return ResponseEntity.created(URI.create(this.companyService.create(company).getName())).build();
    }

    @Operation(summary = "Modifica (put) en la Base de Datos la companía con los datos correspondientes")
    @PutMapping(path = "{name}")
    public ResponseEntity<Company> put(@RequestBody Company company,@PathVariable String name){
        log.info("PUT: company{}", name);
        return  ResponseEntity.ok(this.companyService.update(company, name));
    }

    @Operation(summary = "Elimina (delete) en la Base de Datos la companía")
    @DeleteMapping(path = "{name}")
    public ResponseEntity<?> delete(@PathVariable String name){
        log.info("DELETE: company{}", name);
        this.companyService.delete(name);
        return ResponseEntity.noContent().build();
    }
}
